package com.example.demo.dao;

import java.math.BigDecimal;

public interface DemoDao {
    Records fetch(int minCustId, BigDecimal minOrdAmt);

    record Records(java.util.List<com.example.demo.model.Customer> customers,
                   java.util.List<com.example.demo.model.Order> orders,
                   Integer errCode, String errMsg) {}
}