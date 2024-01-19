package com.example.productProject.repository;

import com.example.productProject.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT * FROM `customer`",nativeQuery = true)
    List<Customer> getAllPagination(Pageable pageable);
@Query(value = "SELECT * FROM  `customer`WHERE CONCAT(first_name,' ',last_name) LIKE %:searching%",nativeQuery = true)
Page<Customer> getAllSearching(Pageable pageable, String searching);
@Query(value = "SELECT * FROM `customer`",nativeQuery = true)
Page<Customer> getAll(Pageable pageable);
}
