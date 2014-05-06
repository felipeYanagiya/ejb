package br.com.dextra.treinamento.controller.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.dextra.treinamento.model.service.jms.TesteJMSLocal;

@ManagedBean(name="testarJMS")
@SessionScoped
public class TestarJMS {

    @EJB
    private TesteJMSLocal testeJMSLocal;
    
    public void enviarParaFila(){
	testeJMSLocal.enviarMensagemQueue();
    }
    
}
