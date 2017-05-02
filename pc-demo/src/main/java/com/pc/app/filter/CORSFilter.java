package com.pc.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {
	
	
	//private String[] cors_origins={"http://127.0.0.1:1337,http://c9t22733.itcs.hpecorp.net"};
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;

	    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "POST,HEAD, GET, OPTIONS, DELETE, PUT");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, X-Requested-With, remember-me,Authorization");
	  //  response.setHeader("Access-Control-Expose-Headers", "PF_AUTH_UID,OLO_AUTH_ROLE,OLO_UID");
	    //response.setHeader("WWW-Authenticate", "FormBased");
	    
	    if (!"OPTIONS".equalsIgnoreCase(request.getMethod())) {
	        chain.doFilter(req, res);
	      } 
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}
