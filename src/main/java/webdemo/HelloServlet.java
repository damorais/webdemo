package webdemo;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = { "/hello" }, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -2459069235625043917L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print("Hello, World!");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String idade = request.getParameter("idade");
		
		String valorDaBatata = request.getParameter("batata");
		
		String resultado = name + ", " + idade + " anos - possui " 
				+ valorDaBatata + " batatas";
		
		if (name == null)
			name = "World";
		
		request.setAttribute("user", resultado);
		request.getRequestDispatcher("response.jsp").forward(request, response);
	}
}
