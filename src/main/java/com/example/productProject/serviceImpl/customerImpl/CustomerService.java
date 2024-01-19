package com.example.productProject.serviceImpl.customerImpl;

import com.example.productProject.model.Customer;
import com.example.productProject.model.customerRequest.CustomerRequest;
import com.example.productProject.repository.CustomerRepository;
import com.example.productProject.serviceImpl.ICustomerService;

import com.example.productProject.serviceImpl.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Object saveDataCustomer(CustomerRequest customerRequest) {
        if (customerRepository.existsById(customerRequest.getCustomerId())){
            Customer customer=customerRepository.findById(customerRequest.getCustomerId()).get();
            customer.setFirstName(customerRequest.getFirstName());
            customer.setLastName(customerRequest.getLastName());
            customer.setEmail(customerRequest.getEmail());
            customer.setCity(customerRequest.getCity());
            customer.setMobileNo(customerRequest.getMobileNo());
            customerRepository.save(customer);
            return "updated";
        }else{
            Customer customer=new Customer();
            customer.setFirstName(customerRequest.getFirstName());
            customer.setLastName(customerRequest.getLastName());
            customer.setCity(customerRequest.getCity());
            customer.setMobileNo(customerRequest.getMobileNo());
            customer.setEmail(customerRequest.getEmail());
            customer.setActive(true);
            customer.setDeleted(false);
            customerRepository.save(customer);
            return "save data";
        }
    }

    @Override
    public Object getByIddCustomer(Long customerId) throws Exception {
        if (customerRepository.existsById(customerId)){
            Customer customer=customerRepository.findById(customerId).get();
            return customer;
        }else {
            throw new Exception("id not found");
        }
    }

    @Override
    public Object allDataCustomer() {
        List<Customer> customers=customerRepository.findAll();
        return customers;

    }

    @Override
    public Object statusChangeCustomer(Long customerId) throws Exception {
        if (customerRepository.existsById(customerId)) {
            Customer customer = customerRepository.findById(customerId).get();
            customer.setActive(false);
            customerRepository.save(customer);
            return "change status";
        }else {
            throw  new Exception("status not change");

        }
    }

    @Override
    public Object deleteDataCustomer(Long customerId) throws Exception {
        if (customerRepository.existsById(customerId)){
            Customer customer= customerRepository.findById(customerId).get();
            customer.setDeleted(true);
            customerRepository.save(customer);
            return "deleted";
        }else {
            throw new Exception("id not deleted");
        }
    }

    @Override
    public Object getAllPaginationCustomer(Pageable pageable) {
        List<Customer> all = customerRepository.getAllPagination(pageable);
        return  all;
    }

    @Override
    public Object getSearchCustomer(Pageable pageable, String searching) {
        Page<Customer>customers;
        if (searching!=null){
             customers=customerRepository.getAllSearching(pageable,searching);
        }else {
             customers=customerRepository.getAll(pageable);
        }
        return customers;

    }
}
