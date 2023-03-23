package br.com.spring.api;

import br.com.spring.bo.ProdutoBO;
import br.com.spring.bo.ProdutoEstoqueBO;
import br.com.spring.model.Produto;
import br.com.spring.model.ProdutoEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoEstoqueRestController {

    @Autowired
    private ProdutoEstoqueBO produtoEstoqueBO;

    @Autowired
    private ProdutoBO produtoBO;

    @RequestMapping(value="/api/estoque", method = RequestMethod.GET)
    public List<ProdutoEstoque> listaTodos() {
        return produtoEstoqueBO.listaTodos();
    }

    @RequestMapping(value="/api/estoque/{id}", method = RequestMethod.GET)
    public ProdutoEstoque pesquisaPeloId(@PathVariable Long id) {
        return produtoEstoqueBO.pesquisaPeloId(id);
    }

    @RequestMapping(value="/api/estoque", method = RequestMethod.POST)
    public ProdutoEstoque insere(@RequestBody ProdutoEstoque produtoEstoque) {
        Produto produto = produtoBO.pesquisaPeloId(produtoEstoque.getProduto().getId());
        produtoEstoque.setProduto(produto);
        produtoEstoqueBO.insere(produtoEstoque);
        return produtoEstoque;
    }

    @RequestMapping(value="/api/estoque/{id}", method = RequestMethod.PUT)
    public ProdutoEstoque atualiza(@PathVariable Long id, @RequestBody ProdutoEstoque produtoEstoque) {
        produtoEstoque.setId(id);
        produtoEstoque.setProduto(produtoBO.pesquisaPeloId(produtoEstoque.getProduto().getId()));
        produtoEstoqueBO.atualiza(produtoEstoque);
        return produtoEstoque;
    }

    @RequestMapping(value="/api/estoque/{id}", method = RequestMethod.DELETE)
    public ProdutoEstoque remove(@PathVariable Long id) {
        ProdutoEstoque produtoEstoque = produtoEstoqueBO.pesquisaPeloId(id);
        produtoEstoqueBO.remove(produtoEstoque);
        return produtoEstoque;
    }
}
