package br.com.dextra.treinamento.model.service.transaction;

import javax.ejb.Local;

@Local
public interface TestarTransacoesLocal {
    
    Long contador();
    
    void testarRequired();
    
    void testarRequiresNew();
    
}
