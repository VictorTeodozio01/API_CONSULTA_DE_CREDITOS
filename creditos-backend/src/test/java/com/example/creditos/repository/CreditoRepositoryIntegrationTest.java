package com.example.creditos.repository;

import com.example.creditos.model.Credito;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Transactional
public class CreditoRepositoryIntegrationTest {
    @Autowired
    private CreditoRepository creditoRepository;

    @BeforeEach
    void clearTable() {
        creditoRepository.deleteAll(); 
    }

    @Test
    void testFindByNumeroNfse() {
        String numeroNfse = "7891011";
        Credito credito = new Credito();
        credito.setNumeroCredito("123456");
        credito.setNumeroNfse(numeroNfse);
        credito.setDataConstituicao(LocalDate.of(2024, 2, 25));
        credito.setValorIssqn(new BigDecimal("1500.75"));
        credito.setTipoCredito("ISSQN");
        credito.setSimplesNacional(true);
        credito.setAliquota(new BigDecimal("5.0"));
        credito.setValorFaturado(new BigDecimal("30000.00"));
        credito.setValorDeducao(new BigDecimal("5000.00"));
        credito.setBaseCalculo(new BigDecimal("25000.00"));

        creditoRepository.save(credito); 
        List<Credito> result = creditoRepository.findByNumeroNfse(numeroNfse);
        assertEquals(1, result.size());
        assertEquals(numeroNfse, result.get(0).getNumeroNfse());
    }
}
