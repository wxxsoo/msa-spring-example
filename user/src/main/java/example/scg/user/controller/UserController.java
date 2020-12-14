package example.scg.user.controller;

import example.scg.user.service.UserResponseDto;
import example.scg.user.service.UserService;
import lombok.RequiredArgsConstructor;
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
public class UserController {

    private final UserService userService;
    @Value("${spring.message}")
    private String message;

    @GetMapping("/test")
    public String test() {
//        System.out.println(message);
        return message;
    }

    @RequestMapping("{userId}")
    public UserResponseDto findByUserId(@PathVariable Long userId) {
        return userService.findById(userId);
    }

}
