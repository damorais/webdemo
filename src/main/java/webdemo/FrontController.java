package webdemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import webdemo.controllers.Controller;
import webdemo.controllers.ControllerFactory;
import webdemo.controllers.UsuariosController;
import webdemo.entidades.Usuario;

import static org.apache.commons.lang3.RegExUtils.removeFirst;

@WebServlet("/usuarios/*")
public class FrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4953354434731847700L;

	//usuarios -> List
	//usuarios/list -> List
	//usuarios/create -> Create
	//usuarios (POST) -> Create(FormData)
	//usuarios/edit/1 -> Edit
	//usuarios/edit/1 (POST) -> Edit (Id,FormData)
	
	@Override	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws IOException, ServletException {

		
		String[] urlParams = removeFirst(request.getRequestURI(), "/").split("/");
		
		//posição 0: Controller
		//posição 1: Action
		//posição 2: ID
		for(String param : urlParams)
			response.getOutputStream().println("-" + param);
		
		String controlador = urlParams[0];
		String acaoParam = urlParams.length > 1 ? urlParams[1] : "";
		String idParam = urlParams.length > 2 ? urlParams[2] : "";
		
		//UsuariosController controller = new UsuariosController(request, response);
		Controller controller = ControllerFactory.CreateController(controlador, request, response);
		//new UsuariosController(request, response);
		
		switch(acaoParam) {
		case "":
		case "list":
			controller.list();
			break;
		case "create":
			controller.create();
			break;
		case "edit":
			if(!Strings.isNullOrEmpty(idParam)) {
				int id = Integer.parseInt(idParam);
				controller.edit(id);
			}
			break;
		default:
			//TODO: 404, baby!
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String[] urlParams = removeFirst(request.getRequestURI(), "/").split("/");
		
		//posição 0: Controller
		//posição 1: Action
		//posição 2: ID
		
		String controlador = urlParams[0];
		String acaoParam = urlParams.length > 1 ? urlParams[1] : "";
		String idParam = urlParams.length > 2 ? urlParams[2] : "";
		
		Controller controller = ControllerFactory.CreateController(controlador, request, response);
		
		HashMap<String, String> formData = new HashMap<String, String>();
		
		Enumeration<String> param = request.getParameterNames();
		
		while(param.hasMoreElements()) {
			String element = param.nextElement();
			formData.put(element, request.getParameter(element));
		}
		
		switch(acaoParam) {
		case "":	
			controller.create(formData);
			break;
		case "edit":
			if(!Strings.isNullOrEmpty(idParam)) {
				int id = Integer.parseInt(idParam);
				controller.edit(id, formData);
			}
			break;
		default:
			//TODO: 404, baby!
			break;
		}
		
	}

}