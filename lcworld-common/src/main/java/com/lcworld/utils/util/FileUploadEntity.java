package com.lcworld.utils.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;


public class FileUploadEntity {

    
	/**
	 * 文件2
	 */
	private MultipartFile imgFile2;
	
	public MultipartFile getImgFile2() {
		return imgFile2;
	}
	
	public void setImgFile2(MultipartFile imgFile2) {
		this.imgFile2 = imgFile2;
	}
    /**
     * 文件
     */
	private MultipartFile imgFile;
    private MultipartFile file;
    
    public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getImgFile() {
        return imgFile;
    }
 
    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
    
    @Override
	public String toString() {
		return "FileUploadEntity [imgFile2=" + imgFile2 + ", imgFile=" + imgFile + ", file=" + file + "]";
	}

	public String savePath(String path){
    	java.io.InputStream is;
    	String fileName=null;
    	try {
    		File dir=new File(path);
    		if(!dir.exists()){
    			dir.mkdirs();
    		}
    		is = imgFile.getInputStream();
    		fileName=UUID.randomUUID().toString()+imgFile.getOriginalFilename()
    							.substring(imgFile.getOriginalFilename().lastIndexOf("."));
    		FileOutputStream outputStream = new FileOutputStream(path+File.separator+fileName);   
    		System.out.println("fileName:"+fileName);
    		int byteCount = 0;
    		byte[] bytes = new byte[1024];
    		while((byteCount = is.read(bytes)) != -1){
    			outputStream.write(bytes, 0, byteCount);
    		}
    		outputStream.close();   
    		is.close();  
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		return fileName;
		
    }
    public String savePath2(String path){
    	java.io.InputStream is;
    		String fileName=null;
        try {
        		is = imgFile2.getInputStream();
//        		System.out.println("path:"+path);
        		fileName=UUID.randomUUID().toString()+imgFile2.getOriginalFilename()
        							.substring(imgFile2.getOriginalFilename().lastIndexOf("."));
    		FileOutputStream outputStream = new FileOutputStream(path+File.separator+fileName );   
    		int byteCount = 0;
    		byte[] bytes = new byte[1024];
    		while ((byteCount = is.read(bytes)) != -1){
    			outputStream.write(bytes, 0, byteCount);
    		}
    		outputStream.close();   
    		is.close();  
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return fileName;
    }
    public String savePathFile(String path){
    	java.io.InputStream is;
		String fileName=null;
    try {
    		is = file.getInputStream();
//    		System.out.println("path:"+path);
    		fileName=UUID.randomUUID().toString()+file.getOriginalFilename()
    							.substring(file.getOriginalFilename().lastIndexOf("."));
		FileOutputStream outputStream = new FileOutputStream(path+File.separator+fileName );   
		int byteCount = 0;
		byte[] bytes = new byte[1024];
		while ((byteCount = is.read(bytes)) != -1){
			outputStream.write(bytes, 0, byteCount);
		}
		outputStream.close();   
		is.close();  
	} catch (IOException e) {
		e.printStackTrace();
	}
	return fileName;
    }
    public boolean validateFile(){
        
        return true;
    }
    public static void downFile(HttpServletResponse response,String path1,HttpServletRequest request)throws IOException{
//    			URL url = new URL(PublicInfor.path+path1);
//    			// 打开连接
//    			URLConnection con = url.openConnection();
//    			String fileName1=getFilePath(path1, request);
//    			DownloadBaseAction downloadBaseAction=new DownloadBaseAction();
//    			downloadBaseAction.downloadIps(con.getInputStream(), fileName1, response, request);
    		}
    
    public static void main(String[] args) throws IOException {
	}

    /**
* 下载文件到本�?
*
* @param urlString
*            被下载的文件地址
* @param filename
*            本地文件�?
* @throws Exception
*             各种异常
*/
public static void download(String urlString, String filename)
 throws Exception {
// 构�?URL
URL url = new URL(urlString);
// 打开连接
URLConnection con = url.openConnection();
// 输入�?
InputStream is = con.getInputStream();

String code=con.getHeaderField("Content-Encoding");
System.out.println("cdoe:"+code);


if ((null!=code)&& code.equals("gzip"))
{
 GZIPInputStream gis = new GZIPInputStream(is);

 // 1K的数据缓�?
 byte[] bs = new byte[1024];
 // 读取到的数据长度
 int len;
 // 输出的文件流
 OutputStream os = new FileOutputStream(filename);
 // �?��读取
 while ((len = gis.read(bs)) != -1) {
  os.write(bs, 0, len);
 }
 // 完毕，关闭所有链�?
 gis.close();
 os.close();
 is.close();

}
else
{

 // 1K的数据缓�?
 byte[] bs = new byte[1024];
 // 读取到的数据长度
 int len;
 // 输出的文件流
 OutputStream os = new FileOutputStream(filename);
 // �?��读取
 while ((len = is.read(bs)) != -1) {
  os.write(bs, 0, len);
 }
 // 完毕，关闭所有链�?
 os.close();
 is.close();
}

}
}
