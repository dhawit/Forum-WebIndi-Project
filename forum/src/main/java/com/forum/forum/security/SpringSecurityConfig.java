package com.forum.forum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration ;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.forum.forum.services.impl.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig{
    
    private final CustomUserDetailService customUserDetailService;

    public SpringSecurityConfig(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                    .authorizeHttpRequests()
                    .requestMatchers("/login").permitAll()
                    .requestMatchers("/registerPage").permitAll()
                    .requestMatchers("/resetPassword").permitAll()
                    .requestMatchers("/reset").permitAll()
                    .requestMatchers("/register").permitAll()
                    .requestMatchers("/css/**").permitAll()
                    .requestMatchers("/images/**").permitAll()
                    .anyRequest().authenticated()
                    //.and()
                    //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().formLogin().loginPage("/login").defaultSuccessUrl("/home",true)
                    .usernameParameter("email")
                    .permitAll()
                    .and()
                    .httpBasic();
        return (httpSecurity.build());
    }
}
