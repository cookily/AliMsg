package cn.cookily.msg.util;

import java.net.URL;
import java.util.Map;

/**
 * Created by dbj on 2017/5/8.
 */

public class ConfUtils {
    public static String SERVER_URL=null;
    public static String APP_KEY=null;
    public static String APP_SECRET=null;
    public static String SMS_TYPE=null;
    public static String SMS_FREE_SIGN_NAME=null;
    public static String SMS_TEMPLATE_CODE=null;

    static {
        URL url = ConfUtils.class.getClassLoader().getResource("core.properties");
        String uri = url.toString();
//        System.out.println(url);
        String path = uri.substring(uri.indexOf("/") + 1);

        //TODO: 2017/4/14  路径问题，虽然这样成功了，但明显不是最优解
//        System.out.println(path);

        Map<String, String> maps = PropertiesUtil.getProperties(path);

        SERVER_URL=maps.get("SERVER_URL");
        APP_KEY=maps.get("APP_KEY");
        APP_SECRET=maps.get("APP_SECRET");
        SMS_TYPE=maps.get("SMS_TYPE");
        SMS_FREE_SIGN_NAME=maps.get("SMS_FREE_SIGN_NAME");
        SMS_TEMPLATE_CODE=maps.get("SMS_TEMPLATE_CODE");
    }
}
