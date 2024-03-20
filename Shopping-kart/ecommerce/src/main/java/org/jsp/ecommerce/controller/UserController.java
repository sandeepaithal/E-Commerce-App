package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.model.Merchant;
import org.jsp.ecommerce.model.User;
import org.jsp.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
@RestController
@CrossOrigin
@RequestMapping("/User")
public class UserController {
	    @Autowired
	    private UserService userservice;

	    @PostMapping
	    public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user,HttpServletRequest request) {
	        return userservice.saveUser(user, request);
	    }

	    @PutMapping
	    public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
	        return userservice.updateUser(user);
	}
	    @PostMapping("/verify")
	    public  ResponseEntity<ResponseStructure<User>> VerifyUser(@RequestParam long phone,String password){
	    	return userservice.verifyUser(phone, password);
	    }
	   @PostMapping("/verifyemail")
	   public  ResponseEntity<ResponseStructure<User>> VerifyUser(@RequestParam  String email,String password){
	   	return userservice.verifyUser(email, password);
	}
	   @GetMapping("/activate")
	   public  ResponseEntity<ResponseStructure<String>> activate(@RequestParam  String token){
		   	return userservice.activate(token);
		   }
}
