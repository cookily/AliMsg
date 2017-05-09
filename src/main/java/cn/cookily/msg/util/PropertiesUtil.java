package cn.cookily.msg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by dbj on 2017/4/14.
 */
public class PropertiesUtil {
    /**
     * 读取配置设置
     *
     * @param path 配置文件路径
     * @return Map<String,String>返回配置k-v对
     */
    public static Map<String, String> getProperties(String path) {
        Map<String, String> maps = new HashMap<String, String>();
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(new File(path)));
            for (Map.Entry<Object, Object> e : prop.entrySet()) {
                maps.put(String.valueOf(e.getKey()), String.valueOf(e.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maps;
    }
}
