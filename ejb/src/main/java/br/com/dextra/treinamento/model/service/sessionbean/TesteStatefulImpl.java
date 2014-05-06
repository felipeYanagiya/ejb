package br.com.dextra.treinamento.model.service.sessionbean;

import javax.ejb.Local;
import javax.ejb.Stateful;

@Stateful(name="TesteStatefulImpl")
@Local
public class TesteStatefulImpl implements TesteStatefulLocal {

    private Integer contador = 0;
    
    @Override
    public Integer adicionar(){
	contador++;
	return contador;
    }
    
}
