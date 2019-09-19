package webdemo.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webdemo.entidades.Usuario;

public class UsuariosController extends Controller {
	
	public UsuariosController(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void list() throws ServletException, IOException {
		List<Usuario> usuarios = Usuario.Todos();
		
		getRequest().setAttribute("Usuarios", usuarios);
			
		getRequest().getRequestDispatcher("/WEB-INF/templates/usuarios/list.jsp")
			.forward(getRequest(), getResponse());
	}
	
	@Override
	public void show(int id) {
		//TODO: Implementar
	}
	
	@Override
	public void create() throws ServletException, IOException {
		getRequest().getRequestDispatcher("/WEB-INF/templates/usuarios/criar.jsp")
			.forward(getRequest(), getResponse());
	}
	
	@Override
	public void create(Map<String, String> formData) throws IOException, ServletException {
		
		if(isValid(formData)) {
			String nome = formData.get("nome");
			String sobrenome = formData.get("sobrenome");
			
			Usuario usuario = new Usuario(nome, sobrenome);
			usuario.salvar();
			
			getResponse().sendRedirect("/usuarios?success=true");
		}else {
			getRequest()
				.getRequestDispatcher("/WEB-INF/templates/usuarios/criar.jsp?success=false")
				.forward(getRequest(), getResponse());
		}
	}
	
	@Override
	public void edit(int id) throws ServletException, IOException {
		Usuario usuario = Usuario.GetById(id);
		
		getRequest().setAttribute("Usuario", usuario);
		
		getRequest().getRequestDispatcher("/WEB-INF/templates/usuarios/editar.jsp")
			.forward(getRequest(), getResponse());	
	}
	
	@Override
	public void edit(int id, Map<String, String> formData) throws IOException, ServletException {
		Usuario usuario = Usuario.GetById(id);
		
		String nome = formData.get("nome");
		String sobrenome = formData.get("sobrenome");
		
		if(isValid(formData)) {
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.salvar();
			
			getResponse().sendRedirect("/usuarios?success=true");
		}else {
			Usuario usuarioInvalido = new Usuario(nome, sobrenome);
			usuarioInvalido.setId(id);
			getRequest().setAttribute("Usuario", usuario);
			
			getRequest()
				.getRequestDispatcher("/WEB-INF/templates/usuarios/editar.jsp?success=false")
				.forward(getRequest(), getResponse());
		}
	}
	
	private boolean isValid(Map<String, String> formData) throws UnsupportedEncodingException {
		boolean isValid = true;
	
		if(!formData.containsKey("nome") || formData.get("nome").isEmpty()) {
			getRequest().setAttribute("NomeInvalido", "O nome é obrigatório!");
			isValid = false;
		}
		
		if(!formData.containsKey("sobrenome") || formData.get("sobrenome").isEmpty()) {
			getRequest().setAttribute("SobrenomeInvalido", "O sobrenome é obrigatório!");
			isValid = false;
		}
				
		return isValid;
	}
}
