package br.com.dextra.treinamento.model.service.sessionbean;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name="TesteStatelessImpl")
@Local
public class TesteStatelessImpl implements TesteStatelessLocal {

    private Integer contador = 0;
    
    @Override
    public Integer adicionar(){
	contador++;
	return contador;
    }
    
}