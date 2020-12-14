package example.scg.user.service;

import example.scg.user.entity.User;
import example.scg.user.entity.UserRepository;
import example.scg.user.feign.PostClient;
import example.scg.user.feign.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/11
 * Time: 1:49 오후
 */

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final PostClient postClient;
    private final UserRepository userRepository;
    public UserResponseDto findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Not Found"));
//        postClient.status(200);
        List<PostResponse> postResponseList = postClient.findPostsByUsername(user.getUsername());
//        List<PostResponse> postResponseList = new ArrayList<>();
        UserResponseDto result = new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), postResponseList);
        return result;
    }
}
