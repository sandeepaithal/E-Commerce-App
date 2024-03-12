package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.model.Merchant;
import org.jsp.ecommerce.service.MerchantService;
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
@RequestMapping("/merchants")
@CrossOrigin
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant,HttpServletRequest request) {	
        return merchantService.saveMerchant(merchant, request);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
        return merchantService.updateMerchant(merchant);
    }
   @PostMapping("/verify")
    public  ResponseEntity<ResponseStructure<Merchant>> VerifyMerchant(@RequestParam long phone,String password){
    	return merchantService.verifyMerchant(phone, password);
    }
   @PostMapping("/verifyemail")
   public  ResponseEntity<ResponseStructure<Merchant>> VerifyMerchant(@RequestParam  String email,String password){
   	return merchantService.verifyMerchant(email, password);
   }
   @GetMapping("/activate")
   public  ResponseEntity<ResponseStructure<String>> activate(@RequestParam  String token){
	   	return merchantService.activate(token);
	   }
}
