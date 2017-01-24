package blog.services;

/**
 * Created by Jonelezhang on 1/23/17.
 */
public interface UserService {
    boolean authenticate(String username, String password);
}
