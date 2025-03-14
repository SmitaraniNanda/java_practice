package com.questk2.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;

@Order(0)
public class RequestLoggingFilter implements Filter {

  
    public void init(FilterConfig filterConfig) throws ServletException {}

    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Request received from: " + request.getRemoteAddr());
        //logic
        chain.doFilter(request, response);
    }

  
    public void destroy() {}
}

