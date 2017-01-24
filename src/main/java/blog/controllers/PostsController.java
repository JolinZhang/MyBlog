package blog.controllers;

import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jonelezhang on 1/18/17.
 */
@Controller
public class PostsController {
    @Autowired
    private PostService  postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/posts/{id}")
    public String view(@PathVariable("id")Long id, Model model){
        Post post = postService.findById(id);
        if(post == null){
            notificationService.addErrorMessage("Cannot find post#"+ id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }

    @RequestMapping("/posts")
    public String allViews(Model model){
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allposts", allPosts);
        return "posts/list_posts";
    }

    @RequestMapping("/posts/new_post")
    public String create(Post post){
        return "posts/create_post";
    }

    @RequestMapping("/posts/new_post/{id}")
    public String update(@PathVariable("id")Long id, Model model){
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "posts/create_post";
    }

    @RequestMapping(value ="/posts/new_post", method = RequestMethod.POST)
    public String createPost(@Valid Post post, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            notificationService.addErrorMessage("please fill the form correctly!");

        }else {
            postService.create(post);
            notificationService.addInfoMessage("post successfully!");
        }
        return "redirect:/posts";
    }

    @RequestMapping(value ="/posts/new_post/{id}", method = RequestMethod.POST)
    public String updatePost(@Valid Post post, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            notificationService.addErrorMessage("please fill the form correctly!");
        }else{
            postService.edit(post);
            notificationService.addInfoMessage("post successfully!");
        }
        return "redirect:/posts";
    }

    @RequestMapping(value ="/posts/delete_post/{id}", method = RequestMethod.GET)
    public String deletePost(@Valid Post post, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            notificationService.addErrorMessage("delete operation failed!");
        }else{
            postService.deleteById(post.getId());
            notificationService.addInfoMessage("delete successfully!");
        }
        return "redirect:/posts";
    }
}
