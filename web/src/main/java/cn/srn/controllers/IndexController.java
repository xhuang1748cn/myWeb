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
        return "index";
    }

    @RequestMapping(value = "/showuser")
    public String showUser(Model model) {
        User user = userService.findUserById(1);
        model.addAttribute("user", user);
        return "userInfo";
    }

    @RequestMapping(value = "/print")
    public String print() {
        return "print";
    }

    @RequestMapping(value = "/adaptive")
    public String adaptive() {
        return "adaptive";
    }

    @RequestMapping(value = "/testSocket")
    public String testSocket() {
        return "testws";
    }

    @RequestMapping(value = "/jspTagTest")
    public String jspTagTest(Model model) {
        model.addAttribute("fileType", "txt");
        return "jspTagTest";
    }
}
