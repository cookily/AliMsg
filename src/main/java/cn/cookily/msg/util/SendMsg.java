package cn.cookily.msg.util;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Created by cookily on 2017/5/8.
 */
public class SendMsg {
    public void sendMsg() throws ApiException {
        String serverUrl="http://gw.api.taobao.com/router/rest";
        String appKey="后台可以查看appKey";
        String appSecret="后台可以查看appSecret";

        TaobaoClient client=new DefaultTaobaoClient(serverUrl, appKey, appSecret);
        AlibabaAliqinFcSmsNumSendRequest req=new AlibabaAliqinFcSmsNumSendRequest();
        //req.setExtend("12345回传");//待测 可选
        req.setSmsType("normal");//短信类型 必须
        req.setSmsFreeSignName("短信签名");// 必须
        req.setSmsParamString("{\"userName\":\"通知的消息名\",\"code\":\"验证码\"}");//json格式的短信模板的变量，多个变量括号隔开 可选
        req.setRecNum("接收的手机号码");//接收的手机号码 必须
        req.setSmsTemplateCode("短信模板id");//短信模板id 必须

        AlibabaAliqinFcSmsNumSendResponse rsp= client.execute(req);
        System.out.println(rsp.getBody());
    }
}
