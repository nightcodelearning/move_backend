package com.leinaro.move.move.security;

import com.google.cloud.storage.HttpMethod;
import com.leinaro.move.move.security.token.FirebaseEntryPoint;
import com.leinaro.move.move.security.token.FirebaseFilter;
import com.leinaro.move.move.security.token.FirebaseProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private FirebaseEntryPoint entryPoint;
    @Autowired
    private FirebaseProvider firebaseProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        http.exceptionHandling().authenticationEntryPoint(entryPoint);
        http.addFilterBefore(new FirebaseFilter(), BasicAuthenticationFilter.class);
        http.authenticationProvider(firebaseProvider);
        return http.build();
    }

}
