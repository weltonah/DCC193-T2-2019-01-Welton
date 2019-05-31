package br.com.dcc193t2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @RequestMapping({"","/","home"})
    public String index(){
        return "index";
    }
}