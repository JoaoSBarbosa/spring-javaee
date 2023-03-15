package br.com.spring.bo;

import br.com.spring.dao.CRUD;
import br.com.spring.dao.ProdutoDAO;
import br.com.spring.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoBO implements CRUD<Produto, Long> {


    @Autowired
    private ProdutoDAO produtoDAO;

    @Override
    public Produto pesquisaPeloId(Long id) {
        return produtoDAO.pesquisaPeloId(id);
    }

    @Override
    public List<Produto> listaTodos() {
        return produtoDAO.listaTodos();
    }

    @Override
    public void insere(Produto produto) {
        produtoDAO.insere(produto);
    }

    @Override
    public void atualiza(Produto produto) {
        produtoDAO.atualiza(produto);
    }

    @Override
    public void remove(Produto produto) {
        produtoDAO.remove(produto);
    }
    public void ativa(Produto produto){
        produto.setAtivo(true);
        produtoDAO.atualiza(produto);
    }
    public void inativa(Produto produto){
        produto.setAtivo(false);
        produtoDAO.atualiza(produto);
    }

}
