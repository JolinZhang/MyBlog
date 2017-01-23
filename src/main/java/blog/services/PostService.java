package blog.services;

import blog.models.Post;

import java.util.List;

/**
 * Created by Jonelezhang on 1/8/17.
 */

public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(long id);

}
