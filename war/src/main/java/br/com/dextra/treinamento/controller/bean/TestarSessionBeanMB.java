package br.com.dextra.treinamento.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.dextra.treinamento.model.service.sessionbean.TesteStatefulLocal;
import br.com.dextra.treinamento.model.service.sessionbean.TesteStatelessLocal;

@ManagedBean(name = "testarSessionBeanMB")
@RequestScoped
public class TestarSessionBeanMB {

    public void testStateless() {
	try {
	    InitialContext ctx = new InitialContext();
	    TesteStatelessLocal teste = (TesteStatelessLocal) ctx.lookup("/blog/TesteStatelessImpl/local");

	    List<Integer> numeros = new ArrayList<Integer>();

	    numeros.add(teste.adicionar());
	    numeros.add(teste.adicionar());
	    numeros.add(teste.adicionar());

	    teste = (TesteStatelessLocal) ctx.lookup("/blog/TesteStatelessImpl/local");

	    numeros.add(teste.adicionar());
	    numeros.add(teste.adicionar());
	    numeros.add(teste.adicionar());

	    System.out.println("Número: " + numeros.toString());

	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }

    public void testStateful() {

	try {
	    InitialContext ctx = new InitialContext();
	    TesteStatefulLocal teste = (TesteStatefulLocal) ctx.lookup("/blog/TesteStatefulImpl/local");

	    List<Integer> numeros = new ArrayList<Integer>();

	    numeros.add(teste.adicionar());
	    numeros.add(teste.adicionar());
	    numeros.add(teste.adicionar());

	    teste = (TesteStatefulLocal) ctx.lookup("/blog/TesteStatefulImpl/local");

	    numeros.add(teste.adicionar());
	    numeros.add(teste.adicionar());
	    numeros.add(teste.adicionar());

	    System.out.println("Número: " + numeros.toString());

	} catch (NamingException e) {
	    e.printStackTrace();
	}

    }

}
