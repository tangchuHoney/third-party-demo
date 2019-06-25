import com.jklove.demo.config.AuthConfig;
import com.jklove.demo.model.AuthResponse;
import com.jklove.demo.request.AuthRequest;
import com.jklove.demo.request.AuthWeChatRequest;
import org.junit.Test;

public class WeChatTest {
    @Test
    public void wechatTest() {
//        AuthRequest authRequest = new AuthWeChatRequest(AuthConfig.builder()
//                .clientId("clientId")
//                .clientSecret("clientSecret")
//                .redirectUrl("redirectUri")
//                .build());
//        // 返回授权页面，可自行调整
//        String url = authRequest.authorize();
//        // 授权登录后会返回一个code，用这个code进行登录
//        AuthResponse login = authRequest.login("code");
    }
}
