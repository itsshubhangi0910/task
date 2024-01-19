package com.example.productProject.serviceImpl;

import com.example.productProject.model.customerRequest.CustomerRequest;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Object saveDataCustomer(CustomerRequest customerRequest);

    Object getByIddCustomer(Long customerId) throws Exception;

    Object allDataCustomer();

    Object statusChangeCustomer(Long customerId) throws Exception;

    Object deleteDataCustomer(Long customerId) throws Exception;

    Object getAllPaginationCustomer(Pageable pageable);

    Object getSearchCustomer(Pageable pageable, String searching);
}
