package com.example.esame.service.impl;

import com.example.esame.model.TestEntity;
import com.example.esame.repository.TestRepository;
import com.example.esame.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public String testEsame(int a, int b) {
        TestEntity tx = new TestEntity(a, b, a + b);
        tx = testRepository.save(tx);
        return tx.toString();
    }

}
