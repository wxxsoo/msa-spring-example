package example.scg.post;

import example.scg.post.entity.Post;
import example.scg.post.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/02
 * Time: 10:33 오전
 */
@Component
@RequiredArgsConstructor
public class InitData {

    private final InitDataService initDataService;

    @PostConstruct
    public void init() {
        initDataService.initData();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitDataService {

        private final PostRepository postRepository;

        public void initData() {
            Post post = Post.builder().username("lee").content("Content 1").build();
            Post post2 = Post.builder().username("lee").content("Content 2").build();

            postRepository.save(post);
            postRepository.save(post2);
        }
    }
}
