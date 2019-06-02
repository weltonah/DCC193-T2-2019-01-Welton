package br.com.dcc193t2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t2.dao.AvaliadorRepository;
import br.com.dcc193t2.model.Avaliador;

/**
 * HomeController
 */
@Controller
public class HomeController {


    @Autowired
    AvaliadorRepository avaliadorRepository;
    
    @RequestMapping({"","/","home"})
    public String index(){
        return "index";
    }
    
}