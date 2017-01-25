package blog.services;


import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Jonelezhang on 1/24/17.
 */
@Service
@Primary
public class UserServicesJpaImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username, password);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public User edit(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteByUserId(long id) {
        this.userRepository.delete(id);

    }
}
