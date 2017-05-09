package cn.cookily.msg.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by dbj on 2017/4/14.
 */
public class PropertiesUtil {
    /**
     * 读取配置设置
     * @param path 配置文件路径
     * @return Map<String,String>返回配置k-v对
     */

    /**
     * 读取配置文件，如不指定配置文件编码格式，则默认GBK
     * @param path
     * @return
     */
    public static Map<String, String> getProperties(String path) {
        return getProperties(path,"GBK");
    }

    /**
     * 读取配置文件，指定配置文件格式，可以为UTF_8等等
     * @param path
     * @param charsetName
     * @return
     */
    public static Map<String, String> getProperties(String path,String charsetName) {
        Map<String, String> maps = new HashMap<String, String>();
        Properties prop = new Properties();
        try {
            InputStream inputStream=PropertiesUtil.class.getResourceAsStream(path);
            BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream,charsetName));
            prop.load(bf);
            for (Map.Entry<Object, Object> e : prop.entrySet())
                maps.put(String.valueOf(e.getKey()), String.valueOf(e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maps;
    }
}
