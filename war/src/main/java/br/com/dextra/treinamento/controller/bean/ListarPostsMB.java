package br.com.dextra.treinamento.controller.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.dextra.treinamento.model.domain.Post;

@ManagedBean(name = "listarPostsMB")
@SessionScoped
public class ListarPostsMB {

	private static final String INDEX_XHTML = "index.xhtml";

	private static final String INCLUIR_POST = "incluirPost.xhtml";

	private static final String LISTAR_POSTS = "listarPosts.xhtml";

	private List<Post> posts;

	private Post post = new Post();

	private Post novoPost;

	public String listar() {
		return LISTAR_POSTS;
	}

	public String incluir() {
		this.novoPost = new Post();
		return INCLUIR_POST;
	}

	public String salvar() {
		return LISTAR_POSTS;
	}

	public String cancelar() {
		return LISTAR_POSTS;
	}

	public void prepararAlteracao() {

	}

	public void remover() {

	}

	public String voltar() {
		return INDEX_XHTML;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post getNovoPost() {
		return novoPost;
	}

	public void setNovoPost(Post novoPost) {
		this.novoPost = novoPost;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
