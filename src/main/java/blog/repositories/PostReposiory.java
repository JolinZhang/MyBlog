package blog.repositories;

import blog.models.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jonelezhang on 1/22/17.
 */
@Repository
public interface PostReposiory extends JpaRepository<Post, Long> {

    @Query("select p from Post p order by p.date DESC")
    List<Post> findLatest5Posts(Pageable pageable);

}
