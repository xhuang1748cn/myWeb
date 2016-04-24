package cn.srn.controllers;

import cn.srn.repositories.entity.entities.User;
import cn.srn.services.UserService;
import cn.srn.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SRn on 2016/4/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/{userId}/info")
    public String index(Model model, @PathVariable("userId") String uid) {
        long id = ConvertUtil.strToLong(uid);
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "userInfo";
    }
}
