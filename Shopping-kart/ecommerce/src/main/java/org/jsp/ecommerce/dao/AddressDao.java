package org.jsp.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.model.Address;
import org.jsp.ecommerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository addressrepository;

	 public Address saveAddress(Address add) {
	        return addressrepository.save(add);
	    }
	 public Address updateAddress(Address add) {
	        return addressrepository.save(add);
	    }
	public Optional<Address> findById(int id) {
	
		return addressrepository.findById(id);
	}
	public List<Address> findByUserId(int user_id) {
		
		return addressrepository.findByUserId(user_id);
	}











}
