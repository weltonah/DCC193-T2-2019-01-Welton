package br.com.dcc193t2.controller;

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

    @RequestMapping("login")
    public String login(Model model){
        model.addAttribute("avaliador",new Avaliador());
        return "login";
    }

    @RequestMapping("efetuarLogin")
    public String efetuarLogin(Avaliador avaliador, Model model){
        Avaliador avaliadorQuery = avaliadorRepository.findFirstByEmailAndCodigoAcesso(avaliador.getEmail(),avaliador.getCodigoAcesso());
        System.out.println(avaliador);
        System.out.println(avaliadorQuery);
        if(avaliadorQuery != null){
            model.addAttribute("avaliador", avaliadorQuery);
            return "homeLogado";
        }else{
            return "index";
        }

    }
}