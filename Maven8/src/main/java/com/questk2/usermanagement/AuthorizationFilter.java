package com.questk2.usermanagement;

import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Component;
 
@Component
@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println("Request URI : "+httpRequest.getRequestURI());
		chain.doFilter(request, response);
	}
 
}
 