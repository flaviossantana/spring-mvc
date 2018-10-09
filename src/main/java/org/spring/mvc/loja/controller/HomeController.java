package org.spring.mvc.loja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private Log log = LogFactory.getLog(HomeController.class);

    @RequestMapping("/")
    public String index(){
        return "home";
    }

}
