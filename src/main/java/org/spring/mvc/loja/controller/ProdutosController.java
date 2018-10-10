package org.spring.mvc.loja.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.mvc.loja.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutosController.class);

    private static String PRODUTOS = "/produtos/";

    @RequestMapping("/produtos/form")
    public String form(){
        return irProdutos("form");
    }

    @RequestMapping("/produtos")
    public String gravar(Produto produto){
        logger.info(produto.toString());
        return irProdutos("ok");
    }

    private String irProdutos(String pagina){
        return PRODUTOS.concat(pagina);
    }

}
