package br.com.dextra.treinamento.controller.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.dextra.treinamento.model.service.transaction.TestarTransacoesLocal;

@ManagedBean(name = "testarTransactionsMB")
@SessionScoped
public class TestarTransactionsMB {

    @EJB
    TestarTransacoesLocal testarTransacoesLocal;

    private Long contadorInicio;

    public void testeTransacoesRequired() {

	contadorInicio = testarTransacoesLocal.contador();
	try {
	    testarTransacoesLocal.testarRequired();
	} catch (Exception e) {
	}

	System.out.println(testarTransacoesLocal.contador() - contadorInicio);
    }

    public void testeTransacoesRequiresNew() {

	contadorInicio = testarTransacoesLocal.contador();
	try {
	    testarTransacoesLocal.testarRequiresNew();
	} catch (Exception e) {
	}
	System.out.println(testarTransacoesLocal.contador() - contadorInicio);
    }
}
