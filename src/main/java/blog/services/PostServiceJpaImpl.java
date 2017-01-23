package blog.services;

import blog.models.Post;
import blog.repositories.PostReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jonelezhang on 1/22/17.
 */

@Service
@Primary
public class PostServiceJpaImpl implements PostService {

    @Autowired
    private PostReposiory postRepo;

    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }

    @Override
    public List<Post> findLatest5() {
        return this.postRepo.findLatest5Posts(new PageRequest(0,5));
    }

    @Override
    public Post findById(long id) {
        return this.postRepo.findOne(id);
    }

    @Override
    public Post create(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public void deleteById(long id) {
        this.postRepo.delete(id);
    }
}
