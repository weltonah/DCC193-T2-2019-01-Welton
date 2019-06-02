package br.com.dcc193t2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dcc193t2.dao.AvaliadorRepository;
import br.com.dcc193t2.dao.RevisaoRepository;
import br.com.dcc193t2.dao.TrabalhoRepository;
import br.com.dcc193t2.model.Avaliador;
import br.com.dcc193t2.model.Revisao;
import br.com.dcc193t2.model.Trabalho;

/**
 * LoginController
 */
@Controller
@RequestMapping("/logado/")
public class LoginController {


    @Autowired
    AvaliadorRepository avaliadorRepository;

    @Autowired
    TrabalhoRepository trabalhoRepository;

    @Autowired
    RevisaoRepository revisaoRepository;

    @RequestMapping("")
    public String login(Model model){
        model.addAttribute("avaliador",new Avaliador());
        return "logado/login";
    }

    @RequestMapping("/efetuarLogin")
    public String efetuarLogin(Avaliador avaliador, Model model, HttpSession session){
        Avaliador avaliadorQuery = avaliadorRepository.findFirstByEmailAndCodigoAcesso(avaliador.getEmail(),avaliador.getCodigoAcesso());
        if(avaliadorQuery != null){
            session.setAttribute("usuarioLogado", avaliadorQuery);
            model.addAttribute("avaliador", avaliadorQuery);
            return "logado/home-logado";
        }else{
            return "index";
        }
    }

    @RequestMapping("/listarTrabalhos/{id}")
    public String listarTrabalhos(Model model,@PathVariable Long id, HttpSession session){
        Avaliador avaliador = (Avaliador) session.getAttribute("usuarioLogado");
        model.addAttribute("listaTrabalhos",  
        trabalhoRepository.findByIdAvalaliadorAndIdAreaConhecimentoOrderByStatus(avaliador.getId(),id));
        return "logado/login-trabalhos-area";
    }

    @RequestMapping("/avaliar/{id}")
    public String avaliarTrabalhos(Model model,@PathVariable Long id, HttpSession session){
        Avaliador avaliador = (Avaliador) session.getAttribute("usuarioLogado");
        Trabalho trabalho = trabalhoRepository.findById(id).get();
        Revisao revisao = revisaoRepository.findFirstByRefavaliadorAndReftrabalho(avaliador,trabalho);
        session.setAttribute("revisaoAvaliada", revisao);
        model.addAttribute("trabalho",  trabalho);
        model.addAttribute("revisao", revisao );
        return "logado/avaliar-trabalho";
    }

    @RequestMapping("/salvarAvaliar")
    public String salvarAvaliarTrabalhos(@RequestParam("action") int tipoAcao,
     Revisao revisao, HttpSession session){
        Revisao revisaoSession = (Revisao) session.getAttribute("revisaoAvaliada");
        Long idarea = revisaoSession.getReftrabalho().getAreaConhecimento().getId();
        System.out.println(revisao.getDescricao() + " " + revisao.getNota());
        //Revisar Depois
        if(tipoAcao == 1){
            revisaoSession.setDescricao(revisao.getDescricao());
            revisaoSession.setNota(revisao.getNota());
            revisaoSession.setStatus(0);
            revisaoRepository.save(revisaoSession);
        }
        // Revisar agora 
        else if(tipoAcao == 2){
            revisaoSession.setDescricao(revisao.getDescricao());
            revisaoSession.setNota(revisao.getNota());
            revisaoSession.setStatus(1);
            revisaoRepository.save(revisaoSession);
        }
        // Pular
        else if(tipoAcao == 3){
            revisaoSession.setDescricao(revisao.getDescricao());
            revisaoSession.setNota(revisao.getNota());
            revisaoSession.setStatus(2);
            revisaoRepository.save(revisaoSession);
        }
        session.removeAttribute("revisaoAvaliada");
        return "redirect:/logado/listarTrabalhos/"+idarea; 
    }
    
}