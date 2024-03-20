package org.jsp.ecommerce.controller;

import java.util.List;

import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.model.Address;
import org.jsp.ecommerce.model.Products;
import org.jsp.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addservice;

	@PostMapping("/{user_id}")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address add, @PathVariable int user_id) {
		return addservice.saveAddress(add, user_id);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address add) {
		return addservice.updateAddress(add);

	}
	@GetMapping("/{user_id}")
	public ResponseEntity<ResponseStructure<List<Address>>> findByUserId(@PathVariable int user_id) {
		return addservice.findAddressByUserId(user_id);
	}
}
