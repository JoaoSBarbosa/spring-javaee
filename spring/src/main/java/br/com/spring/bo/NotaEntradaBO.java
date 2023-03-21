package br.com.spring.bo;

import br.com.spring.dao.CRUD;
import br.com.spring.dao.NotaEntradaDAO;
import br.com.spring.model.NotaEntrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaEntradaBO implements CRUD<NotaEntrada, Long> {

    @Autowired
    private NotaEntradaDAO notaEntradaDAO;
    @Override
    public NotaEntrada pesquisaPeloId(Long id) {
        return notaEntradaDAO.pesquisaPeloId(id);
    }

    @Override
    public List<NotaEntrada> listaTodos() {
        return notaEntradaDAO.listaTodos();
    }

    @Override
    public void insere(NotaEntrada notaEntrada) {
        notaEntradaDAO.insere(notaEntrada);
    }

    @Override
    public void atualiza(NotaEntrada notaEntrada) {
    notaEntradaDAO.atualiza(notaEntrada);
    }

    @Override
    public void remove(NotaEntrada notaEntrada) {
    notaEntradaDAO.remove(notaEntrada);
    }
}
