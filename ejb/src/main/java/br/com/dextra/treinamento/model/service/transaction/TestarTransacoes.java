package br.com.dextra.treinamento.model.service.transaction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TestarTransacoes implements TestarTransacoesLocal {

    @PersistenceContext(name = "blog-pu")
    private EntityManager em;
    
    @EJB
    private SalvarComRequiredLocal salvarComRequiredLocal;
    @EJB
    private SalvarComRequiresNewLocal salvarComRequiresNewLocal;

    public void testarRequired() {
	salvarComRequiredLocal.salvarPost("Salvar Com Required Local");
	salvarComRequiredLocal.salvarPost(null);
    }

    public void testarRequiresNew() {
	salvarComRequiresNewLocal.salvarPost("Salvar com Requires New");
	salvarComRequiresNewLocal.salvarPost(null);
    }

    public Long contador() {
	String sql = "select count(*) from Post";
	Long query = (Long) em.createQuery(sql).getSingleResult();
	return query;
    }

}
