package example.scg.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/10
 * Time: 10:26 오전
 */
@RestController
@RequestMapping("/gateway")
@RequiredArgsConstructor
@RefreshScope
public class GatewayController {

    @Value("${spring.message}")
    private String message;

    @GetMapping("/test")
    public String test() {
        return message;
    }

    @GetMapping("/fallback/post-service")
    public String fallbackMessageForPostService() {
        return "This is a fallback for post-service";
    }

    @GetMapping("/fallback/user-service")
    public String fallbackMessageForUserService() {
        return "This is a fallback for user-service";
    }
}
