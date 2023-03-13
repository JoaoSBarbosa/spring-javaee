package br.com.spring.bo;

import br.com.spring.dao.CRUD;
import br.com.spring.dao.ClienteDAO;
import br.com.spring.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteBO implements CRUD<Cliente, Long> {

    @Autowired
    private ClienteDAO dao;

    @Override
    public Cliente pesquisaPeloId(Long id) {
        return dao.pesquisaPeloId(id);
    }

    @Override
    public List<Cliente> listaTodos() {
        return dao.listaTodos();
    }

    @Override
    public void insere(Cliente cliente) {
        dao.insere(cliente);
    }

    @Override
    public void atualiza(Cliente cliente) {
        dao.atualiza(cliente);
    }

    @Override
    public void remove(Cliente cliente) {
        dao.remove(cliente);
    }

    public void inativa(Cliente cliente) {
        cliente.setAtivo(false);
        dao.atualiza(cliente);
    }

    public void ativa(Cliente cliente) {
        cliente.setAtivo(true);
        dao.atualiza(cliente);
    }
}