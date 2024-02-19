package com.sd.springboot.springmvcsecurity.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
public class demoSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails sourav= User.builder()
//                .username("sourav")
//                .password("{noop}@Sourav03")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails saikat= User.builder()
//                .username("saikat")
//                .password("{noop}@Sourav03")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails partha= User.builder()
//                .username("partha")
//                .password("{noop}@Sourav03")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//
//       return  new InMemoryUserDetailsManager(sourav,saikat,partha);
//
//    }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/OrdersInfo/**").hasRole("MANAGER")
                                .requestMatchers("/SystematicPerformation/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form->
                        form
                                .loginPage("/loginPage")
                                .loginProcessingUrl("/authenticateUser")
                                .permitAll()

                )
                .logout(logout->logout.permitAll());
        return http.build();
    }
}