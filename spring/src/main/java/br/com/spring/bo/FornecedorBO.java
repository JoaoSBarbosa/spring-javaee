package br.com.spring.bo;

import br.com.spring.dao.CRUD;
import br.com.spring.dao.FornecedorDAO;
import br.com.spring.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorBO implements CRUD<Fornecedor, Long> {
    @Autowired
    private FornecedorDAO fdao; //FornecedorDAO é a classe de acesso a dados

    @Override
    public Fornecedor pesquisaPeloId(Long id) {
        return fdao.pesquisaPeloId(id);
    }

    @Override
    public List<Fornecedor> listaTodos() {
        return fdao.listaTodos();
    }

    @Override
    public void insere(Fornecedor fornecedor) {
        fdao.insere(fornecedor);
    }

    @Override
    public void atualiza(Fornecedor fornecedor) {
        fdao.atualiza(fornecedor);
    }

    @Override
    public void remove(Fornecedor fornecedor) {
        fdao.remove(fornecedor);
    }
    public void inativa(Fornecedor fornecedor){
        fornecedor.setAtivo(false);
        fdao.atualiza(fornecedor);
    }
    public void ativa(Fornecedor fornecedor){
        fornecedor.setAtivo(true);
        fdao.atualiza(fornecedor);
    }
}
