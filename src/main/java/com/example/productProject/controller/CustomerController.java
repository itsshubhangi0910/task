package com.example.productProject.controller;

import com.example.productProject.model.customerRequest.CustomerRequest;
import com.example.productProject.model.customerResponse.CustomResponse;
import com.example.productProject.model.customerResponse.EntityResponse;
import com.example.productProject.serviceImpl.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api1")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping("/saveData")
    public ResponseEntity<?>saveDataCustomer(@RequestBody CustomerRequest customerRequest){
        try {
            return new ResponseEntity(iCustomerService.saveDataCustomer(customerRequest),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }
    @GetMapping("/getByIdd")
    public ResponseEntity<?>getByIddCustomer(@RequestParam Long customerId){
        try {
            return new ResponseEntity(new EntityResponse(iCustomerService.getByIddCustomer(customerId),0), HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/allData")
    public ResponseEntity<?>allDataCustomer(){
        try {
            return new ResponseEntity(new EntityResponse(iCustomerService.allDataCustomer(), 0), HttpStatus.OK);
        }catch (Exception e ){
            return  new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @PutMapping("/statusChange")
    public ResponseEntity<?>statusChangeCustomer(@RequestParam Long customerId){
        try {
            return new ResponseEntity(new EntityResponse(iCustomerService.statusChangeCustomer(customerId),0), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteData")
    public  ResponseEntity<?>deleteDataCustomer(@RequestParam Long customerId){
        try {
            return new ResponseEntity(new EntityResponse(iCustomerService.deleteDataCustomer(customerId), 0), HttpStatus.OK);
        }catch (Exception e ){
            return  new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getAllPagination")
    public ResponseEntity<?>getAllPaginationCustomer(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                                     @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pagesize) {
        try {
            Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0), Optional.ofNullable(pagesize).orElse(10));
            return new ResponseEntity(new EntityResponse(iCustomerService.getAllPaginationCustomer(pageable), 0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new CustomResponse(e.getMessage(), -1), HttpStatus.OK);
        }
    }
    @GetMapping("/getSearch")
    public ResponseEntity<?>getSearchCustomer(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                              @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize,
                                              @RequestParam(required = false)String searching){
        try {
            Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0), Optional.ofNullable(pageSize).orElse(10));
            return new ResponseEntity(new EntityResponse(iCustomerService.getSearchCustomer(pageable, searching), 0), HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }

}