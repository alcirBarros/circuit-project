package br.com.modulo.administracao.registroimportacao.service;

import br.com.modulo.administracao.pessoa.dao.RegistroImportacaoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroImportacaoService {

    @Autowired
    private RegistroImportacaoDAO registroImportacaoDAO;


}
