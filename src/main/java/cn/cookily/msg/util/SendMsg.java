package cn.cookily.msg.util;

import com.alibaba.fastjson.JSON;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import java.util.Map;

/**
 * Created by cookily on 2017/5/8.
 */
public class SendMsg {

    public String sendMsg(String phone,Map<String,String> maps) throws ApiException {

        TaobaoClient client=new DefaultTaobaoClient(ConfUtils.SERVER_URL,ConfUtils.APP_KEY, ConfUtils.APP_SECRET);

        AlibabaAliqinFcSmsNumSendRequest req=new AlibabaAliqinFcSmsNumSendRequest();

        //req.setExtend("12345回传");//待测 可选

        req.setSmsType(ConfUtils.SMS_TYPE);//短信类型 必须

        req.setSmsFreeSignName(ConfUtils.SMS_FREE_SIGN_NAME);// 必须

        req.setSmsParamString(JSON.toJSONString(maps));  //json格式的短信模板的变量，多个变量括号隔开 可选

        req.setRecNum(phone);//接收的手机号码 必须

        req.setSmsTemplateCode(ConfUtils.SMS_TEMPLATE_CODE);//短信模板id 必须

        AlibabaAliqinFcSmsNumSendResponse rsp= client.execute(req);

        return rsp.getBody();
    }
}
