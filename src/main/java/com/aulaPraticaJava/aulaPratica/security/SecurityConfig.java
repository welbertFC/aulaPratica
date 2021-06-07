package com.aulaPraticaJava.aulaPratica.security;


import com.aulaPraticaJava.aulaPratica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    private final UserService usuarioService;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(UserService usuarioService, JwtAuthenticationEntryPoint authenticationEntryPoint) {
        this.usuarioService = usuarioService;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }


    public static final String[] PUBLIC_MATCHERS = {"/h2-console/**"};

    public static final String[] PUBLIC_MATCHERS_GET = {"/game/**"};

    public static final String[] PUBLIC_MATCHERS_POST = {"/cliente/**", "/auth/**"};


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        if (Arrays.asList(environment.getActiveProfiles()).contains("test")) {
            httpSecurity.headers().frameOptions().disable();
        }

        httpSecurity.cors().and().csrf().disable();
        httpSecurity
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS)
                .permitAll()
                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET)
                .permitAll()
                .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST)
                .permitAll()
                .anyRequest()
                .authenticated();
        httpSecurity.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence password) {
                return password.toString();
            }

            @Override
            public boolean matches(CharSequence password, String encodedPassword) {
                return password.toString().equals(encodedPassword);
            }
        };
    }

}
