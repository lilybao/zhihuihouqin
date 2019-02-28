package com.lcworld.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTest {
	private static Configuration cfg;
	public static void printFile(String name,Map<String,Object> root,String outputFile) throws Exception
    {
  	  FileWriter out = null;
  	  try 
  	  {
  		  //写入到指定的文件路径
  		  out = new FileWriter(new File("D:\\ftl\\" + outputFile));
  		  Template temp = getTemplate(name);
  		  try 
  		  {
  			  temp.process(root, out);
		  } 
  		  catch (TemplateException e) 
  		  {
  			  e.printStackTrace();
		  }
	  } 
  	  catch (IOException e) 
  	  {
  		  e.printStackTrace();
	  }
  	  finally
  	  {
  		  if(out != null)
		  try 
  		   {
			//关闭文件流
			out.close();
		    } 
  		    catch (IOException e) 
  		    {
			e.printStackTrace();
		    }
  	  }
    }
	
	private static Template getTemplate(String name) throws Exception{
		//初始化FreeMarker配置  
        //创建一个Configuration实例  
        cfg = new Configuration();  
        //设置FreeMarker的模版文件位置  
        cfg.setDirectoryForTemplateLoading(new File("D:\\ftl\\")); 
		return cfg.getTemplate(name);
	}
	
	public static void main(String[] args) throws Exception {
		HashMap<String,Object> value = new HashMap<String,Object>();
		HashMap<String,Object> user = new HashMap<>();
		user.put("username", "李四");
		user.put("sex", "男");
		value.put("user", user);
		printFile("test.flt", value, "test.html");
	}
}
