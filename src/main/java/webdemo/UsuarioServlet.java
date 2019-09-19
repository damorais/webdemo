package webdemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import webdemo.controllers.UsuariosController;
import webdemo.entidades.Usuario;

//TODO: Preciso adicionar uma rota para edição aqui /usuarios/editar?id=123 . Como faço isso?
//@WebServlet(urlPatterns = {"/usuarios/novo", "/usuarios/editar"})
public class UsuarioServlet extends HttpServlet {
	
	@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		String[] path = request.getRequestURI().split("/");
		
		UsuariosController controller = new UsuariosController(request, response);
		
		if(path[2].startsWith("novo")){
			controller.create();
			
		}else if(path[2].startsWith("editar")) {
			
			String idParam = request.getParameter("id");
			
			if(!Strings.isNullOrEmpty(idParam))
				controller.edit(Integer.parseInt(idParam));
		}else {
			//TODO: Deu ruim!
		}
			
	}
	
	@Override	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		String idParam = request.getParameter("id");
		
		if(!Strings.isNullOrEmpty(idParam)) {
			
			HashMap<String, String> formData = new HashMap<String, String>();
			
			Enumeration<String> param = request.getParameterNames();
			
			while(param.hasMoreElements()) {
				String element = param.nextElement();
				formData.put(element, request.getParameter(element));
			}
			
			new UsuariosController(request, response)
				.edit(Integer.parseInt(request.getParameter("id")), formData);
		}
	}
	
	//TODO: Vou precisar tratar o método POST aqui para representar o envio do formulário de edição!
	
	private static final long serialVersionUID = 370391190002278430L;
}
