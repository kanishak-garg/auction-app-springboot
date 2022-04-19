package com.iiht.training.auction.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.SellerService;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@Autowired
    private BidsService bidsService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> addSeller(@RequestBody SellerDto seller){
        SellerDto seller_add = sellerService.registerSeller(seller);
        
        return new ResponseEntity<Object>(seller_add, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSeller(@RequestBody SellerDto seller){
        SellerDto seller_upd = sellerService.updateSeller(seller);
        
        return new ResponseEntity<Object>(seller_upd, HttpStatus.OK);
    }


    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllSellers(){
        List<SellerDto> sellers = sellerService.getAllSellers();

        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/get/{sellerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getSellerById(@PathVariable long sellerId){

        SellerDto seller = sellerService.getSellerById(sellerId);

        return new ResponseEntity<Object>(seller, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{sellerId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSeller(@PathVariable long sellerId){

        boolean deleted = sellerService.deleteSeller(sellerId);

        return new ResponseEntity<Object>(deleted, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/get/bids-on-product/{produtId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBidsOnProduct(@PathVariable long produtId){

        List<BidsDto> products= bidsService.getAllBidsOnProduct(produtId);

        return new ResponseEntity<Object>(products, HttpStatus.OK);
    }

	
}