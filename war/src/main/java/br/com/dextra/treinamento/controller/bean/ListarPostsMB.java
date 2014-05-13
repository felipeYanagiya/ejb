package br.com.dextra.treinamento.controller.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.jpa.PostService;

@ManagedBean(name = "listarPostsMB")
@SessionScoped
public class ListarPostsMB {

    private static final String INDEX_XHTML = "index.xhtml";

    private static final String INCLUIR_POST = "incluirPost.xhtml";

    private static final String LISTAR_POSTS = "listarPosts.xhtml";
    
    private static final String ALTERAR_POST = "alterarPost.xhtml";

    private List<Post> posts;

    private Post post = new Post();

    private Post novoPost;

    @EJB
    private PostService postService;

    public String listar() {
	posts = postService.listar();
	return LISTAR_POSTS;
    }

    public String incluir() {
	this.novoPost = new Post();
	return INCLUIR_POST;
    }

    public String salvar() {
	postService.salvar(novoPost);
	return listar();
    }

    public String cancelar() {
	return LISTAR_POSTS;
    }

    public String prepararAlteracao(Long postId) {
	this.novoPost = postService.findById(postId);
	if (novoPost != null){
	    return ALTERAR_POST;
	}
	return LISTAR_POSTS;
    }

    public String remover(Long postId) {
	postService.remover(postId);
	return LISTAR_POSTS;
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
