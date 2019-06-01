package br.com.dcc193t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t2.dao.AreaConhecimentoRepository;
import br.com.dcc193t2.dao.AvaliadorRepository;
import br.com.dcc193t2.model.Avaliador;

/**
 * AvaliadorController
 */
@Controller
@RequestMapping("/avaliador/")
public class AvaliadorController {

    @Autowired
    AvaliadorRepository avaliadorRepository;

	@Autowired
    AreaConhecimentoRepository areaConhecimentoRepository;

    @RequestMapping("")
    public String homeAvaliador(Model model){
        model.addAttribute("listaAvaliadores",avaliadorRepository.findAll());
        return "avaliador/home-avaliador";
    }

    @RequestMapping("/criar")
    public String criarAvaliador(Model model){
        model.addAttribute("avaliador",new Avaliador());
        model.addAttribute("listaArea",areaConhecimentoRepository.findAll());
        return "avaliador/criar-avaliador";
    }
    @RequestMapping("/editar/{id}")
    public String editarAvaliador(@PathVariable Long id, Model model){
        model.addAttribute("avaliador",avaliadorRepository.findById(id).get());
        model.addAttribute("listaArea",areaConhecimentoRepository.findAll());
        return "avaliador/editar-avaliador";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarAvaliador(Avaliador avaliador){
        avaliadorRepository.save(avaliador);
        return "redirect:/avaliador/";
    }

    @RequestMapping("/deletar/{id}")
    public String deletarAvaliador(@PathVariable Long id){
        avaliadorRepository.deleteById(id);
        return "redirect:/avaliador/";
    }

    @RequestMapping("/salvar")
    public String salvarAvaliador(Avaliador avaliador){
        avaliadorRepository.save(avaliador);
        return "redirect:/avaliador/";
    }
    
}