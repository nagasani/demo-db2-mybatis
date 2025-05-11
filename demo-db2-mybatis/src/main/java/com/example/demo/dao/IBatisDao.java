package com.example.demo.dao;

import java.util.List;
import java.util.Map;

public interface IBatisDao {
    List<Object> executeFetch(Map<String, Object> params);
}