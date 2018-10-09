package org.spring.mvc.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public void index(){
        System.out.println("Entrando no HOME da CDC");
    }

}
