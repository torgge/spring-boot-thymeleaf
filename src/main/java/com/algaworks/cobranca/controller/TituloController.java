package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.StatusTitulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    private Titulos titulos;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject("todosStatusTitulo", StatusTitulo.values());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo) {
        titulos.save(titulo);

        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject("mensagem", "Título salvo com sucesso!");
        return mv;
    }
}
