package br.com.dextra.treinamento.model.service.transaction;

import javax.ejb.Local;

@Local
public interface SalvarComRequiresNewLocal {

    public void salvarPost(String titulo);
    
}
