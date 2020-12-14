package example.scg.post.service;


import example.scg.post.entity.Post;
import lombok.Data;

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

    public PostResponse(Long postId, String username, String content) {
        this.postId = postId;
        this.username = username;
        this.content = content;
    }

    public static PostResponse of(Post post) {
        return new PostResponse(post.getId(), post.getUsername(), post.getContent());
    }
}
