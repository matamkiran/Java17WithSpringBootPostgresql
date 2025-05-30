package com.application.ecommerce.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.application.ecommerce.service.JWTService;
import com.application.ecommerce.service.MyAdminDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JWTService jwtService;
	
	@Autowired
	ApplicationContext context;
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
	    String path = request.getRequestURI();
	    System.out.println("Request URI: " + path);
	    return path.startsWith("/swagger-ui/") ||
	           path.equals("/swagger-ui.html") ||
	           path.startsWith("/v3/api-docs/") ||
	           path.startsWith("/webjars/") ||
	           path.startsWith("/api");
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		String authHeader=request.getHeader("Authorization");
		String token=null;
		String username=null;
		
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			token=authHeader.substring(7);
			username=jwtService.extractUserName(token);	
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails adminDetails=context.getBean(MyAdminDetailsService.class).loadUserByUsername(username);
			
			if(jwtService.validateToken(token, adminDetails)) {
				UsernamePasswordAuthenticationToken authToken=
						new UsernamePasswordAuthenticationToken(adminDetails, null,adminDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}
	
	
	}
	

