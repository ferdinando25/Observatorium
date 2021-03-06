package br.edu.ifsp.observatorium.controllers;

import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ifsp.observatorium.dao.usuario.UsuarioDAOImpl;
import br.edu.ifsp.observatorium.models.Usuario;

@Controller
public class UsuarioController {
	
	private UsuarioDAOImpl dao;
	
	@Inject
	private Validator validator;
	
	@Inject
	private Result result;
	
	public UsuarioController() {
		this.dao = new UsuarioDAOImpl();
	}
	
	@Get
	@Path("/cadastrar/usuario")
	public void cadastroUsuario() {
		
	}
	
	@Post
	@Path("/cadastrar/usuario")
	public void cadastrar (Usuario usuario) {
		
		if (usuario != null) {
			if(usuario.getUsu_email() == null) {
				validator.add(new SimpleMessage("email","Favor adicionar o email."));
			}
			if (usuario.getUsu_senha() == null) {
				validator.add(new SimpleMessage("senha","Favor adicionar a senha."));
			}
			if(usuario.getUsu_nome() == null) {
				validator.add(new SimpleMessage("nome", "Favor adicionar o nome."));
			}
			if(usuario.getUsu_tipo() == null || usuario.getUsu_tipo().equals("")) {
				usuario.setUsu_tipo("U");
			}
		}else {
			validator.add(new SimpleMessage("form", "Favor adicionar dados corretamente."));
		}

		validator.onErrorUsePageOf(UsuarioController.class).cadastroUsuario();
			
		dao.persist(usuario);
		result.redirectTo(LoginController.class).login();
		
	}
}