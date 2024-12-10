package com.example.billing_service.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; private Date billingDate;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
    private long customerID;
    @Transient private Customer customer;
}
