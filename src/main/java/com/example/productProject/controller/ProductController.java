package com.example.productProject.controller;

import com.example.productProject.model.request.ProductRequest;
import com.example.productProject.model.response.CustomResponse;
import com.example.productProject.model.response.EntityResponse;
import com.example.productProject.serviceImpl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

@Autowired
    private IProductService iProductService;

@PostMapping("/saveOrUpdated")
    public ResponseEntity<?>saveOrUpdatedProduct(@RequestBody ProductRequest productRequest){
    try {
        return new ResponseEntity(iProductService.saveOrUpdatedProduct(productRequest), HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity(e.getMessage(),HttpStatus.OK);
    }
}

@GetMapping("/getById")
    public ResponseEntity<?>getByIdProduct(@RequestParam Long productId){
    try {
        return new ResponseEntity(new EntityResponse(iProductService.getByIdProduct(productId),0), HttpStatus.OK);
    }catch (Exception e ){
        return new ResponseEntity(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
    }

}
@GetMapping("/getAll")
    public ResponseEntity<?>getAllProduct(){
    try {
        return new ResponseEntity(iProductService.getAllProduct(), HttpStatus.OK);
    }catch (Exception e ){
        return new ResponseEntity(e.getMessage(),HttpStatus.OK);
    }

}
@DeleteMapping("/softDelete")
    public ResponseEntity<?>softDeleteProduct(@RequestParam Long productId){
    try {
        return new ResponseEntity(new EntityResponse(iProductService.softDeleteProduct(productId),0), HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
    }
}
@GetMapping("/getAllData")
    public ResponseEntity<?>getAllDtaProduct(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                             @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize){
    try{
    Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0),Optional.ofNullable(pageSize).orElse(10));
    return new ResponseEntity(new EntityResponse(iProductService.getAllDataProduct(pageable),0),HttpStatus.OK);
    }catch (Exception e ){
        return new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
    }
}
@PutMapping("/changeStatus")
    public ResponseEntity<?> changeStatusProduct(@RequestParam Long productId){
    try {
        return new ResponseEntity(iProductService.changeStatusProduct(productId), HttpStatus.OK);
    }catch (Exception e ){
        return new ResponseEntity(e.getMessage(),HttpStatus.OK);
    }
}
@GetMapping("/searchData")
    public ResponseEntity<?>searchDataProduct(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                              @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize,
                                              @RequestParam(required= false)String productName,
                                              @RequestParam(required = false)String productPrice){
    try {
        Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0), Optional.ofNullable(pageSize).orElse(10));
        return new ResponseEntity(new EntityResponse(iProductService.searchDataProduct1(pageable, productName, productPrice),0),HttpStatus.OK);
    }catch(Exception e ){
        return new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
    }

}
@GetMapping("/dataSearch")
    public ResponseEntity<?>dataSearchProduct(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                              @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize,
                                              @RequestParam(required = false)String search,
                                              @RequestParam(required = false)String  productSize,
                                              @RequestParam(required = false)String productName){
    try {
        Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0), Optional.ofNullable(pageSize).orElse(10));
        return new ResponseEntity(new EntityResponse(iProductService.dataSearchProduct(pageable,search,productSize,productName),0),HttpStatus.OK);
    }catch (Exception e ){
        return new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
    }
}


}
