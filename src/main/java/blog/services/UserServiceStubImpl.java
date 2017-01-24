package blog.services;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Jonelezhang on 1/23/17.
 */

@Service
public class UserServiceStubImpl implements UserService {

    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username, password);
    }
}
