package org.spring.mvc.loja.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.mvc.loja.dao.ProdutoDAO;
import org.spring.mvc.loja.model.Produto;
import org.spring.mvc.loja.model.TipoPreco;
import org.spring.mvc.loja.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutosController.class);

    @Autowired
    private ProdutoDAO dao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("/form")
    public ModelAndView form(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){

        System.out.println(sumario.getOriginalFilename());

        if(result.hasErrors()) {
            return form(produto);
        }

        System.out.println(produto);
        dao.gravar(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        return new ModelAndView("redirect:produtos");
    }

    @RequestMapping( method=RequestMethod.GET)
    public ModelAndView listar() {
        List<Produto> produtos = dao.listar();
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

}
