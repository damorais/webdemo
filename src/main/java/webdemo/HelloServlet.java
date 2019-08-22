package webdemo;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="HelloServlet", urlPatterns = {"hello"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
                         throws IOException, ServletException{

        response.getWriter().println("Ola, Ihuuuu!");
    }
}