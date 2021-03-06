package example.scg.user.controller;

import example.scg.user.service.UserResponseDto;
import example.scg.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/10
 * Time: 10:44 오전
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@RefreshScope
@Slf4j
public class UserController {

    private final UserService userService;
    @Value("${spring.message}")
    private String message;

    @GetMapping("/test")
    public String test() {
        log.info("user-service test api called");
//        System.out.println(message);
        return message;
    }

    @RequestMapping("{userId}")
    public UserResponseDto findByUserId(@PathVariable Long userId) {
        log.info("user-service test api called");
        return userService.findById(userId);
    }

}
