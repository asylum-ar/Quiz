package org.sid.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader(SecurityConstants.HEADER_STRING);

        String jwtToken = jwt.substring(SecurityConstants.TOKEN_PERFIX.length());
        JWTVerifier Verifier = JWT.require(Algorithm.HMAC256(SecurityConstants.SECRET)).build();


        try {
            Verifier.verify(jwtToken);
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
        	response.addHeader("token", exception.getMessage());
             
             filterChain.doFilter(request,response );
            System.out.println(exception.getMessage());
           
            return;
        }



            System.out.println("Token=" + jwt);
            if (jwt == null || !jwt.startsWith(SecurityConstants.TOKEN_PERFIX)) {
                filterChain.doFilter(request, response);
                return;
            }else
            {
            	 DecodedJWT decodedjwt = JWT.decode(jwtToken);
                 String username = decodedjwt.getSubject();
                 List<String> roles = decodedjwt.getClaims().get("roles").asList(String.class);
                 System.out.println("username=" + username);
                 System.out.println("roles=" + roles);

                 Collection<GrantedAuthority> authorities = new ArrayList<>();
                 for (String r : roles) {
                     authorities.add(new SimpleGrantedAuthority(r));
                 }
                 UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username, null, authorities);
                 SecurityContextHolder.getContext().setAuthentication(user);
                 filterChain.doFilter(request, response);
            }

            System.out.println(Verifier.verify(jwtToken));
            
           


    }
}
