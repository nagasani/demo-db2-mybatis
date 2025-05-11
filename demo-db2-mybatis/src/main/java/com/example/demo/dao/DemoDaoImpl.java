package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class DemoDaoImpl implements DemoDao {

    private final IBatisDao iBatisDao;

    @Override
    public Records fetch(int minCustId, BigDecimal minOrdAmt) {
        Map<String, Object> params = new HashMap<>();
        params.put("minCustId", minCustId);
        params.put("minOrdAmt", minOrdAmt);
        params.put("errCode", null);
        params.put("errMsg", null);

        List<Object> results = iBatisDao.executeFetch(params);
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        for (Object row : results) {
            if (row instanceof Customer customer) customers.add(customer);
            else if (row instanceof Order order) orders.add(order);
        }

        return new Records(customers, orders,
                (Integer) params.get("errCode"),
                (String) params.get("errMsg"));
    }
}
