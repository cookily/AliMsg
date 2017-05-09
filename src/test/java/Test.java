import cn.cookily.msg.util.ConfUtils;
import cn.cookily.msg.util.SendMsg;
import com.taobao.api.ApiException;

import java.util.HashMap;
import java.util.Map;

public class Test {

    @org.junit.Test
    public void testSendMsg() throws ApiException {
        Map<String,String> map=new HashMap<String, String>();
        map.put("title","小菊花网");
        map.put("code","4525");

        String conten=new SendMsg().sendMsg("15298801995",map);

    }

    @org.junit.Test
    public void readConf(){
        System.out.println(ConfUtils.SMS_FREE_SIGN_NAME);
    }
}
