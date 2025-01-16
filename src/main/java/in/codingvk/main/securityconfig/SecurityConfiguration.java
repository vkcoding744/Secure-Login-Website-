package in.codingvk.main.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration
{
	@Autowired
    CustomUserDetails customUserDetails;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception 
    {
      
      return httpSecurity
    		               .csrf(AbstractHttpConfigurer::disable)
    		               .authorizeHttpRequests(registry ->
    		               {
    		            	 registry.requestMatchers("/home").permitAll(); 
    		            	 registry.requestMatchers("/admin/**").hasRole("ADMIN");
    		            	 registry.requestMatchers("/user/**").hasRole("USER");
    		            	 registry.anyRequest().authenticated();
    		               })
    		                .formLogin(form -> form.loginPage("/login").successHandler(new SuccessHandler()).permitAll())
    		                .build();   
    
    }   
       @Bean
      public PasswordEncoder passwordEncoder() 
      {
  	     return new BCryptPasswordEncoder();
      }
    
      @Bean
      public UserDetailsService userDetailsService() 
      {
    	return customUserDetails;
      }
      
      @Bean
      public AuthenticationProvider authenticationProvider()
      {
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	provider.setUserDetailsService(customUserDetails);
    	provider.setPasswordEncoder(passwordEncoder());
    	return provider;
      }
      
      
      /*
      @Bean
      public UserDetailsService userDetailsService() 
      {
     	 UserDetails normalUser = User.builder()
     			 
     			 .username("monu")
     			 .password("$2a$12$O6eEzgWEjxSZIDT3/6i8x.uF6GwN1zvge9RlFR7qIh.EgMU56DEFC")
     			 .roles("USER")
     			 .build();
        
     	 UserDetails admin = User.builder()
     			 
     			 .username("kisan")
     			 .password("$2a$12$Mp81oWmc.sb159qMLTk0Uef8xB28fQ.GtCHEYCBGUHJMPHJfpXrta")
     			 .roles("ADMIN","USER")
     			 .build();
     	  return new InMemoryUserDetailsManager(admin);
      }  
  */ 
      
}   
    