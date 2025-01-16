package in.codingvk.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private int id;
   @Column
   private String username;
   @Column
   private String password;
   @Column
   private String role; //ADMIN,USER
     
   
public String getUsername() 
{
	return username;
}
public void setUsername(String username) 
{
	this.username = username;
}
public String getPassword() 
{
	return password;
}
public void setPassword(String password)
{
	this.password = password;
}
public String getRole() 
{
	return role;
}
public void setRole(String role) 
{
	this.role = role;
}

   
}
