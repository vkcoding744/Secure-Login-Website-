package in.codingvk.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootSecurityApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootSecurityApplication.class, args);
		System.out.println("SpringBoot Security");
	}

}
