package blog.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Jonelezhang on 1/7/17.
 */

@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 300)
    @Size(min=1)
    private String title;

    @Lob @Column(nullable = false)
    @Size(min=1)
    private String body;

//    @Column(nullable = false)
//    @Size(min=1)
//    private String author;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User author;

    @Column(nullable = false)
    private Date date = new Date();

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getBody(){
        return body;
    }
    public void setBody(String body){
        this.body = body;
    }

    public User getAuthor(){
        return author;
    }
    public void setAuthor(User author){
        this.author = author;
    }

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public Post(){}

    public Post(Long id, String title, String body, User author){
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }



}

