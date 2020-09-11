package org.sid.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bcr;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * auth.inMemoryAuthentication() .withUser("admin").password("1234")
		 * .roles("ADMIN","USER") .and()
		 * .withUser("user").password("1234").roles("USER");
		 */
		auth.userDetailsService(userDetailsService).passwordEncoder(bcr);

	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// http.formLogin();
//	http.authorizeRequests().antMatchers("/ProjetQuiz/**","/index.html/**").permitAll().anyRequest().authenticated();
//        .and()
//        .formLogin()
//        .loginPage("/index.html");
		// http.authorizeRequests().antMatchers("/appUsers/**","/appRoles/**","/Articles/**","/api/delete/{id}","/savearticle/**","/component/article/**","/api/ldap/{id}").hasAuthority("ADMIN");

		http.cors().and().authorizeRequests().anyRequest().authenticated().and()
				.addFilterBefore(getCrosFilter(), ChannelProcessingFilter.class).addFilter(getJWTAuthenticationFilter())
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));

	}


	@Bean
	public IntranetCorsFilter getCrosFilter() {
		return new IntranetCorsFilter();
	}

	@Bean
	public JWTAuthenticationFilter getJWTAuthenticationFilter() throws Exception {
		JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager());
		return filter;
	}

	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
		web.ignoring().antMatchers("/index.html/**", "/static/**", "/MaterialIcons**", "/assets/**",
				 "/assets/images/**",
				"/*js/**", "/*css/**", "/*scss/**", "/resources/**", "/component/**","/**"); // #3
	}
	@Bean
	BCryptPasswordEncoder getBC() {
		return new BCryptPasswordEncoder();
	}
}
