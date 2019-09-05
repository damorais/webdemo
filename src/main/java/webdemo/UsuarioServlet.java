package webdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.base.Strings;

import webdemo.entidades.Usuario;

//TODO: Preciso adicionar uma rota para edição aqui /usuarios/editar?id=123 . Como faço isso?
@WebServlet(urlPatterns = {"/usuarios/novo"})
public class UsuarioServlet extends HttpServlet {
	
	@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		//TODO: A edição também será responsabilidade deste Servlet. Como faço para diferenciar a criação da edição?
		request.getRequestDispatcher("/WEB-INF/templates/usuarios/criar.jsp")
			.forward(request, response);
	}
	
	//TODO: Vou precisar tratar o método POST aqui para representar o envio do formulário de edição!
	
	private static final long serialVersionUID = 370391190002278430L;
}
