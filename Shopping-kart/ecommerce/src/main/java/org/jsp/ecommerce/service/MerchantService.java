package org.jsp.ecommerce.service;

import java.util.Optional;

import org.jsp.ecommerce.dao.MerchantDao;
import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.exception.MerchantNotFoundException;
import org.jsp.ecommerce.model.Merchant;
import org.jsp.ecommerce.util.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class MerchantService {
    @Autowired
    private MerchantDao merchantDao;
    @Autowired
    private ECommerceAppEmailService ecommerceappemailsender;

    public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant, HttpServletRequest request) {
        ResponseStructure<Merchant> structure = new ResponseStructure<>();
        merchant.setStatus(AccountStatus.IN_ACTIVE.toString());
        merchant.setToken(RandomString.make(45));
        structure.setBody(merchantDao.saveMerchant(merchant));
        String message= ecommerceappemailsender.sendWelcomeMail(merchant, request);
        structure.setMessage("Merchant Saved");
        structure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);
    }
    public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		Optional<Merchant> recMerchant = merchantDao.findById(merchant.getId());
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
		Merchant dbMerchant = recMerchant.get();
		 dbMerchant.setEmail(merchant.getEmail());
		 dbMerchant.setName(merchant.getName());
		 dbMerchant.setPhone(merchant.getPhone());
		 dbMerchant.setGst_number(merchant.getGst_number());
		 dbMerchant.setPassword(merchant.getPassword());
			
			structure.setMessage("Merchant Updated");
			structure.setBody(merchantDao.saveMerchant(merchant));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setMessage("Cannot Update Merchant as Id is Invalid");
		structure.setBody(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

    
    
    public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(long phone, String password) {
		Optional<Merchant> recMerchant = merchantDao.verify(phone, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Verification Succesfull");
			structure.setBody(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setMessage("Invalid Phone Number or Password");
		structure.setBody(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(String email, String password) {
		Optional<Merchant> recMerchant = merchantDao.verify(email, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			Merchant m=recMerchant.get();
			if(m.getStatus().equals(AccountStatus.IN_ACTIVE.toString())) {
				throw new IllegalStateException("Account is Not Activated");
			}
			structure.setMessage("Verification Succesfull");
			structure.setBody(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setMessage("Invalid email address or Password");
		structure.setBody(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructure<String>> activate(String token){
		Optional<Merchant> recMerchant=merchantDao.findByToken(token);
		ResponseStructure<String> structure =new ResponseStructure<>();
		if(recMerchant.isPresent()) { 
			Merchant merchant = recMerchant.get();
			merchant.setStatus(AccountStatus.ACTIVE.toString());
			merchant.setToken(null);
             merchantDao.saveMerchant(merchant);
             structure.setBody("Merchant Found");
             structure.setMessage("Account Verified");
             structure.setStatusCode(HttpStatus.ACCEPTED.value());
             return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.ACCEPTED);
			
	}
		throw new MerchantNotFoundException("INVALID URL");
}
}
