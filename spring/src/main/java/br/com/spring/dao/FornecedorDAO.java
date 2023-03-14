package br.com.spring.dao;

import br.com.spring.model.Cliente;
import br.com.spring.model.Fornecedor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FornecedorDAO implements CRUD<Fornecedor, Long> {

    @PersistenceContext // Anotação Hibernate para ele gerenciar ciclo de vida das entidade
    private EntityManager em; // Responsavel por realizar a persistencia de dados no SGBD


    @Override
    public Fornecedor pesquisaPeloId(Long id) {
        return em.find(Fornecedor.class, id); // Find é um método de entityManager, que localiza um objeto no SGBD através do seu id
    }

    @Override
    public List<Fornecedor> listaTodos() {
        Query query = em.createQuery("select f from Fornecedor f"); // query é UM método do Hibernate para fazer uma consulta no SGBD
        return (List<Fornecedor>) query.getResultList();
    }

    @Override
    public void insere(Fornecedor fornecedor) {
        em.persist(fornecedor);
    }

    @Override
    public void atualiza(Fornecedor fornecedor) {
        em.merge(fornecedor);
    }
    @Override
    public void remove(Fornecedor fornecedor) {
        em.remove(fornecedor);
    }
}
