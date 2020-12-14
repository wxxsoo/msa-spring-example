package example.scg.post;

import example.scg.post.service.PostResponse;
import example.scg.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/02
 * Time: 4:49 오후
 */

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@RefreshScope
public class PostController {

    private final PostService postService;

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

    @GetMapping("/search")
    public List<PostResponse> findByUsername(@RequestParam String username, Pageable p) {
        return postService.findByUsername(username, p);
    }
}
