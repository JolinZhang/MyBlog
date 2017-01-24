package blog.models;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jonelezhang on 1/23/17.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    @Size(min = 2, max=30, message = "Username size should be in the range [2...30]")
    private String username;

    @Column(nullable = false, length = 60)
    @Size(min = 1, max=30)
    private String passwordHash;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<Post>();

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setPasswordHash(String passwordHash){
        this.passwordHash = passwordHash;
    }
    public String getPasswordHash(){
        return passwordHash;
    }
    public void setPosts(Set<Post> posts){
        this.posts = posts;
    }
    public Set<Post> getPosts(){
        return posts;
    }

    public User() {
    }

    public User(String username){
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}
