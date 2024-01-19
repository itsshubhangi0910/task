package com.example.productProject.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Long productId;
    private String productName;
    private String productPrice;
    private String productOwner;
    private String productCode;
    private String productSize;


}
