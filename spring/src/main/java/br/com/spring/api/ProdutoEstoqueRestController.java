package br.com.spring.api;

import br.com.spring.bo.ProdutoBO;
import br.com.spring.bo.ProdutoEstoqueBO;
import br.com.spring.model.ProdutoEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoEstoqueRestController {

    @Autowired
    private ProdutoEstoqueBO peBO;

    @Autowired
    private ProdutoBO produtoBO;
    // Métodos

    @RequestMapping(value = "/api/estoque/", method = RequestMethod.GET)
    public List<ProdutoEstoque> listaTodos(){
        return peBO.listaTodos();
    }

    @RequestMapping(value = "/api/estoque/{id}", method = RequestMethod.GET)
    public  ProdutoEstoque pesquisaPeloId(@PathVariable Long id){
        return peBO.pesquisaPeloId(id);
    }

    @RequestMapping(value = "/api/estoque", method = RequestMethod.POST)
    public ProdutoEstoque insere(@RequestBody ProdutoEstoque produtoEstoque){
        peBO.insere(produtoEstoque);
        return produtoEstoque;
    }

    @RequestMapping(value = "/api/estoque/{id}", method = RequestMethod.PUT)
    public ProdutoEstoque atualiza(@PathVariable Long id, @RequestBody ProdutoEstoque produtoEstoque){
        produtoEstoque.setId(id);
        produtoEstoque.setProduto(produtoBO.pesquisaPeloId(produtoEstoque.getProduto().getId()));
        peBO.atualiza(produtoEstoque);
        return produtoEstoque;
    }

    @RequestMapping(value = "/api/estoque/{id}", method = RequestMethod.DELETE)
    public ProdutoEstoque remove(@PathVariable Long id){
        ProdutoEstoque produtoEstoque = peBO.pesquisaPeloId(id);
        peBO.remove(produtoEstoque);
        return produtoEstoque;
    }

}
