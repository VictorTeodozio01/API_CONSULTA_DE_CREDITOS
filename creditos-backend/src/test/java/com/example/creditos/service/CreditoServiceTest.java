package com.example.creditos.service;

import com.example.creditos.model.Credito;
import com.example.creditos.repository.CreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreditoServiceTest {

    @Mock
    private CreditoRepository creditoRepository;

    @InjectMocks
    private CreditoService creditoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByNumeroCredito() {
        
        String numeroCredito = "123456";
        Credito credito = new Credito();
        credito.setId(1L);
        credito.setNumeroCredito(numeroCredito);
        credito.setNumeroNfse("7891011");
        credito.setDataConstituicao(LocalDate.of(2024, 2, 25));
        credito.setValorIssqn(new BigDecimal("1500.75"));
        credito.setTipoCredito("ISSQN");
        credito.setSimplesNacional(true);
        credito.setAliquota(new BigDecimal("5.0"));
        credito.setValorFaturado(new BigDecimal("30000.00"));
        credito.setValorDeducao(new BigDecimal("5000.00"));
        credito.setBaseCalculo(new BigDecimal("25000.00"));

        when(creditoRepository.findByNumeroCredito(numeroCredito)).thenReturn(Collections.singletonList(credito));

        List<Credito> result = creditoService.findByNumeroCredito(numeroCredito);

        assertEquals(1, result.size());
        assertEquals(numeroCredito, result.get(0).getNumeroCredito());
        verify(creditoRepository, times(1)).findByNumeroCredito(numeroCredito);
    }

}