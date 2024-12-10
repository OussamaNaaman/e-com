package com.example.billing_service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Product {


    private Long id;


    private String name;


    private Double price;



}
