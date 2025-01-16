package in.codingvk.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codingvk.main.model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	   Optional<User> findByUsername(String username); 
    
}
