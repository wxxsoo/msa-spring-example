package example.scg.user;

import example.scg.user.entity.User;
import example.scg.user.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/01
 * Time: 5:18 오후
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

        private final UserRepository userRepository;

        public void initData() {
            User user = new User("lee", "hello@world.com");
            User user2 = new User("kim", "kim@world.com");

            userRepository.save(user);
            userRepository.save(user2);
        }
    }
}
