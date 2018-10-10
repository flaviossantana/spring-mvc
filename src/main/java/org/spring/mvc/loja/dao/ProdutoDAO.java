package org.spring.mvc.loja.dao;

import org.spring.mvc.loja.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void gravar(Produto produto){
        entityManager.persist(produto);
    }

}
