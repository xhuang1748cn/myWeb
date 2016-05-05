package cn.srn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SRn on 2016/5/5.
 */
@Controller
@RequestMapping("/helloamaze")
public class AmazeController {

    @RequestMapping(value = {"", "/"})
    public String index() {
        return "amazeTest/HelloAmaze";
    }
}
