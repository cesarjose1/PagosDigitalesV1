package com.baz.utils.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestCountFilter implements Filter {

    private int requestCount;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        requestCount = 0;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        requestCount++;
        System.out.println("Numero de request realizados en la app (Mediante Filros HTTP): " + requestCount + ", enppoint de la ultima peticion: " + requestURI);
        chain.doFilter(request, response);
    }

}
