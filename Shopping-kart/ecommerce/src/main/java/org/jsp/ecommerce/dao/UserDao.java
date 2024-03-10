package org.jsp.ecommerce.dao;


import java.util.Optional;

import org.jsp.ecommerce.model.User;

import org.jsp.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	  @Autowired
	    private UserRepository userRepository;
	  

	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }
	    public User updateUser(User user){
	        return userRepository.save(user);
	    }
	    public Optional<User> verifyUser(long phone, String password) {
	    	return userRepository.verifyUser(phone, password);
	    }
		public Optional<User> verify(String email, String password) {
			return userRepository.verifyUser(email, password);
			
		}
	    
}
