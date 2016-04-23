package cn.srn.controllers;

import cn.srn.repositories.entity.entities.User;
import cn.srn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SRn on 2016/4/23.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = {"/", "index"})
    public String index(Model model) {
        User user = userService.findUserById(1);
        model.addAttribute("user", user);
        return "index";
    }
}