package com.questk2.entity;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * A filter that logs incoming HTTP requests.
 */
@Component
public class LoginFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    /**
     * Filters incoming HTTP requests and logs their URI before passing the request 
     * along the filter chain.
     * 
     * @param request  The incoming servlet request.
     * @param response The outgoing servlet response.
     * @param chain    The filter chain to pass the request and response to the next filter.
     * @throws IOException      If an I/O error occurs during request processing.
     * @throws ServletException If the request cannot be processed.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        logger.info("Incoming Request URI: {}", httpRequest.getRequestURI());
        chain.doFilter(request, response);
    }

}
