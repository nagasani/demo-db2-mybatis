package com.example.demo.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {
    private Integer id;
    private BigDecimal amount;
    private Address address;            
    private List<Product> products;     
}
