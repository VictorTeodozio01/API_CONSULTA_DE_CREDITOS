package com.example.creditos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.creditos.repository.CreditoRepository;

@SpringBootTest
class CreditosApplicationTests {

    @Test
    void contextLoads() {
    }

	@Autowired
    private CreditoRepository creditoRepository;

    @BeforeEach
    void clearTable() {
        creditoRepository.deleteAll(); 
    }
}