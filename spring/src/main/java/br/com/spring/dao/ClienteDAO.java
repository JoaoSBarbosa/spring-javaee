package br.com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import br.com.spring.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ClienteDAO implements CRUD<Cliente, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cliente pesquisaPeloId(Long id) {
        return entityManager.find(Cliente.class, id);
    }
    @Override
    public List<Cliente> listaTodos() {
        Query query = entityManager.createQuery("select c from Cliente c");
        return (List<Cliente>) query.getResultList();
    }
    @Override
    public void insere(Cliente cliente) {
        entityManager.persist(cliente);
    }
    @Override
    public void atualiza(Cliente cliente) {
        entityManager.merge(cliente);
    }
    @Override
    public void remove(Cliente cliente) {
        entityManager.remove(cliente);
    }
}