package example.scg.user.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by wansoo.
 * User: accomplishlee
 * Date: 2020/12/01
 * Time: 5:09 오후
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
}
