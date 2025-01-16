package in.codingvk.main.securityconfig;

import java.io.IOException;
import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
 {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
    		    Authentication authentication) throws ServletException, IOException 
         {
    	    	
    	 Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    	    // Check for a specific role
        boolean isAdmin = authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
        boolean isUser = authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_USER"));

        if (isAdmin) 
        {
            // Redirect or perform admin-specific actions
            response.sendRedirect("/admin/adminProfile");
        } 
        else if (isUser) 
        {
            // Redirect or perform user-specific actions
            response.sendRedirect("/user/userProfile");
        } 
        else 
        {
            // Default action
            response.sendRedirect("/login?error=unauthorized");
        }
    }
    	
    }

