package example.scg.user.feign;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/11
 * Time: 1:55 오후
 */
@Data
public class PostResponse {
    Long postId;
    String username;
    String content;

    public PostResponse(String username, String content) {
        this.username = username;
        this.content = content;
    }
}
