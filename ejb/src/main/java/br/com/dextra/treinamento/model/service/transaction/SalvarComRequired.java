package br.com.dextra.treinamento.model.service.transaction;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dextra.treinamento.model.domain.Post;

@Stateless
public class SalvarComRequired implements SalvarComRequiredLocal {

    @PersistenceContext(name = "blog-pu")
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvarPost(String titulo) {
	Post p = new Post();
	p.setTitulo(titulo.toString());
	em.persist(p);
    }

}
