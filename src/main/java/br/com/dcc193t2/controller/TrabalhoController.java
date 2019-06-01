package br.com.dcc193t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dcc193t2.dao.AreaConhecimentoRepository;
import br.com.dcc193t2.dao.TrabalhoRepository;
import br.com.dcc193t2.dao.TrabalhoRepository;
import br.com.dcc193t2.model.AreaConhecimento;
import br.com.dcc193t2.model.Trabalho;

/**
 * TrabalhoController
 */
@Controller
@RequestMapping("/trabalho/")
public class TrabalhoController {

    @Autowired
    TrabalhoRepository trabalhoRepository;

	@Autowired
    AreaConhecimentoRepository areaConhecimentoRepository;

    @RequestMapping("")
    public String homeTrabalho(Model model){
        System.out.println(trabalhoRepository.findAll().size());
        trabalhoRepository.findAll().forEach(u-> System.out.println(u.toString()) );
        model.addAttribute("listaTrabalho",trabalhoRepository.findAll());
        return "trabalho/home-trabalho";
    }

    @RequestMapping("/criar")
    public String criarTrabalho(Model model){
        model.addAttribute("trabalho",new Trabalho());
        model.addAttribute("listaArea",areaConhecimentoRepository.findAll());
        return "trabalho/criar-trabalho";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Trabalho trabalho){
        trabalhoRepository.save(trabalho);
        return "redirect:/trabalho/";
    }
    
}