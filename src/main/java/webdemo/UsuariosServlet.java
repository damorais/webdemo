package webdemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import webdemo.entidades.Usuario;

@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet {

	@Override	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws IOException, ServletException {
		List<Usuario> usuarios = Usuario.All();
		
		request.setAttribute("Usuarios", usuarios);
			
		request.getRequestDispatcher("/WEB-INF/templates/usuarios/list.jsp")
			.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(isValid(request)) {
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			
			Usuario usuario = new Usuario(nome, sobrenome);
			usuario.save();
			
			response.sendRedirect("/usuarios?success=true");
		}else {
			request.getRequestDispatcher("/WEB-INF/templates/usuarios/create.jsp?success=false").forward(request, response);
		}

	}
	
	private boolean isValid(HttpServletRequest request) throws UnsupportedEncodingException {
		boolean isValid = true;
	
		if(Strings.isNullOrEmpty(request.getParameter("nome"))) {
			//request.setAttribute("NomeInvalido", new String("O nome é obrigatório!".getBytes(), "UTF-8"));
			request.setAttribute("NomeInvalido", "O nome é obrigatório!");
			isValid = false;
		}
			
		if(Strings.isNullOrEmpty(request.getParameter("sobrenome"))) {
			request.setAttribute("SobrenomeInvalido", "O sobrenome é obrigatório!");
			isValid = false;
		}
		
		return isValid;
	}
					
	
	private static final long serialVersionUID = 3931640733487616093L;
}
