/*
 *  copyright (c) thelook.cn
 */
package demo.spldap1;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 *
 * @author 老唐
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .contextSource().url("ldap://111.230.67.81:30389")
                .root("dc=thelook,dc=cn")
                .managerDn("cn=admin,dc=thelook,dc=cn")                
                .managerPassword("thelook2018")                
                .and()
                .userDnPatterns("cn={0},ou=engineering,dc=thelook,dc=cn")
                //.groupSearchBase("ou=groups,dc=thelook,dc=cn").groupSearchFilter("(memberuid={0})")
                .groupSearchBase("ou=groups,dc=thelook,dc=cn").groupSearchFilter("(uniquemember={0})")
                .passwordCompare().passwordEncoder(NoOpPasswordEncoder.getInstance()).passwordAttribute("userpassword");

    }
//    
}
