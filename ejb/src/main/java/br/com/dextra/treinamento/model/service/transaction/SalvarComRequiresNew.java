package br.com.dextra.treinamento.model.service.transaction;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dextra.treinamento.model.domain.Post;

@Stateless
public class SalvarComRequiresNew implements SalvarComRequiresNewLocal {

    @PersistenceContext(name = "blog-pu")
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void salvarPost(String titulo) {
	Post p = new Post();
	p.setTitulo(titulo.toString());
	em.persist(p);

    }

}
