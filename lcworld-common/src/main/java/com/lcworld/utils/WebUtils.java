package com.lcworld.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * web 工具
 * 
 * @author Administrator
 *
 */
public class WebUtils {
    
    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";
	/**
	 * 不依赖spring 返回json
	 * 
	 * @param str
	 *            返回json 信息
	 * @param response
	 */
	public static void outJsonStringApplication(Object str, ServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/json");
			out.write(str.toString());
		} catch (IOException e) {
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 获取验证码
	 * 
	 * @return
	 */
	public static String getCapacha() {
		return RanderNumberUtils.getCheckCode(6);
	}

	/**
	 * 获取加密的密码
	 * 
	 * @param pass
	 * @return
	 */
	public static String getEncryptPassword(String pass) {
		return MD5.md5(pass);
	}

	/**
	 * 获取输入json
	 * 
	 * @param request
	 * @param key
	 *            键
	 * @return
	 */
	public static JSONObject getJsonInfo(ServletRequest request, String key) {
		String info = request.getParameter(key);
		JSONObject json = JSONObject.parseObject(info);
		return json;
	}

	/**
	 * 获取输入jsonarray
	 * 
	 * @param request
	 *            * @param key 键
	 * @return
	 */
	public static JSONArray getJsonArray(ServletRequest request, String key) {
		String info = request.getParameter(key);
		JSONArray array = JSONArray.parseArray(info);
		return array;
	}

	/**
	 * 创建page
	 * 默认page=1 ,pagesize =10
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public static Map<String, Object> page_from_A_to_C(Integer page, Integer pageSize, Integer defaultPageSize) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		pageSize = ValidateUtil.isValid(pageSize) ? pageSize : defaultPageSize;
		page =  ValidateUtil.isValid(page) ? page : 1;
		int startPage = (page - 1) * pageSize;
		int endPage = page * pageSize;
		queryMap.put("startIndex", startPage);
		queryMap.put("endIndex", endPage);
		return queryMap;
	}

	/**
	 * 订单号生成
	 * 
	 * @param uid
	 *            用户id
	 * @param merchantId
	 *            商户id
	 * @param papams
	 * @return
	 */
	public static String createOrderCode(String uid, String merchantId) {
		StringBuffer sbf = new StringBuffer();
		sbf.append(uid.substring(uid.length() - 2, uid.length()));
		String cur = new Long(System.currentTimeMillis()).toString();
		sbf.append(new Long(cur).toString().substring(2));
		sbf.append(merchantId.substring(merchantId.length() - 2, merchantId.length()));
		sbf.append(RanderNumberUtils.getCheckCode(1));
		return sbf.toString();
	}

	/**
	 * 创建ids
	 * 
	 * @param orderList
	 * @param key
	 * @return
	 */
	public static List<Integer> createIds(List<Map<String, Object>> orderList, String key) {
		List<Integer> ids = new ArrayList<Integer>();
		if (ValidateUtil.isValid(orderList)) {
			for (Map<String, Object> m : orderList) {
				Integer k = null;
				try {
					k = Integer.parseInt(String.valueOf(m.get(key)));
				} catch (Exception e) {
					continue;
				}
				if (!ids.contains(k)) {
					ids.add(k);
				}
			}
		}
		return ids;
	}

	/**
	 * @param map
	 * @param list
	 * @param key1
	 *            map 中的key
	 * @param key2
	 *            list 中的key 若list 中的key对应值于与map 中dirmap 中的key1值 相同,将list
	 *            中的值以subkey为键放入map
	 * @param subkey
	 * @param dirmap
	 * @param iscreate
	 *            是否为创建map 中的一级子map
	 */
	@SuppressWarnings("unchecked")
	public static void addToMap(Map<String, Map<String, Object>> map, List<Map<String, Object>> list, String key1,
			String key2, String subkey, String dirmap, boolean iscreate) {
		if (iscreate) {
			if (ValidateUtil.isValid(list)) {
				for (Map<String, Object> m : list) {
					Integer keyStr = Integer.parseInt(String.valueOf(m.get(key2)).trim());
					if (ValidateUtil.isValid(keyStr) && !map.containsKey(keyStr)) {
						Map<String, Object> tmap = new HashMap<String, Object>();
						tmap.put(subkey, m);
						map.put(keyStr.toString(), tmap);
					}
				}
			}
		} else {
			if (ValidateUtil.isValid(list)) {
				for (Map<String, Object> m : list) {
					for (Entry<String, Map<String, Object>> en : map.entrySet()) {
						for (Entry<String, Object> entry : en.getValue().entrySet()) {
							HashMap<String, Object> hashMap;
							try {
								hashMap = (HashMap<String, Object>) entry.getValue();
							} catch (Exception e1) {
								continue;
							}
							if (ValidateUtil.isValid(dirmap) && dirmap.equalsIgnoreCase(entry.getKey())) {
								for (Entry<String, Object> e : hashMap.entrySet()) {
									
									if (key1.equals(e.getKey()) && ValidateUtil.isValid(e.getValue())) {
										if (String.valueOf(e.getValue()).equals(String.valueOf(m.get(key2)))
												&& !en.getValue().containsKey(subkey)) {
											en.getValue().put(subkey, deepCopy(m));
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}
	
	public static Map<String,Object> deepCopy(Map<String,Object> map){
		Map<String,Object> newmap = new HashMap<String,Object>();
		if(map !=null){
			newmap.putAll(map);
		}
		return newmap;
	}

	/**
	 * 
	 * 上传文件并返回上传地址,多个用逗号分割
	 * 
	 * @param files
	 *            上传的文件
	 * @param request
	 * @param ossdir
	 *            oss中的目录，见OSSConstantKey
	 * @param filterType
	 *            允许的文件类型数组
	 * @return errorCode :0 成功 ; -1: 文件类型异常 ，-2：上传sso失败，-3：上传文件类型不一致
	 * 
	 */
	public static JSONObject uploadFiles(MultipartFile[] files, HttpServletRequest request, String ossdir,
			String[] filterTypes) {
		JSONObject result = new JSONObject();
		result.put("errorCode", 0);
		if (ValidateUtil.isValid(files)) {
			StringBuilder sb = new StringBuilder();
			JSONObject obj = checkFileTypes(files, filterTypes);
			if (0 == obj.getIntValue("errorCode")) {
				for (MultipartFile file : files) {
					String fileName = file.getOriginalFilename();// 文件原名称
					String type = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
					String trueFileName = ossdir + DateUtil.getDateStringToday()
							+ String.valueOf(System.currentTimeMillis()) + "." + type;
					try {
						OSSUtils.uploadFile(trueFileName, file.getInputStream());
						String url = OSSConstantKey.OSS_BASE_URL + trueFileName;
						sb.append(",").append(url);
					} catch (Exception e) {
						result.put("errorCode", 1);
						result.put("msg", "上传sso失败");
					}
				}
				result.put("data", sb.toString().substring(1));
			} else {
				return obj;
			}
		}
		return result;

	}
	
	/**
	 * 
	 * 上传文件并返回上传地址,多个用逗号分割
	 * 
	 * @param files
	 *            上传的文件
	 * @param request
	 * @param ossdir
	 *            oss中的目录，见OSSConstantKey
	 * @param filterType
	 *            允许的文件类型数组
	 *            
	 * @param uniqueType 是否唯一文件类型
	 * @return 
	 *         errorCode :0 成功 ; -1: 文件类型异常 ，-2：上传sso失败      -3：上传文件类型不一致
	 *         json 中的data 为jsonarray ,内部obj 结构：{“fileName”，“1”，“fileType”：“2”，“fileSize”：3 } 其中filesize 单位为k
	 * 
	 * 
	 */
	public static JSONObject uploadFiles1(MultipartFile[] files, HttpServletRequest request, String ossdir,
	        String[] filterTypes,boolean uniqueType) {
	    JSONObject result = new JSONObject();
	    result.put("errorCode", 0);
	    if (ValidateUtil.isValid(files)) {
	        JSONArray array = new JSONArray(files.length);
	        JSONObject obj = checkFileTypes(files, filterTypes);
	        if (0 == obj.getIntValue("errorCode")) {
	            for (MultipartFile file : files) {
	                JSONObject fobj = new JSONObject();
	                String fileName = file.getOriginalFilename();// 文件原名称
	                String type = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
	                String trueFileName = ossdir + DateUtil.getDateStringToday()
	                + String.valueOf(System.currentTimeMillis()) + "." + type;
	                try {
	                    OSSUtils.uploadFile(trueFileName, file.getInputStream());
	                } catch (Exception e) {
	                    result.put("errorCode", 1);
	                    result.put("msg", "上传sso失败");
	                }
	                String url = OSSConstantKey.OSS_BASE_URL + trueFileName;
	                fobj.put("fileName", url);
	                fobj.put("fileType", type);
	                fobj.put("fileSize", file.getSize());
	                fobj.put("name", file.getOriginalFilename());
	                array.add(fobj);
	            }
	            result.put("data", array);
	        } else {
	            return obj;
	        }
	    }
	    return result;
	    
	}

	/**
	 * 检查上传文件类型
	 * 
	 * @param files
	 * @param filterTypes
	 * @return
	 */
	public static JSONObject checkFileTypes(MultipartFile[] files, String[] filterTypes) {
		return checkFileTypes(files, filterTypes,false);
	}
	
	/**
	 * 检查上传文件类型
	 * 
	 * @param files
	 * @param filterTypes
	 * @param uniqueType 强制唯一文件类型
	 * @return
	 */
	public static JSONObject checkFileTypes(MultipartFile[] files, String[] filterTypes,boolean uniqueType) {
	    JSONObject result = new JSONObject();
	    result.put("errorCode", 0);
	    List<String> fileTypeList = new ArrayList<String>();
	    for (MultipartFile file : files) {
	        String fileName = file.getOriginalFilename();// 文件原名称
	        // 判断文件类型
	        String type = fileName.indexOf(".") != -1
	                ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
	                boolean flag = false;
	                if (type != null) {// 判断文件类型是否为空
	                    if (ValidateUtil.isValid(filterTypes)) {
	                        for (String type1 : filterTypes) {
	                            if (ValidateUtil.isValid(type1) && type.equalsIgnoreCase(type1)) {
	                                if(uniqueType){
	                                    if(fileTypeList.contains(type1)){
	                                        result.put("errorCode", -1);
	                                        result.put("msg", "所有文件类型不一致");
	                                        return result;
	                                    }
	                                }
	                                fileTypeList.add(type1);
	                                flag = true;
	                                break;
	                            }
	                        }
	                        if (!flag) {
	                            result.put("errorCode", -1);
	                            result.put("msg", "文件格式不符");
	                            return result;
	                        }
	                    }
	                } else {
	                    result.put("errorCode", -1);
	                    result.put("msg", "文件格式不符");
	                    return result;
	                }
	    }
	    return result;
	}
	
	/**
	 * 获取文件类型
	 * @param fileName
	 * @return
	 */
	public static String getFileType(String fileName){
	   if( ValidateUtil.isValid(fileName)){
	        return fileName.indexOf(".") != -1?fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
	    }
	    return null;
	}
	
	 /**求交集
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static Integer[] intersect(List<Integer> arr1, List<Integer> arr2){
	        List<Integer> l = new LinkedList<Integer>();
	        Set<Integer> common = new HashSet<Integer>();                  
	        for(Integer str:arr1){
	            if(!l.contains(str)){
	                l.add(str);
	            }
	        }
	        for(Integer str:arr2){
	            if(l.contains(str)){
	                common.add(str);
	            }
	        }
	        Integer[] result={};
	        return common.toArray(result);
	    }
	
	  /**合并
     * @param list1
     * @param list2
     * @return
     */
    public static  List<Integer> union(List<Integer> list1, List<Integer> list2) {
        List<Integer> ids = new ArrayList<Integer>();
        if(ValidateUtil.isValid(list1)){
            for(Integer id : list1){
                if(!ids.contains(id)){
                    ids.add(id);
                }
            }
        }
        
        if(ValidateUtil.isValid(list2)){
            for(Integer id : list2){
                if(!ids.contains(id)){
                    ids.add(id);
                }
            }
        }
        return ids;
        
    }
    
  
    
  
    public static  String delHTMLTag(String htmlStr){ 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式   
        String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";  
        //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }   
        String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";    
        
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
        
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 
        
        htmlStr=htmlStr.replace(" ","");
        htmlStr=htmlStr.replaceAll("\\s*|\t|\r|\n","");
        htmlStr=htmlStr.replace("“","");
        htmlStr=htmlStr.replace("”","");
        htmlStr=htmlStr.replaceAll("　","");
          
        return htmlStr.trim(); //返回文本字符串 
    } 
    
    public static  String dealTag(String htmlStr){ 
        String regEx_style = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>|<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr);
        m_style.reset();
        boolean result = m_style.find();
        if (result) {
            StringBuffer sb = new StringBuffer();
            Integer start = m_style.start();
            Integer end = m_style.end();
            sb.append(htmlStr.substring(0,start));
            do {
                start = m_style.start();
                end = m_style.end();
                String s = htmlStr.substring(start, end);
                s = s.replaceAll("\\r|\n", "");
                sb.append(s);
                result = m_style.find(end);
            } while (result);
            sb.append(htmlStr.substring(end,htmlStr.length()));
            String tresult = sb.toString().replaceAll("\'", "\"");
            return tresult.replaceAll("\\r|\n", "");
        }
        return htmlStr.replaceAll("\'", "\"").replaceAll("\\r|\n", "");
       
    }
    
    public static Integer getUid(HttpServletRequest request){
        
        try {
           return  Integer.parseInt(String.valueOf(request.getAttribute(LOGIN_USER_KEY)));
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public static void main(String[] args) {
       String s ="2";
       JSONObject obj = new JSONObject();
       obj.put("s", s);
       System.out.println(obj.getBooleanValue("s"));
    }
    

}
