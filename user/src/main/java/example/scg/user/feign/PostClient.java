package example.scg.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/11
 * Time: 1:12 오후
 */
@FeignClient(name="posts", url = "http://localhost:9001")
public interface PostClient {

//    @RequestMapping(method = RequestMethod.GET, value = "/status/{status}")
//    void status(@PathVariable("status") int status);
    @RequestMapping(method = RequestMethod.GET, value = "/posts/search")
    List<PostResponse> findPostsByUsername(@RequestParam("username") String username);
}
