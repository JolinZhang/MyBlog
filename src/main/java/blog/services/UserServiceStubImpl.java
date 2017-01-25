package blog.services;

import blog.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Jonelezhang on 1/23/17.
 */

@Service
public class UserServiceStubImpl implements UserService {
    private List<User> users = new ArrayList<User>(){{
        add(new User(1L, "shane","shane"));
    }};

    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username, password);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User create(User user) {
        user.setId(this.users.stream().mapToLong(
                u -> u.getId()).max().getAsLong() +1);
        this.users.add(user);
        return user;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public void deleteByUserId(long id) {
        for(int i =0; i<this.users.size(); i++){
            if(Objects.equals(this.users.get(i), id)){
                this.users.remove(i);
                return;
            }
        }

    }





}
