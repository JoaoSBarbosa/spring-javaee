package br.com.spring.dao;

import br.com.spring.model.Produto;
import br.com.spring.model.ProdutoEstoque;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProdutoEstoqueDAO implements CRUD<ProdutoEstoque, Long> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ProdutoEstoque pesquisaPeloId(Long id) {
        return em.find(ProdutoEstoque.class, id);
    }

    @Override
    public List<ProdutoEstoque> listaTodos() {
        Query query = em.createQuery("select pe from ProdutoEstoque  pe");
        return query.getResultList();
    }

    @Override
    public void insere(ProdutoEstoque produtoEstoque) {
        em.persist(produtoEstoque);
    }

    @Override
    public void atualiza(ProdutoEstoque produtoEstoque) {
        em.merge(produtoEstoque);
    }

    @Override
    public void remove(ProdutoEstoque produtoEstoque) {
        em.remove(produtoEstoque);
    }
}
