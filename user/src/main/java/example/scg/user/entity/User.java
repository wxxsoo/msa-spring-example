package example.scg.user.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/01
 * Time: 5:04 오후
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String email;
    @Builder
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
