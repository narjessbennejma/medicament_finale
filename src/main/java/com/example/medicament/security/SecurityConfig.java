package com.example.medicament.security;


	import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// @Override
	 /*protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
	auth.inMemoryAuthentication().withUser("narjess").password("{noop}123").roles("AGENT","USER");
	auth.inMemoryAuthentication().withUser("user1").password("{noop}123").roles("USER");

}
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests().antMatchers("/showCreate").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/saveProduit").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/ListeProduits")
	 .hasAnyRole("ADMIN","AGENT","USER");

	 http.authorizeRequests()
	 .antMatchers("/supprimerProduit","/modifierProduit","/updateProduit")
	 .hasAnyRole("ADMIN");
	 http.exceptionHandling().accessDeniedPage("/accessDenied");
	 http.authorizeRequests().anyRequest().authenticated();
	 http.formLogin();
	 }*/
	
	 @Autowired
	 private DataSource dataSource;
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		
	 http.authorizeRequests().antMatchers("/showCreate","/showCreatecategorie").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/saveProduit","/saveCategorie").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/ListeProduits","/ListeCategorie").hasAnyRole("ADMIN","AGENT","USER");

	 http.authorizeRequests().antMatchers("/supprimerProduit","/modifierProduit","/updateProduit","/updateCategorie","/modifierCategorie","/supprimerCategories").hasAnyRole("ADMIN");
	 http.authorizeRequests().antMatchers("/login").permitAll();
	
	
	 http.formLogin().loginPage("/login");
	//pour faire fonctionner Bootstrap
	 http.authorizeRequests().antMatchers("/webjars/**").permitAll();
	 http.authorizeRequests().anyRequest().authenticated();
	 http.exceptionHandling().accessDeniedPage("/accessDenied");
	 }
	 
	
	 @Bean
	 public PasswordEncoder passwordEncoder () {
	 return new BCryptPasswordEncoder();
	 }
	 @Autowired
	 UserDetailsService userDetailsService;
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) 
	 throws Exception {
	 PasswordEncoder passwordEncoder = passwordEncoder ();
	 auth.userDetailsService(userDetailsService)
	 .passwordEncoder(passwordEncoder);
	 }
	 
	 
	}

