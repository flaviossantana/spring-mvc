package org.spring.mvc.loja.controller;

import org.spring.mvc.loja.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {

    private static String PRODUTOS = "/produtos/";

    @RequestMapping("/produtos/form")
    public String form(){
        return irProdutos("form");
    }

    @RequestMapping("/produtos")
    public String gravar(Produto produto){
        System.out.println(produto.getTitulo());
        System.out.println(produto.getDescricao());
        System.out.println(produto.getPaginas());
        return irProdutos("ok");
    }

    private String irProdutos(String pagina){
        return PRODUTOS.concat(pagina);
    }

}
