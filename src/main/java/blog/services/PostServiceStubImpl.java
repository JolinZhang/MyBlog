package blog.services;

import blog.models.Post;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * Created by Jonelezhang on 1/8/17.
 */

@Service
public class PostServiceStubImpl implements PostService {
    private List<Post> posts = new ArrayList<Post>(){{
        add(new Post(1L,"title1","body1","author1"));
        add(new Post(2L,"title2","body2","author2"));
        add(new Post(3L,"title3","body3","author3"));
        add(new Post(4L,"title4","body4","author4"));
        add(new Post(5L,"title5","body5","author5"));
        add(new Post(6L,"title6","body6","author6"));
        add(new Post(7L,"title7","body7","author7"));
    }};

    @Override
    public List<Post> findAll() {
        return this.posts;
    }

    @Override
    public List<Post> findLatest5() {
        return this.posts.stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(long id) {
        return this.posts.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(Post post) {
        post.setId(this.posts.stream().mapToLong(
                p -> p.getId()).max().getAsLong() +1);
        this.posts.add(post);
        return post;
    }

    @Override
    public Post edit(Post post) {
        for(int i=0; i< this.posts.size(); i++ ){
            if(Objects.equals(this.posts.get(i).getId(), post.getId())){
                this.posts.set(i,post);
                return post;
            }
        }
        throw new RuntimeException("Post not found" + post.getId());
    }

    @Override
    public void deleteById(long id) {
        for(int i =0; i< this.posts.size(); i++){
            if(Objects.equals(this.posts.get(i).getId(), id)){
                this.posts.remove(i);
                return;
            }
        }
        throw new RuntimeException("Post not found" + id);
    }
}
