package br.com.spring.dao;

import br.com.spring.model.NotaEntradaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NotaEntradaItemDAO implements CRUD<NotaEntradaItem, Long> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public NotaEntradaItem pesquisaPeloId(Long id) {
        return em.find(NotaEntradaItem.class, id);
    }

    @Override
    public List<NotaEntradaItem> listaTodos() {
        Query query = em.createQuery("select nei from NotaEntrada  nei");
        return query.getResultList();
    }

    @Override
    public void insere(NotaEntradaItem notaEntradaItem) {
        em.persist(notaEntradaItem);
    }

    @Override
    public void atualiza(NotaEntradaItem notaEntradaItem) {
        em.merge(notaEntradaItem);
    }

    @Override
    public void remove(NotaEntradaItem notaEntradaItem) {
        em.remove(notaEntradaItem);
    }

    public List<NotaEntradaItem> listaItensNota(Long notaEntradaId){
        Query query = em.createQuery("from NotaEntradaItem n where n.notaEntrada.id = :notaEntradaId")
                .setParameter("notaEntradaId",notaEntradaId);
        return query.getResultList();
    }
}
