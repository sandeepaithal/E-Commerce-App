package org.jsp.ecommerce.service;


import java.util.Optional;

import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.exception.UserNotFoundException;
import org.jsp.ecommerce.model.User;
import org.jsp.ecommerce.util.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class UserService {

	    @Autowired
	    private UserDao userdao;
	    @Autowired
	    private ECommerceAppEmailService ecommerceappemailsender;

	    public ResponseEntity<ResponseStructure<User>> saveUser(User user, HttpServletRequest request) {
	        ResponseStructure<User> structure = new ResponseStructure<>();
	        user .setStatus(AccountStatus.IN_ACTIVE.toString());
	        user.setToken(RandomString.make(45));
	        structure.setBody(userdao.saveUser(user));
	        String message= ecommerceappemailsender.sendWelcomeMail(user, request);
	        structure.setMessage("Merchant Saved");
	        structure.setStatusCode(HttpStatus.CREATED.value());
	        return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	    }

	    public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			Optional<User> recUser = userdao.findById(user.getId());
			if (recUser.isPresent()) {
				User dbUser = recUser.get();
				dbUser.setAge(user.getAge());
				dbUser.setGender(user.getGender());
				dbUser.setEmail(user.getEmail());
				dbUser.setPhone(user.getPhone());
				dbUser.setPassword(user.getPassword());
				dbUser.setName(user.getName());
				structure.setBody(userdao.saveUser(dbUser));
				structure.setMessage("user updated");
				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
			}
			throw new UserNotFoundException("Invalid User Id");
		}
	    public ResponseEntity<ResponseStructure<User>> verifyUser(long phone, String password) {
			Optional<User> recUser = userdao.verifyUser(phone, password);
			ResponseStructure<User> structure = new ResponseStructure<>();
			if (recUser.isPresent()) {
				structure.setMessage("Verification Successful");
				structure.setBody(recUser.get());
				structure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
			}
			structure.setMessage("Invalid Phone Number or Password");
			structure.setBody(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		}
	    public ResponseEntity<ResponseStructure<User>> verifyUser(String email, String password) {
			Optional<User> recUser = userdao.verify(email, password);
			ResponseStructure<User> structure = new ResponseStructure<>();
			if (recUser.isPresent()) {
				structure.setMessage("Verification Succesfull");
				structure.setBody(recUser.get());
				structure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
			}
			structure.setMessage("Invalid email address or Password");
			structure.setBody(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		}
	   
		

		public ResponseEntity<ResponseStructure<String>> activate(String token) {
			Optional<User> recUser=userdao.findByToken(token);
			ResponseStructure<String> structure =new ResponseStructure<>();
			if(recUser.isPresent()) { 
				User user = recUser.get();
				user.setStatus(AccountStatus.ACTIVE.toString());
				user.setToken(null);
	             userdao.saveUser(user);
	             structure.setBody("User Found");
	             structure.setMessage("Account Verified");
	             structure.setStatusCode(HttpStatus.ACCEPTED.value());
	             return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.ACCEPTED);
				
		}
			throw new UserNotFoundException("INVALID URL");

		}
		
}
		

