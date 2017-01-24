package blog.controllers;

import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Jonelezhang on 1/23/17.
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/user/login")
    public String loginPage(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            notificationService.addErrorMessage("Please fill the form correctly!");
            return "user/login";
        }

        if( ! userService.authenticate(
                user.getUsername(), user.getPasswordHash())){
            notificationService.addErrorMessage("Invalid login!");
            return "user/login";
        }
        notificationService.addInfoMessage("Login successfully !");
        return "/posts";
    }

}
