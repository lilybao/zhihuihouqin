package com.lcworld.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertiesFileReader
{
  private String pFileName;
  
  public PropertiesFileReader(String pFileName)
  {
    this.pFileName = pFileName;
  }
  
  public Map<String, String> getProperties()
  {
    InputStream in = null;
    Map<String, String> map = new HashMap();
    Properties p = new Properties();
    try
    {
      in = Thread.currentThread().getContextClassLoader().getResourceAsStream(this.pFileName);
      p.load(in);
      Iterator it = p.keySet().iterator();
      while (it.hasNext())
      {
        String key = (String)it.next();
        String val = p.getProperty(key);
        map.put(key, val);
      }
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      if (in != null) {
        try
        {
          in.close();
        }
        catch (IOException ex) {}
      }
      p.clear();
    }
    return map;
  }
  
  public static Map<String, String> mergeProperties(Map<String, String> baseProperties, Map<String, String> newProperties)
  {
    if ((newProperties == null) || (newProperties.size() == 0)) {
      return baseProperties;
    }
    Map<String, String> dupBaseProperties = new HashMap();
    if (baseProperties != null) {
      dupBaseProperties.putAll(baseProperties);
    }
    Iterator<String> newKeys = newProperties.keySet().iterator();
    while (newKeys.hasNext())
    {
      String key = (String)newKeys.next();
      dupBaseProperties.put(key, newProperties.get(key));
    }
    return dupBaseProperties;
  }
}
