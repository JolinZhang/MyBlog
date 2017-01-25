package blog.services;

import blog.models.Post;
import blog.models.User;

import java.util.List;

/**
 * Created by Jonelezhang on 1/23/17.
 */
public interface UserService {
    boolean authenticate(String username, String password);
    List<User> findAll();
    User create(User user);
    User findById(long id);
    User edit(User user);
    void deleteByUserId(long id);

}
