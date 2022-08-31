package com.leinaro.move.move.security.token;


import com.leinaro.move.move.security.model.TokenModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirebaseFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try{
            String token = getToken(request);
            if(token != null){
                SecurityContextHolder.getContext().setAuthentication(new TokenModel(token));
            }
        }catch(Exception e){

            logger.error("Fail in doFilter :" , e.getMessage());

        }

        filterChain.doFilter(request,response);


    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer ")){
            return header.replace("Bearer ","");
        }
        return null;
    }
}
