package br.com.spring.bo;

import br.com.spring.dao.CRUD;
import br.com.spring.dao.ProdutoEstoqueDAO;
import br.com.spring.model.ProdutoEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoEstoqueBO implements CRUD<ProdutoEstoque, Long> {

    @Autowired
    ProdutoEstoqueDAO peDAO;

    @Override
    public ProdutoEstoque pesquisaPeloId(Long id) {
        return peDAO.pesquisaPeloId(id);
    }

    @Override
    public List<ProdutoEstoque> listaTodos() {
        return peDAO.listaTodos();
    }

    @Override
    public void insere(ProdutoEstoque pe) {
        peDAO.insere(pe);
    }

    @Override
    public void atualiza(ProdutoEstoque pe) {
        peDAO.atualiza(pe);
    }

    @Override
    public void remove(ProdutoEstoque pe) {
        peDAO.remove(pe);
    }
}
