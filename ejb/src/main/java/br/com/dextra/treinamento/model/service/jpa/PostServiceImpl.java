package br.com.dextra.treinamento.model.service.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dextra.treinamento.model.domain.Post;

@Stateful
public class PostServiceImpl implements PostService {

    private List<Post> posts = new ArrayList<Post>();

    @PersistenceContext(name = "blog-pu")
    private EntityManager em;

    public void salvar(Post p) {
	em.merge(p);
    }

    public void remover(Long id) {
	Post post = em.find(Post.class, id);
	em.remove(em.merge(post));
    }

    @SuppressWarnings("unchecked")
    public List<Post> listar() {
	String sql = "select p from Post p";
	Query query = em.createQuery(sql);
	return query.getResultList();
    }

    public List<Post> getPosts() {
	return posts;
    }

    public void setPosts(List<Post> posts) {
	this.posts = posts;
    }
}
