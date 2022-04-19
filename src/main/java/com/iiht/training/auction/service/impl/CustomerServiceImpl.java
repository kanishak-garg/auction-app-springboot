package com.iiht.training.auction.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.repository.CustomerRepository;
import com.iiht.training.auction.service.CustomerService;
import com.iiht.training.auction.entity.CustomerEntity;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

    public CustomerEntity dtoToEntity(CustomerDto customerDto){
        CustomerEntity customer = new CustomerEntity();
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setUsername(customerDto.getUsername());
        return customer;
    }

    public CustomerDto EntityToDto(CustomerEntity customerEntity){ 
        CustomerDto customerdto=new CustomerDto();
        customerdto.setId(customerEntity.getId());
        customerdto.setAddress(customerEntity.getAddress());
        customerdto.setEmail(customerEntity.getEmail());
        customerdto.setPassword(customerEntity.getPassword());
        customerdto.setPhoneNumber(customerEntity.getPhoneNumber());
        customerdto.setUsername(customerEntity.getUsername());
        return customerdto;
    }
	@Override
	public CustomerDto registerCustomer(CustomerDto customerDto) {
        
        // convert dto to entity
        CustomerEntity customerEnt = dtoToEntity(customerDto);
        CustomerEntity savedCustomer=customerRepository.save(customerEnt);
       
        // convert CustomerEntity to CustomerDto
        CustomerDto customerdto=EntityToDto(savedCustomer);
        
        return customerdto;
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
        // if(!customerRepository.existsById(customerDto.getId())){
        //     throw new IllegalStateException("customer id is not present");
        // }
        // else{ 
        //     // customerRepository.updateById()
        //     return null;
        // }
		return null;
	}

	@Override
	public Boolean deleteCustomer(Long id) {
        if(!customerRepository.existsById(id)){
            return false;
        }
        else{
            customerRepository.deleteById(id);
            return true;
        }
        // return false;
		
	}

	@Override
	public CustomerDto getCustomerById(Long id) {
 
       Optional<CustomerEntity> custById = customerRepository.findById(id);
       if(!custById.isPresent()){
           System.out.println("Need to handle the exception");
           return null;
       }
       else{
            return EntityToDto(custById.get());
       }
		
	}


	@Override
	public List<CustomerDto> getAllCustomers() {
        List<CustomerEntity> allCustomersAsEntlist = customerRepository.findAll();
        List<CustomerDto> listAsDto=new ArrayList<>();
        for (CustomerEntity custEnt : allCustomersAsEntlist ) {
            CustomerDto item=EntityToDto(custEnt);
            listAsDto.add(item);
        }
        System.out.println(listAsDto);
		return listAsDto;
        
	}

}