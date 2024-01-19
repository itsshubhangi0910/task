package com.example.productProject.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long poductId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "product_size")
    private String productSize;

    @Column(name = "product_owner")
    private String productOwner;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_is_deleted")
    private boolean productIsDeleted = false;

    @Column(name = "product_is_active")
    private boolean Isactive=true;

    @CreationTimestamp
    @Column(name = "created_At")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_At")
    private LocalDateTime updatedAt;

}



