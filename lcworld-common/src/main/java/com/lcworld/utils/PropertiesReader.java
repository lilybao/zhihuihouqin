package com.lcworld.utils;

import java.io.IOException;  
import java.io.InputStream;  
import java.util.Properties;  
  
import org.apache.log4j.Logger; 

public class PropertiesReader{
	private Logger logger = Logger.getLogger(Properties.class) ;  
    private Properties properties ;  
    private static PropertiesReader propertiesReader = new PropertiesReader() ;  
      
    private String resName = "config.properties" ;  
      
    // 单例私有化构造方法  
    private PropertiesReader(){  
        InputStream is = PropertiesReader.class.getClassLoader()  
                .getResourceAsStream(resName);  
        properties = new Properties() ;  
        try {  
            properties.load(is);  
            logger.info("加载配置信息！！") ;  
        } catch (IOException e) {  
            logger.warn("加载配置文件出错！") ;  
            //e.printStackTrace();  
        }  
    }  
      
    // 得到PropertiesReader的实例  
    public static PropertiesReader getInstance(){  
        if(propertiesReader==null){  
            return new PropertiesReader() ;  
        }  
        return propertiesReader ;  
    }  
      
    // 返回所有属性  
    public Properties getProperties(){  
        return this.properties ;  
    }  
      
    public static void main(String[] args) {  
        Properties properties = PropertiesReader.getInstance().getProperties() ;  
        System.out.println(properties.getProperty("filePath"));  
    }  
}
