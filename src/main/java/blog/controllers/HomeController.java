package blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jonelezhang on 12/30/16.
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
