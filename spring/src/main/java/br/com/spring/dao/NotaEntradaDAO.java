package br.com.spring.dao;

import br.com.spring.model.NotaEntrada;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NotaEntradaDAO implements CRUD<NotaEntrada, Long> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public NotaEntrada pesquisaPeloId(Long id) {
        return em.find(NotaEntrada.class, id);
    }

    @Override
    public List<NotaEntrada> listaTodos() {
        Query query = em.createQuery("select ne from NotaEntrada  ne");
        return query.getResultList();
    }

    @Override
    public void insere(NotaEntrada notaEntrada) {
        em.persist(notaEntrada);
    }

    @Override
    public void atualiza(NotaEntrada notaEntrada) {
        em.merge(notaEntrada);
    }

    @Override
    public void remove(NotaEntrada notaEntrada) {
        em.remove(notaEntrada);
    }



}
