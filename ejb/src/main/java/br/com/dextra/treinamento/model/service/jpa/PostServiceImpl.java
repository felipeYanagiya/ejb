package br.com.dextra.treinamento.model.service.jpa;

import java.util.ArrayList;
import java.util.List;

import br.com.dextra.treinamento.model.domain.Post;

public class PostServiceImpl {
	
	private List<Post> posts = new ArrayList<Post>();
	
	public void salvar(Post p) {
	}
	
	public List<Post> listar() {
		return posts;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
