package webdemo.controllers;

import java.lang.reflect.Constructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ControllerFactory {

	public static Controller CreateController(
			String controllerName,
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		Controller controller = null;
		
		controllerName = controllerName.substring(0,1).toUpperCase() + 
				controllerName.substring(1);
		
		String className = "webdemo.controllers." + controllerName + "Controller";
		
		try {
			Class<?> c = Class.forName(className);
			Constructor<?> constructor = c.getConstructor(
					HttpServletRequest.class, 
					HttpServletResponse.class);
			controller = (Controller)constructor.newInstance(request, response);
		}catch(Exception ex) {
			System.err.println("Impossível criar o controller");
			ex.printStackTrace();
		}
		
		return controller;
	}
	
}
