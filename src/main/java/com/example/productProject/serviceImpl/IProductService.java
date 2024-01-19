package com.example.productProject.serviceImpl;

import com.example.productProject.model.request.ProductRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

public interface IProductService {
    Object saveOrUpdatedProduct(ProductRequest productRequest);

    Object getByIdProduct(Long productId) throws Exception;

    Object getAllProduct();

    Object softDeleteProduct(Long productId) throws Exception;

    Object getAllDataProduct(Pageable pageable);

    Object changeStatusProduct(Long productId) throws Exception;

    Object searchDataProduct1(Pageable pageable, String productName, String productPrice);


    Object dataSearchProduct(Pageable pageable, String search, String productSize, String productName);
}
