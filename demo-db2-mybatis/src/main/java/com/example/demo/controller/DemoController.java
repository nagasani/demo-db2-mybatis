package com.example.demo.controller;

import com.example.demo.dao.DemoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoDao demoDao;

    @GetMapping("/api/fetch")
    public DemoDao.Records fetchData(@RequestParam("minCustId") int minCustId,
                                     @RequestParam("minOrdAmt") BigDecimal minOrdAmt) {
        return demoDao.fetch(minCustId, minOrdAmt);
    }
}