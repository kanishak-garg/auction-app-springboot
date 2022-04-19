package com.iiht.training.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;


    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto product){
       ProductDto product_add = productService.saveProduct(product);
        
        return new ResponseEntity<Object>(product_add, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto product){
        ProductDto product_upd = productService.updateProduct(product);
        
        return new ResponseEntity<Object>(product_upd, HttpStatus.OK);
    }


    @RequestMapping(value="/get/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllcustomers(){
        List<ProductDto> products = productService.getAllProducts();

       return new ResponseEntity<Object>(products, HttpStatus.OK);
    }
    
    @RequestMapping(value="/get/{productId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable long productId){

        ProductDto product = productService.getProductById(productId);

        return new ResponseEntity<Object>(product, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable long productId){

        boolean deleted = productService.deleteProduct(productId);

        return new ResponseEntity<Object>(deleted, HttpStatus.OK);
    }
    
    @RequestMapping(value="/by-seller/{sellerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductsBySeller(@PathVariable long sellerId){

        List<ProductDto> products = productService.getProductsBySeller(sellerId);

        return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
    }

    @RequestMapping(value="/get/by-category/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable String categoryId){

        List<ProductDto> products = productService.getProductsByCategory(categoryId);

       return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
    }

	
}
