package br.com.dcc193t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("efetuarLogin")
    public String efetuarLogin(Avaliador avaliador){
        // if(avaliadorRepository.findByEmailAndCodigoAcesso(avaliador).isPresent()){
        //     return "homelogado";
        // }else{
        //     return "index";
        // }

    }
}