package br.com.spring.bo;


import br.com.spring.dao.CRUD;
import br.com.spring.dao.NotaEntradaItemDAO;
import br.com.spring.model.NotaEntradaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotaEntradaItemBO implements CRUD<NotaEntradaItem, Long> {

    @Autowired
    private NotaEntradaItemDAO dao;

    @Override
    public NotaEntradaItem pesquisaPeloId(Long id) {
        return dao.pesquisaPeloId(id);
    }

    @Override
    public List<NotaEntradaItem> listaTodos() {
        return dao.listaTodos();
    }

    @Override
    public void insere(NotaEntradaItem notaEntradaItem) {
        dao.insere(notaEntradaItem);
    }

    @Override
    public void atualiza(NotaEntradaItem notaEntradaItem) {
        dao.atualiza(notaEntradaItem);
    }

    @Override
    public void remove(NotaEntradaItem notaEntradaItem) {
        dao.remove(notaEntradaItem);
    }

    public boolean itemJaAdicionado(NotaEntradaItem notaEntradaItem) {
        Long notaEntradaId = notaEntradaItem.getNotaEntrada().getId();
        List<NotaEntradaItem> itens = dao.listaItensNota(notaEntradaId);

        Long produtoId = notaEntradaItem.getProduto().getId();

        if (notaEntradaItem.getId() == null) {
            for (NotaEntradaItem item : itens) {
                if (item.getProduto().getId() == produtoId) {
                    return true;
                }
            }
        } else {
            Long notaEntradaItemId = notaEntradaItem.getId();
            for (NotaEntradaItem item : itens) {
                if (item.getProduto().getId() == produtoId && notaEntradaItemId != item.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

}
