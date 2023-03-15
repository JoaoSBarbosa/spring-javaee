package br.com.spring.dao;

import br.com.spring.model.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO implements CRUD<Produto, Long> {

    @PersistenceContext // Anotação Hibernate para ele gerenciar ciclo de vida das entidade
    private EntityManager entityM;

    @Override
    public Produto pesquisaPeloId(Long id) {
        return entityM.find(Produto.class, id);
    }

    @Override
    public List<Produto> listaTodos() {
        Query query = entityM.createQuery("select  p from Produto p");
        return (List<Produto>) query.getResultList();
    }

    @Override
    public void insere(Produto produto) {
        entityM.persist(produto);
    }

    @Override
    public void atualiza(Produto produto) {
        entityM.merge(produto);
    }

    @Override
    public void remove(Produto produto) {
        entityM.remove(produto);
    }
}
