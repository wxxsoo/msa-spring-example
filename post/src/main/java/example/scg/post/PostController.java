package example.scg.post;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/02
 * Time: 4:49 오후
 */

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    @Value("${server.port}")
    private int port;
    @Value("${spring.message}")
    private String message;

    @GetMapping("/error")
    public void generateError() {
        throw new RuntimeException("Error");
    }

    @GetMapping("/timeout")
    public void generateTimeout() throws InterruptedException {
        Thread.sleep(3100);
    }

    @GetMapping("/test")
    public String test() {
        return message;
    }
}
