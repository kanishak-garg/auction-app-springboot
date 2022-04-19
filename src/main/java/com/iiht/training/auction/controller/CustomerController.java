package com.iiht.training.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private BidsService bidsService;

	@RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerDto customer){
        CustomerDto customer_add = customerService.registerCustomer(customer);
        
        return new ResponseEntity<Object>(customer_add, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customer){
        CustomerDto customer_upd = customerService.updateCustomer(customer);
        
        return new ResponseEntity<Object>(customer_upd, HttpStatus.OK);
    }


    @RequestMapping(value="/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllcustomers(){
        List<CustomerDto> customers = customerService.getAllCustomers();

       return new ResponseEntity<Object>(customers, HttpStatus.OK);
    }
    
    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable long id){

        CustomerDto customer = customerService.getCustomerById(id);

        return new ResponseEntity<Object>(customer, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable long id){

        boolean deleted = customerService.deleteCustomer(id);

        return new ResponseEntity<Object>(deleted, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/place-bid", method = RequestMethod.POST)
    public ResponseEntity<?> placeBid(@RequestBody BidsDto bid){

        BidsDto bidd = bidsService.placeBid(bid);

        return new ResponseEntity<Object>(bidd, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/all-bids-on-product/{productId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBidsOnProduct(@PathVariable long productId){

        List<BidsDto> bids = bidsService.getAllBidsOnProduct(productId);

        return new ResponseEntity<Object>(bids, HttpStatus.OK);
    }

}
