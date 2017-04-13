package cas.controller;

import cas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wwu on 2017/4/13.
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(ModelMap model){
        model.addAttribute("username",userService.getUsername());
        return "index";
    }
}