package com.lcworld.utils;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;

/**
 * 该示例代码展示了如果在OSS中创建和删除一个Bucket，以及如何上传和下载一个文件。
 * 
 * 该示例代码的执行过程是： 1. 创建一个Bucket（如果已经存在，则忽略错误码）； 2. 上传一个文件到OSS； 3. 下载这个文件到本地； 4.
 * 清理测试资源：删除Bucket及其中的所有Objects。
 * 
 * 尝试运行这段示例代码时需要注意： 1. 为了展示在删除Bucket时除了需要删除其中的Objects,
 * 示例代码最后为删除掉指定的Bucket，因为不要使用您的已经有资源的Bucket进行测试！ 2.
 * 请使用您的API授权密钥填充ACCESS_ID和ACCESS_KEY常量； 3.
 * 需要准确上传用的测试文件，并修改常量uploadFilePath为测试文件的路径； 修改常量downloadFilePath为下载文件的路径。 4.
 * 该程序仅为示例代码，仅供参考，并不能保证足够健壮。
 *
 */
public class OSSUtils {
	//// -------测试环境
	
	private static String ACCESS_ID = "MYSytDbTE08n4aYh";
	
	
	private static String ACCESS_KEY = "Pb8UFmNPI6y4JO8V840P6xOWWgi4WY";
	
	
	private static  String BUCKET_NAME = "dentist";

	public static String getBUCKET_NAME() {
        return BUCKET_NAME;
    }

    // static String endpoint = "http://oss-cn-beijing-internal.aliyuncs.com";
	public static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
	
	
	
//	@Value("${ACCESS_ID}")
	public  void setACCESS_ID(String aCCESS_ID) {
		ACCESS_ID = aCCESS_ID;
	}

//	@Value("${ACCESS_KEY}")
	public  void setACCESS_KEY(String aCCESS_KEY) {
		ACCESS_KEY = aCCESS_KEY;
	}

//	@Value("${BUCKET_NAME}")
	public  void setBUCKET_NAME(String bUCKET_NAME) {
		BUCKET_NAME = bUCKET_NAME;
	}

//	@Value("${endpoint}")
	public  void setEndpoint(String endpoint) {
		OSSUtils.endpoint = endpoint;
	}

	private static OSSClient client = null;

	static {
		client = new OSSClient(endpoint, ACCESS_ID, ACCESS_KEY);
	}

	// 上传文件
	public static void uploadFile(String filename, InputStream in) throws Exception {
		// File file = new File(filename);
		// String name = file.getName();
		// filename=URLEncoder.encode(filename, "UTF-8");

		ObjectMetadata objectMeta = new ObjectMetadata();
		objectMeta.setContentLength(in.available());
		// 可以在metadata中标记文件类型
		// String string = checktype(filename);
		// objectMeta.setContentType(string);

		// InputStream input = new FileInputStream(file);
		client.putObject(BUCKET_NAME, filename, in, objectMeta);
	}
	
	// 上传文件
	public static void uploadFile(String filename, InputStream in,String contentType) throws Exception {
	    // File file = new File(filename);
	    // String name = file.getName();
	    // filename=URLEncoder.encode(filename, "UTF-8");
	    
	    ObjectMetadata objectMeta = new ObjectMetadata();
	    objectMeta.setContentLength(in.available());
	    // 可以在metadata中标记文件类型
	    // String string = checktype(filename);
	     objectMeta.setContentType(contentType);
	    
	    // InputStream input = new FileInputStream(file);
	    client.putObject(BUCKET_NAME, filename, in, objectMeta);
	}

	// 下载文件
	public static InputStream downloadFile(String filename)
			throws OSSException, ClientException, UnsupportedEncodingException {
		// OSSObject object = client.getObject(new GetObjectRequest(bucketName,
		// key),
		// new File(filename));
		// filename=URLEncoder.encode(filename, "UTF-8");
		OSSObject object = client.getObject(BUCKET_NAME, filename);
		InputStream inputStream = object.getObjectContent();

		return inputStream;
	}

	public static String checktype(String filename) {
		String ContentType;
		switch (filename.substring(filename.lastIndexOf(".")).trim().toLowerCase()) {
		case ".asf":
			ContentType = "video/x-ms-asf";
			break;
		case ".avi":
			ContentType = "video/avi";
			break;
		case ".doc":
			ContentType = "application/msword";
			break;
		case ".docx":
			ContentType = "application/msword";
			break;
		case ".zip":
			ContentType = "application/zip";
			break;
		case ".xls":
			ContentType = "application/vnd.ms-excel";
			break;
		case ".gif":
			ContentType = "image/gif";
			break;
		case ".jpg":
			ContentType = "image/jpeg";
			break;
		case ".jpeg":
			ContentType = "image/jpeg";
			break;
		case ".png":
			ContentType = "image/png";
			break;
		case ".wav":
			ContentType = "audio/wav";
			break;
		case ".mp3":
			ContentType = "audio/mpeg3";
			break;
		case ".mpg":
			ContentType = "video/mpeg";
			break;
		case ".mepg":
			ContentType = "video/mpeg";
			break;
		case ".rtf":
			ContentType = "application/rtf";
			break;
		case ".html":
			ContentType = "text/html";
			break;
		case ".htm":
			ContentType = "text/html";
			break;
		case ".txt":
			ContentType = "text/plain";
			break;
		case ".apk":
			ContentType = "application/vnd.android.package-archive";
			break;
		case ".mp4":
			ContentType = "video/mpeg4";
			break;
		case ".wmv":
			ContentType = "video/x-ms-wmv";
			break;
		default:
			ContentType = "application/octet-stream";
			break;
		}
		return ContentType;
	}

}
