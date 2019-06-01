package br.com.dcc193t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dcc193t2.dao.AreaConhecimentoRepository;
import br.com.dcc193t2.dao.RevisaoRepository;
import br.com.dcc193t2.dao.RevisaoRepository;
import br.com.dcc193t2.model.AreaConhecimento;
import br.com.dcc193t2.model.Revisao;

/**
 * RevisaoController
 */
@Controller
@RequestMapping("/revisao/")
public class RevisaoController {

    @Autowired
    RevisaoRepository revisaoRepository;

	@Autowired
    AreaConhecimentoRepository areaConhecimentoRepository;

    @RequestMapping("")
    public String homeRevisao(Model model){
        model.addAttribute("listaRevisao",revisaoRepository.findAll());
        return "revisao/home-revisao";
    }

    @RequestMapping("/criar")
    public String criarRevisao(Model model){
        model.addAttribute("revisao",new Revisao());
        model.addAttribute("listaArea",areaConhecimentoRepository.findAll());
        return "revisao/criar-revisao";
    }

    @RequestMapping("/editar/{id}")
    public String editarRevisao(@PathVariable Long id, Model model){
        model.addAttribute("revisao",revisaoRepository.findById(id).get());
        model.addAttribute("listaArea",areaConhecimentoRepository.findAll());
        return "revisao/editar-revisao";
    }

    @RequestMapping("/deletar/{id}")
    public String deletarRevisao(@PathVariable Long id){
        revisaoRepository.deleteById(id);
        return "redirect:/revisao/";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarRevisao(Revisao revisao){
        revisaoRepository.save(revisao);
        return "redirect:/revisao/";
    }
    

    @RequestMapping("/salvar")
    public String salvarRevisao(Revisao revisao){
        revisaoRepository.save(revisao);
        return "redirect:/revisao/";
    }
    
}