package org.jsp.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.AddressDao;
import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.exception.AddressNotFoundException;
import org.jsp.ecommerce.exception.MerchantNotFoundException;
import org.jsp.ecommerce.exception.ProductNotFoundException;
import org.jsp.ecommerce.exception.UserNotFoundException;
import org.jsp.ecommerce.model.Address;
import org.jsp.ecommerce.model.Merchant;
import org.jsp.ecommerce.model.Products;
import org.jsp.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class AddressService {
	@Autowired
	private AddressDao addressdao;
	@Autowired
	private UserDao userdao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address add, int user_id) {
		Optional<User> recUser = userdao.findById(user_id);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			User user = recUser.get();
			user.getAddress().add(add);
			add.setUser(user);
			structure.setBody(addressdao.saveAddress(add));
			structure.setMessage("Address Added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
		}
		throw new UserNotFoundException("cannot add Address as User Id is Invalid");
	}
	
	 public ResponseEntity<ResponseStructure<Address>> updateAddress(Address add ) {
			Optional<Address> recAddress = addressdao.findById(add.getId());
			ResponseStructure<Address> structure = new ResponseStructure<>();
			if (recAddress.isPresent()) {
			Address dbAddress = recAddress.get();
			dbAddress.setLandmark(add.getLandmark());
			dbAddress.setBuildingname(add.getBuildingname());
			dbAddress.setHouseno(add.getHouseno());
			dbAddress.setAddresstype(add.getAddresstype());
			dbAddress.setCity(add.getCity());
			dbAddress.setState(add.getState());
			dbAddress.setCountry(add.getCountry());
			dbAddress.setPincode(add.getPincode());
				
		structure.setMessage("Address Updated");
				structure.setBody(addressdao.saveAddress(add));
				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.ACCEPTED);
			}
			structure.setMessage("Cannot Update Address as Id is Invalid");
			structure.setBody(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.NOT_FOUND);
		}
	public ResponseEntity<ResponseStructure<List<Address>>> findAddressByUserId(int user_id) {
		ResponseStructure<List<Address>> structure = new ResponseStructure<>();
		List<Address> address = addressdao.findByUserId(user_id);
		if (address.isEmpty()) {
			throw new AddressNotFoundException("No Address Found for entered User Id");
		}
		structure.setBody(address);
		structure.setMessage("List of Address for user Id");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Address>>>(structure, HttpStatus.OK);
	}
		
	}


