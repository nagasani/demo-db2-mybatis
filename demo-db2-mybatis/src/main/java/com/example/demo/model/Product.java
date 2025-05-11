package com.example.demo.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Product {
    private Integer id;
    private String  description;
    private BigDecimal unitPrice;
}
