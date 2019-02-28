package com.lcworld.utils;

import java.util.HashSet;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Pinyin4jUtil {
	
	
	/**
	 * 将字符串中的中文转化为拼音
	 */
	public static String getPingYin(String inputString) {
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);

		String output = "";
		if (inputString != null && inputString.length() > 0 && !"null".equals(inputString)) {
			char[] input = inputString.trim().toCharArray();
			try {
				for (int i = 0; i < input.length; i++) {
					if (java.lang.Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) {
						String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
						output += temp[0];
					} else {
						output += java.lang.Character.toString(input[i]);
					}
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
		} else {
			return "*";
		}
		return output;
	} 
    
    
    /*************************************************************************** 
     * 字符串集合转换字符串(逗号分隔) 
     *  
     * @Name: Pinyin4jUtil.java 
     * @Description: TODO 
     * @author: wang_chian@foxmail.com 
     * @version: Jan 13, 2012 9:37:57 AM 
     * @param stringSet 
     * @return 
     */  
    public static String getPinyinZh_CN(Set<String> stringSet) {  
        StringBuilder str = new StringBuilder();  
        int i = 0;  
        for (String s : stringSet) {  
            if (i == stringSet.size() - 1) {  
                str.append(s);  
            } else {  
                str.append(s + ",");  
            }  
            i++;  
        }  
        return str.toString();  
    } 
    
    
    /*************************************************************************** 
     * 字符集转换 
     *  
     * @Name: Pinyin4jUtil.java 
     * @Description: TODO 
     * @author: wang_chian@foxmail.com 
     * @version: Jan 13, 2012 9:34:11 AM 
     * @param chinese 
     *            中文汉字 
     * @throws BadHanyuPinyinOutputFormatCombination 
     */  
    public static Set<String> makeStringByStringSet(String chinese) {  
        char[] chars = chinese.toCharArray();  
        if (chinese != null && !chinese.trim().equalsIgnoreCase("")) {  
            char[] srcChar = chinese.toCharArray();  
            String[][] temp = new String[chinese.length()][];  
            for (int i = 0; i < srcChar.length; i++) {  
                char c = srcChar[i];  
  
                // 是中文或者a-z或者A-Z转换拼音  
                if (String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")) {  
  
                    try {  
                        temp[i] = PinyinHelper.toHanyuPinyinStringArray(  
                                chars[i], getDefaultOutputFormat());  
  
                    } catch (BadHanyuPinyinOutputFormatCombination e) {  
                        e.printStackTrace();  
                    }  
                } else if (((int) c >= 65 && (int) c <= 90)  
                        || ((int) c >= 97 && (int) c <= 122)) {  
                    temp[i] = new String[] { String.valueOf(srcChar[i]) };  
                } else {  
                    temp[i] = new String[] { "" };  
                }  
            }  
            String[] pingyinArray = Exchange(temp);  
            Set<String> zhongWenPinYin = new HashSet<String>();  
            for (int i = 0; i < pingyinArray.length; i++) {  
                zhongWenPinYin.add(pingyinArray[i]);  
            }  
            return zhongWenPinYin;  
        }  
        return null;  
    }  
    
    
    /*************************************************************************** 
     * Default Format 默认输出格式 
     *  
     * @Name: Pinyin4jUtil.java 
     * @Description: TODO 
     * @author: wang_chian@foxmail.com 
     * @version: Jan 13, 2012 9:35:51 AM 
     * @return 
     */  
    public static HanyuPinyinOutputFormat getDefaultOutputFormat() {  
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();  
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写  
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 没有音调数字  
        format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);// u显示  
        return format;  
    }  
  
    /*************************************************************************** 
     *  
     * @Name: Pinyin4jUtil.java 
     * @Description: TODO 
     * @author: wang_chian@foxmail.com 
     * @version: Jan 13, 2012 9:39:54 AM 
     * @param strJaggedArray 
     * @return 
     */  
    public static String[] Exchange(String[][] strJaggedArray) {  
        String[][] temp = DoExchange(strJaggedArray);  
        return temp[0];  
    }  
    
    /*************************************************************************** 
     *  
     * @Name: Pinyin4jUtil.java 
     * @Description: TODO 
     * @author: wang_chian@foxmail.com 
     * @version: Jan 13, 2012 9:39:47 AM 
     * @param strJaggedArray 
     * @return 
     */  
    private static String[][] DoExchange(String[][] strJaggedArray) {  
        int len = strJaggedArray.length;  
        if (len >= 2) {  
            int len1 = strJaggedArray[0].length;  
            int len2 = strJaggedArray[1].length;  
            int newlen = len1 * len2;  
            String[] temp = new String[newlen];  
            int Index = 0;  
            for (int i = 0; i < len1; i++) {  
                for (int j = 0; j < len2; j++) {  
                    temp[Index] = capitalize(strJaggedArray[0][i])  
                            + capitalize(strJaggedArray[1][j]);  
                    Index++;  
                }  
            }  
            String[][] newArray = new String[len - 1][];  
            for (int i = 2; i < len; i++) {  
                newArray[i - 1] = strJaggedArray[i];  
            }  
            newArray[0] = temp;  
            return DoExchange(newArray);  
        } else {  
            return strJaggedArray;  
        }  
    }  
    
    /*************************************************************************** 
     * 首字母大写 
     *  
     * @Name: Pinyin4jUtil.java 
     * @Description: TODO 
     * @author: wang_chian@foxmail.com 
     * @version: Jan 13, 2012 9:36:18 AM 
     * @param s 
     * @return 
     */  
    public static String capitalize(String s) {  
        char ch[];  
        ch = s.toCharArray();  
        if (ch[0] >= 'a' && ch[0] <= 'z') {  
            ch[0] = (char) (ch[0] - 32);  
        }  
        String newString = new String(ch);  
        return newString;  
    }  
    
    public static void main(String[] args) {
    	 String p = Pinyin4jUtil.getPingYin("吃鱼突刺");
    	 System.out.println(p);
	}
}
