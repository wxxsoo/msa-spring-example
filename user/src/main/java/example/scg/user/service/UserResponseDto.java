package example.scg.user.service;

import example.scg.user.feign.PostResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/11
 * Time: 1:51 오후
 */
@Data
@NoArgsConstructor
public class UserResponseDto {
    Long userId;
    String username;
    String email;
    List<PostResponse> posts;

    public UserResponseDto(Long userId, String username, String email, List<PostResponse> posts) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.posts = posts;
    }
}
