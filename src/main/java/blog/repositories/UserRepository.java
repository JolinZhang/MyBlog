package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jonelezhang on 1/24/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
