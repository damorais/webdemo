package webdemo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

@WebFilter("/*")
public class FrontControllerRequestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String path = ((HttpServletRequest)request).getRequestURI();
		
		System.out.println("Requisição: ");
		System.out.println("---" + path + "----");
		System.out.println("FIM");
		
		String[] defaultStaticPaths = new String[] { "/static", "/WEB-INF" };
		String[] defaultStaticExtensions = new String[] { ".html", ".jsp" };
		
		if(StringUtils.startsWithAny(path, defaultStaticPaths) || StringUtils.endsWithAny(path, defaultStaticExtensions)) {
			chain.doFilter(request, response);
		}else {
			((HttpServletRequest)request).getRequestDispatcher("/fc/" + path).forward(request, response); //.sendRedirect("/fc/" + path);
		}	
	}
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}


}
