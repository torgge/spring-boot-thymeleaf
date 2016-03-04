package com.algaworks.cobranca.service;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * Created by torgge on 04/03/2016.
 */
@Service
public class CadastroTituloService {

    @Autowired
    private Titulos titulos;

    public void salvar(Titulo titulo) {
        try {
            titulos.save(titulo);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválido.");
        }
    }

    public void excluir(Long codigo) {
        titulos.delete(codigo);
    }

}
