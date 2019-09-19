package webdemo.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.NotImplementedException;

public class Controller {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public HttpServletRequest getRequest() { return request; }
	public HttpServletResponse getResponse() { return response; }
	
	public Controller(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public void list() throws ServletException, IOException { 
		throw new NotImplementedException("Ação não implementada"); 
	}
	
	public void show(int id) throws ServletException, IOException { 
		throw new NotImplementedException("Ação não implementada"); 
	}
	
	public void create() throws ServletException, IOException { 
		throw new NotImplementedException("Ação não implementada"); 
	}
	
	public void create(Map<String, String> formData) throws ServletException, IOException  { 
		throw new NotImplementedException("Ação não implementada"); 
	}
	
	public void edit(int id) throws ServletException, IOException{ 
		throw new NotImplementedException("Ação não implementada"); 
	}
	
	public void edit(int id, Map<String, String> formData) throws ServletException, IOException  { 
		throw new NotImplementedException("Ação não implementada"); 
	}
	
	public void delete(int id) throws ServletException, IOException { 
		throw new NotImplementedException("Ação não implementada"); 
	}
}