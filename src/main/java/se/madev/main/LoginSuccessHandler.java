package se.madev.main;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import se.madev.main.model.Role;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String target = determineTarget(authentication);
		
		if(response.isCommitted()) {
			System.out.println("Can't redirect!");
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, target);
	}
	
	protected String determineTarget(Authentication authentication) {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		if(authorities.contains(new SimpleGrantedAuthority(Role.Type.APPLICANT.toString()))) {
			return "/applicant";
        } else {
        	return "/recruiter";
        }
	}
}
