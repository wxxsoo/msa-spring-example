package example.scg.user;

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
 * Time: 10:44 오전
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@RefreshScope
public class Controller {

    @Value("${spring.message}")
    private String message;

    @GetMapping("/test")
    public String test() {
        return message;
    }
}
