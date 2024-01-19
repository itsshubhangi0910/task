package com.example.productProject.repository;

import com.example.productProject.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * from `product`",nativeQuery =true)
    Page<Product> getAll(Pageable pageable);


    @Query(value = "SELECT * FROM `product` WHERE product_is_deleted =:b",nativeQuery = true)
    List<Product> getAllProduct(boolean b);

@Query(value = "SELECT * FROM `product` WHERE product_name LIKE %:productName%",nativeQuery = true)
    Page<Product> getProductName(Pageable pageable, String productName);

@Query(value = "SELECT * FROM `product` WHERE product_price LIKE %:productPrice%",nativeQuery = true)
    Page<Product> gteProductPrice(Pageable pageable, String productPrice);


@Query(value = "SELECT * FROM `product` WHERE product_name LIKE %:productName OR product_price LIKE %:productPrice",nativeQuery = true)
    Page<Product> getAllProductNameAndProductPrice(Pageable pageable);


@Query(value = "SELECT * FROM `product` WHERE CONCAT(product_name,' ',product_size) LIKE %:search%",nativeQuery = true)
    Page<Product> getProductNameAndProductSize(Pageable pageable, String search);

@Query(value = "SELECT * FROM `product`",nativeQuery = true)
    Page<Product> getAllProducts(Pageable pageable);



    // Page<Product> getAllProductNameAndProductprice(Pageable pageable, String productName, String productSize);


    // Object findAllAndProductIsDeleted(boolean b);
//@Query(value = "SELECT * from `product` where ",nativeQuery =true)
   // Object findAll(boolean b);
}
