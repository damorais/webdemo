package webdemo;

import static org.apache.commons.lang3.RegExUtils.removeFirst;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import webdemo.controllers.UsuariosController;

@WebServlet("/fc/*")
public class FrontControllerServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//1: Capturar o endereço da requisição
		//2: Direcionar para o endereço adequado
		//3: Profit!
		
		//Exemplos de caminho: /usuarios
		
		String path = removeFirst(request.getRequestURI(), "/fc/");
		
		String[] paramsUrl = path.split("/");
		
		System.out.println("Parâmetros: ");
		for(int i = 0; i < paramsUrl.length; i++)
			System.out.println(i + ": " + paramsUrl[i]);
		System.out.println(":FIM:");
		
		switch(paramsUrl[0]) {
		case "usuarios":
			UsuariosController controller = new UsuariosController(request, response);
			
			if(paramsUrl.length == 1 || paramsUrl[1].equals("list"))
				controller.list();
			else if(paramsUrl[1].equals("create"))
				controller.create();
			else if(paramsUrl.length == 2) {
				int id = Integer.parseInt(paramsUrl[1]);
				controller.show(id);
			}
			
			//TODO: Adicionar tratamento sobre caminho não encontrado
			
			break;
		default:
			//TODO: Adicionar tratamento sobre caminho não encontrado
			//Responder com um 404;
			break;
		}
		
		response.getWriter().println(path);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = removeFirst(request.getRequestURI(), "/fc/");
		
		String[] paramsUrl = path.split("/");
		
		System.out.println("Parâmetros POST: ");
		for(int i = 0; i < paramsUrl.length; i++)
			System.out.println(i + ": " + paramsUrl[i]);
		System.out.println(":FIM:");
		
		switch(paramsUrl[0]) {
		case "usuarios":
			UsuariosController controller = new UsuariosController(request, response);
			
			if(paramsUrl[1].equals("create")) {
				
				HashMap<String, String> formData = new HashMap<String, String>();
				
				Enumeration<String> param = request.getParameterNames();
				
				while(param.hasMoreElements()) {
					String element = param.nextElement();
					formData.put(element, request.getParameter(element));
				}
				
				controller.create(formData);
			}
			//TODO: Adicionar tratamento sobre caminho não encontrado
			
			break;
		default: 
			//Responder com um 404;
			break;
		}
		
		response.getWriter().println(path);
	}
	
	
}