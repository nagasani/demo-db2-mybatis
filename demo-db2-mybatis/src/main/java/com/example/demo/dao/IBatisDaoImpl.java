package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class IBatisDaoImpl implements IBatisDao {

    private final SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Object> executeFetch(Map<String, Object> params) {

        List<Object> combined = new ArrayList<>();

        try (SqlSession session = sqlSessionFactory.openSession()) {
           
            List<Object> rows =
                    session.selectList("com.example.demo.mapper.DemoMapper.callProc", params);

            for (Object rs : rows) {
                if (rs instanceof List<?> list) {        
                    for (Object obj : list) {            
                        if (obj instanceof Customer || obj instanceof Order) {
                            combined.add(obj);
                        }
                    }
                }
            }
        }
        return combined;
    }

}
