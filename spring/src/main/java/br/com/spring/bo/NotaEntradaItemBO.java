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
    private NotaEntradaItemDAO neDAO;

    @Override
    public NotaEntradaItem pesquisaPeloId(Long id) {
        return neDAO.pesquisaPeloId(id);
    }

    @Override
    public List<NotaEntradaItem> listaTodos() {
        return neDAO.listaTodos();
    }

    @Override
    public void insere(NotaEntradaItem notaEntradaItem) {
        neDAO.insere(notaEntradaItem);
    }

    @Override
    public void atualiza(NotaEntradaItem notaEntradaItem) {
        neDAO.atualiza(notaEntradaItem);
    }

    @Override
    public void remove(NotaEntradaItem notaEntradaItem) {
        neDAO.remove(notaEntradaItem);
    }
}
