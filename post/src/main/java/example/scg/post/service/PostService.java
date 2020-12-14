package example.scg.post.service;

import example.scg.post.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/14
 * Time: 10:43 오전
 */
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostResponse> findByUsername(String username, Pageable p) {
        return postRepository.findByUsername(username, p).stream().map(PostResponse::of).collect(Collectors.toList());
    }
}
