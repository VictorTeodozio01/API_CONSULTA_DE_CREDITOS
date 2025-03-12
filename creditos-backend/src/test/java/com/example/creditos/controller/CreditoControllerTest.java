package com.example.creditos.controller;

import com.example.creditos.model.Credito;
import com.example.creditos.service.CreditoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreditoControllerTest {

    @Mock
    private CreditoService creditoService;

    @InjectMocks
    private CreditoController creditoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCreditosByNfse() {
        String numeroNfse = "7891011";
        Credito credito = new Credito();
        credito.setId(1L);
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

        when(creditoService.findByNumeroNfse(numeroNfse)).thenReturn(Collections.singletonList(credito));

        ResponseEntity<List<Credito>> response = creditoController.getCreditosByNfse(numeroNfse);

        assertEquals(1, response.getBody().size());
        assertEquals(numeroNfse, response.getBody().get(0).getNumeroNfse());
        verify(creditoService, times(1)).findByNumeroNfse(numeroNfse);
    }

    @Test
    void testGetCreditoByNumero() {
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

        when(creditoService.findByNumeroCredito(numeroCredito)).thenReturn(Collections.singletonList(credito));

        ResponseEntity<List<Credito>> response = creditoController.getCreditoByNumero(numeroCredito);

        assertEquals(1, response.getBody().size());
        assertEquals(numeroCredito, response.getBody().get(0).getNumeroCredito());
        verify(creditoService, times(1)).findByNumeroCredito(numeroCredito);

        

    }
}