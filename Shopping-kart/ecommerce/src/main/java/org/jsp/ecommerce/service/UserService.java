package org.jsp.ecommerce.service;


import java.util.Optional;

import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.model.Merchant;
import org.jsp.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	    @Autowired
	    private UserDao userdao;

	    public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
	        ResponseStructure<User> structure = new ResponseStructure<>();
	        structure.setData(userdao.saveUser(user));
	        structure.setMessage("User Saved");
	        structure.setStatusCode(HttpStatus.CREATED.value());
	        return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	    }

	    public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
	        ResponseStructure<User> structure = new ResponseStructure<>();
	        structure.setData(userdao.updateUser(user));
	        structure.setMessage("User updated successfully...");
	        structure.setStatusCode(HttpStatus.ACCEPTED.value());
	        return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	    }
	    public ResponseEntity<ResponseStructure<User>> verifyUser(long phone, String password) {
			Optional<User> recUser = userdao.verifyUser(phone, password);
			ResponseStructure<User> structure = new ResponseStructure<>();
			if (recUser.isPresent()) {
				structure.setMessage("Verification Successful");
				structure.setData(recUser.get());
				structure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
			}
			structure.setMessage("Invalid Phone Number or Password");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		}
	    public ResponseEntity<ResponseStructure<User>> verifyUser(String email, String password) {
			Optional<User> recUser = userdao.verify(email, password);
			ResponseStructure<User> structure = new ResponseStructure<>();
			if (recUser.isPresent()) {
				structure.setMessage("Verification Succesfull");
				structure.setData(recUser.get());
				structure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
			}
			structure.setMessage("Invalid email address or Password");
			structure.setData(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		}


		}

