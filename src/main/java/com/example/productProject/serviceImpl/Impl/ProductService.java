package com.example.productProject.serviceImpl.Impl;

import com.example.productProject.model.Product;
import com.example.productProject.model.request.ProductRequest;
import com.example.productProject.serviceImpl.PageDto;
import com.example.productProject.repository.ProductRepository;
import com.example.productProject.serviceImpl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  implements IProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Object saveOrUpdatedProduct(ProductRequest productRequest) {
        if (productRepository.existsById(productRequest.getProductId())) {
            Product product = productRepository.findById(productRequest.getProductId()).get();
            product.setProductName(productRequest.getProductName());
            product.setProductPrice(productRequest.getProductPrice());
            product.setProductSize(productRequest.getProductSize());
            product.setProductOwner(productRequest.getProductOwner());
            product.setProductCode(productRequest.getProductCode());
            productRepository.save(product);
            return "Updated";
        } else {
            Product product = new Product();
            product.setProductName(productRequest.getProductName());
            product.setProductPrice(productRequest.getProductPrice());
            product.setProductCode(productRequest.getProductCode());
            product.setProductSize(productRequest.getProductSize());
            product.setProductOwner(productRequest.getProductOwner());
            product.setProductIsDeleted(false);
            product.setIsactive(true);
            productRepository.save(product);
            return "save data";
        }

    }

    @Override
    public Object getByIdProduct(Long productId) throws Exception {
        if (productRepository.existsById(productId)) {
            Product product = productRepository.findById(productId).get();
            return product;
        } else {
            throw new Exception("id not found");

        }
    }

    @Override
    public Object getAllProduct() {
        List<Product> allProduct = productRepository.getAllProduct(false);
        return allProduct;
    }

    @Override
    public Object softDeleteProduct(Long productId) throws Exception {
        if (productRepository.existsById(productId)) {
            Product product = productRepository.findById(productId).get();
            product.setProductIsDeleted(true);
            productRepository.save(product);
            return "Deleted";
        } else {
            throw new Exception("id not deleted");
        }
    }

    @Override
    public Object getAllDataProduct(Pageable pageable) {
        Page<Product> all = productRepository.getAll(pageable);
        return new PageDto(all.getContent(), all.getTotalElements(), all.getTotalPages(), all.getNumber());
    }

    @Override
    public Object changeStatusProduct(Long productId) throws Exception {
        if (productRepository.existsById(productId)) {
            Product product = productRepository.findById(productId).get();
            product.setIsactive(false);
            productRepository.save(product);
            return "change status";
        } else {
            throw new Exception("status not change");
        }
    }

    @Override
    public Object searchDataProduct1(Pageable pageable, String productName, String productPrice) {
        Page<Product> products;
        if (productName != null) {
            products = productRepository.getProductName(pageable, productName);
        } else if (productPrice != null) {
            products = productRepository.gteProductPrice(pageable, productPrice);
        } else if (productName!=null && productPrice!=null){
            products = productRepository.getAllProductNameAndProductPrice(pageable);
        }else{
            products=productRepository.getAll(pageable);
        }
        return new PageDto(products.getContent(), products.getTotalElements(), products.getTotalPages(), products.getNumber());
    }

    @Override
    public Object dataSearchProduct(Pageable pageable, String search, String productSize, String productName) {
        Page<Product> products;
        if (search!=null) {
            products = productRepository.getProductNameAndProductSize(pageable,search);
        } else {
            products = productRepository.getAllProducts(pageable);
        }
        return products;
    }
}

