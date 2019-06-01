package br.com.dcc193t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("listaTrabalho",trabalhoRepository.findAll());
        return "trabalho/home-trabalho";
    }

    @RequestMapping("/criar")
    public String criarTrabalho(Model model){
        model.addAttribute("trabalho",new Trabalho());
        model.addAttribute("listaArea",areaConhecimentoRepository.findAll());
        return "trabalho/criar-trabalho";
    }

    @RequestMapping("/editar/{id}")
    public String editarTrabalho(@PathVariable Long id, Model model){
        model.addAttribute("trabalho",trabalhoRepository.findById(id).get());
        model.addAttribute("listaArea",areaConhecimentoRepository.findAll());
        return "trabalho/editar-trabalho";
    }

    @RequestMapping("/deletar/{id}")
    public String deletarTrabalho(@PathVariable Long id){
        trabalhoRepository.deleteById(id);
        return "redirect:/trabalho/";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarTrabalho(Trabalho trabalho){
        trabalhoRepository.save(trabalho);
        return "redirect:/trabalho/";
    }
    

    @RequestMapping("/salvar")
    public String salvarTrabalho(Trabalho trabalho){
        trabalhoRepository.save(trabalho);
        return "redirect:/trabalho/";
    }
    
}