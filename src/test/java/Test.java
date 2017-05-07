import cn.cookily.msg.util.SendMsg;
import com.taobao.api.ApiException;

/**
 * Created by cookily on 2017/5/8.
 */
public class Test {

    @org.junit.Test
    public void testSendMsg() throws ApiException {
        new SendMsg().sendMsg();
    }
}
