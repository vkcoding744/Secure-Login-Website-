package in.codingvk.main.securityconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import in.codingvk.main.model.User;
import in.codingvk.main.repository.UserRepository;

@Service
public class CustomUserDetails implements UserDetailsService 
{
	
	@Autowired
    UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
	
		Optional<User> validUser= userRepository.findByUsername(username);
		if(validUser.isPresent()) 
		{	
			var useObj = validUser.get();
			
		  	return   org.springframework.security.core.userdetails.User.builder()  			 
	    			 .username(useObj.getUsername())
	    			 .password(useObj.getPassword())
	    			 .roles(useObj.getRole())
	    			 .build();
		}
		else 
		{
		   throw new UsernameNotFoundException(username);	
		}
		
	}

	/*    private String[] MatchRoles(User user) 
	    {
	       if(user.getRole()==null) 
	      {
		   return new String[]{"USER"};
	      }
		  return user.getRole().split(",") ;
	   }
    */
   }
