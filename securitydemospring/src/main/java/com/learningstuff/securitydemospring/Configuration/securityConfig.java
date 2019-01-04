package com.learningstuff.securitydemospring.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {

    private String user = "USER";
    private String admin = "ADMIN";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // this for responseBody
                /*.antMatchers("/admin/**").hasRole(admin)
                .antMatchers("/user/**").hasRole(user)*/
                .antMatchers("/check/**").permitAll()
                .antMatchers("/check/home/**").hasAnyRole(user, admin)
                .antMatchers("/user/userPage/**").hasAnyRole(user, admin)
                .antMatchers("/user/adminPage/**").hasAnyRole(admin)
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/check/userLogin")
                .loginProcessingUrl("/loginAction")
                .usernameParameter("loginUserName")
                .passwordParameter("loginUserPassword")
                .defaultSuccessUrl("/check/home")
                .and()
                .logout()
                .logoutUrl("/logoutAction")
                .logoutSuccessUrl("/check/home")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/check/404error");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("shamim").password("123").roles( admin, user)
                .and()
                .withUser("kamrul").password("123").roles(user);
    }
}
