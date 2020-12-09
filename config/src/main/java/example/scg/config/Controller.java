package example.scg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/09
 * Time: 3:17 오후
 */
@RestController
public class Controller {
    @Value("${server.port}")
    private int port;
    @Value("${spring.message}")
    private String message;
    @GetMapping("/test")
    public String test() {
        return message;
    }
}
