package br.com.dextra.treinamento.model.service.jpa;

import java.util.List;

import br.com.dextra.treinamento.model.domain.Post;

public interface PostService {

    public void salvar(Post p);
    
    public void remover(Long id);

    public List<Post> listar();

    public List<Post> getPosts();

    public void setPosts(List<Post> posts);

}
