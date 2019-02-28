package com.lcworld.utils.freemarker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.oss.internal.OSSUtils;
import com.lcworld.oss.OSSFactory;
import com.lcworld.utils.DateUtils;
import com.lcworld.utils.util.ValidateUtil;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreemarkerUtil {

	private Logger log = LoggerFactory.getLogger(FreemarkerUtil.class);
	private String realPath;
	private URL resource;
	private Configuration configuration;
	private static FreemarkerUtil freemarkerUtil;

	public static FreemarkerUtil getInstance() {
		if (freemarkerUtil == null) {
			synchronized (FreemarkerUtil.class) {
				if (freemarkerUtil == null) {
					freemarkerUtil = new FreemarkerUtil();
				}
			}
		}
		return freemarkerUtil;
	}

	// 获取或创建一个模版。
	public Template getTemplate(String file) {
		try {
			return configuration.getTemplate(file);
		} catch (Exception e) {
			log.error("获取freemarker模板异常", e);
		}
		return null;
	}

	// 设置输出文件
	public Writer getOutputStreamWriter(String outFileName) {
		if (!ValidateUtil.isValid(realPath)) {
			initRealPath();
		}
		try {
			File file = new File(this.realPath + outFileName);
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			return new OutputStreamWriter(new FileOutputStream(this.realPath + outFileName), "UTF-8");
		} catch (Exception e) {
			log.error("渲染商品数据生成文件异常。", e);
		}
		return null;
	}

	private void initRealPath() {
		this.realPath = new File(resource.getFile()).getParentFile().getParentFile().getParentFile().getPath()+"/";

		// 创建相关业务文件夹
		createFolder();
	}

	private void createFolder() {
		// 商品详情
		new File(this.realPath + FreemarkerWriterFileNames.FREEMARKER_PRODUCT_DETAIL_FOLDER).mkdir();
		// 商品流程
		new File(this.realPath + FreemarkerWriterFileNames.FREEMARKER_PRODUCT_PROCESS_FOLDER).mkdir();
		// 医生端资料文件
		new File(this.realPath + FreemarkerWriterFileNames.FREEMARKER_PRODUCT_CONSULTATION_FOLDER).mkdir();
		// 用户端资讯文件夹
		new File(this.realPath + FreemarkerWriterFileNames.FREEMARKER_PRODUCT_HEALTHY_INFOMATION_FOLDER).mkdir();
	}

	private FreemarkerUtil() {
		init();
	}

	private void init() {
		resource = FreemarkerUtil.class.getClassLoader().getResource("ftl");
		// 创建一个合适的Configration对象
		configuration = new Configuration();
		try {
			configuration.setDirectoryForTemplateLoading(new File(resource.getFile()));
		} catch (IOException e) {
			log.error("实例化freemarker异常", e);
		}
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setDefaultEncoding("UTF-8"); // 这个一定要设置，不然在生成的页面中 会乱码

	}
	protected String generatorHtml(String description,String outFileName,HttpServletRequest request,String dir) throws Exception {
		// 生成详情描述文件
	    Template template = FreemarkerUtil.getInstance().getTemplate(FreemarkerWriterFileNames.FREEMARKER_PRODUCT_FTL_FOLDER);
	    Writer writer  = FreemarkerUtil.getInstance().getOutputStreamWriter(outFileName);
	    
	    // 嵌套数据
	    Map<String, Object> paramMap = new HashMap<String, Object>();  
	    paramMap.put("description", description);
	    template.process(paramMap, writer);
	    
	    // 读取本地文件
	    File file = new File(request.getSession().getServletContext().getRealPath("/")+outFileName);
	    // 上传至阿里云
	    String trueFileName = dir+DateUtils.format(new Date(), "yyyyMMdd")+String.valueOf(System.currentTimeMillis())+".html";
		String url = OSSFactory.build().upload(new FileInputStream(file), trueFileName);
		return url;
	}
}
