package com.example.demo.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Order {
    private Integer id;
    private BigDecimal amount;
    private Address address;
}