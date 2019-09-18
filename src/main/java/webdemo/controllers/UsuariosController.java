package webdemo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webdemo.entidades.Usuario;

public class UsuariosController {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public UsuariosController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public void list() throws ServletException, IOException {
		
		List<Usuario> usuarios = Usuario.Todos();
		
		request.setAttribute("Usuarios", usuarios);
			
		request.getRequestDispatcher("/WEB-INF/templates/usuarios/list.jsp").forward(request, response);
	}
	
	public void show(int id) throws ServletException, IOException {
		
		Usuario usuario = Usuario.GetById(id);
		
		request.setAttribute("Usuario", usuario);
		
		request.getRequestDispatcher("/WEB-INF/templates/usuarios/show.jsp").forward(request, response);
	}
	
	public void create() throws ServletException, IOException { 
		request.getRequestDispatcher("/WEB-INF/templates/usuarios/create.jsp").forward(request, response);
	}
	
	public void create(Map<String, String> formData) throws IOException, ServletException { 
		if(isValid(formData)) {
			String nome = formData.get("nome");
			String sobrenome = formData.get("sobrenome");
			
			Usuario usuario = new Usuario(nome, sobrenome);
			usuario.salvar();
			
			response.sendRedirect("/usuarios");
		} else {
			request.getRequestDispatcher("/WEB-INF/templates/usuarios/create.jsp?success=false").forward(request, response);
		}
	}
	
	public void edit(int id) {
		//???
	}
	
	public void edit(int id, Map<String, String> formData) {
		//???
	}
	
	
	private boolean isValid(Map<String, String> formData){
		boolean isValid = true;
	
		if(!formData.containsKey("nome") || formData.get("nome").isEmpty()) {
			//request.setAttribute("NomeInvalido", new String("O nome é obrigatório!".getBytes(), "UTF-8"));
			request.setAttribute("NomeInvalido", "O nome é obrigatório!");
			isValid = false;
		}
			
		if(!formData.containsKey("sobrenome") || formData.get("sobrenome").isEmpty()) {
			request.setAttribute("SobrenomeInvalido", "O sobrenome é obrigatório!");
			isValid = false;
		}
		
		return isValid;
	}	
}
