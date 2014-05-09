package br.com.dextra.treinamento.model.service.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.jpa.PostService;

@Stateless
@WebService(name = TesteWebServiceInterface.WEB_SERVICE_NAME, portName = TesteWebServiceInterface.PORT_NAME,
	serviceName = TesteWebServiceInterface.SERVICE_NAME,
	targetNamespace = TesteWebServiceInterface.TARGET_NAME_SPACE)
@SOAPBinding(style = Style.RPC)
public class TesteWebServiceImpl implements TesteWebServiceInterface {

    @EJB
    private PostService postService;

    @WebMethod
    public void testarChamada() {
	System.out.println("O serviço foi chamado");
    }

    @WebMethod
    public void adicionarPost(@WebParam(name = "titulo") String titulo, @WebParam(name = "descricao") String descricao) {
	Post post = new Post(titulo, descricao);
	postService.salvar(post);
    }

    @WebMethod
    public void listarPosts() {
	List<Post> posts = postService.listar();
	for (Post post : posts) {
	    System.out.println("Post: " + post.toString());
	}
    }

}
