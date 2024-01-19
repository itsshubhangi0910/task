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
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "customer_Email")
    private String Email;

    @Column(name = "customer_Mobile_No")
    private  String mobileNo;

    @Column(name = "customer_City")
    private String City;

    @Column(name = "is_deleted")
    private boolean isDeleted=false;

    @Column(name = "is_Active")
    private boolean isActive=true;

    @CreationTimestamp
    @Column(name = "created_At")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_At")
    private LocalDateTime updatedAt;

}
