package webdemo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webdemo.entidades.Usuario;

@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet {
	
	@Override	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws IOException, ServletException {
		
		ArrayList<Usuario> usuarios = Usuario.GetUsuarios();
		
		request.setAttribute("Usuarios", usuarios);
		request.setAttribute("Batata", "frita");
		
		request.getRequestDispatcher("usuarios.jsp")
			.forward(request, response);
		
		
//		
//		
//		response.getWriter().println("<HTML>");
//		response.getWriter().println("<body>");
//		response.getWriter().println("<ul>");
//		
//		for(Usuario usuario : usuarios) {
//			response.getWriter().print("<li>");
//			response.getWriter().print(usuario.getNome());
//			response.getWriter().println("</li>");
//		}
//		response.getWriter().println("</ul>");
//		response.getWriter().println("</body>");
//		response.getWriter().println("</HTML>");
	}
}
