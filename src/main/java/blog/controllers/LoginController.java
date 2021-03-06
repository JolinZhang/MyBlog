package blog.controllers;

import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String login(@Valid User user){
        return "/users/login";

    }

    @RequestMapping(value="/user/login", method = RequestMethod.POST )
    public String loginPage(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            notificationService.addErrorMessage("Please fill the form correctly!");
            return "/users/login";
        }

        if( ! userService.authenticate(user.getUsername(), user.getPasswordHash())){
            notificationService.addErrorMessage("Invalid login!");
            return "/users/login";
        }

        userService.create(user);
        notificationService.addInfoMessage("Login successfully !");
        return "redirect:/posts";
    }

}
