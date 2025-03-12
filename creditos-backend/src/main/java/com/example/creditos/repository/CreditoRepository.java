package com.example.creditos.repository;

import com.example.creditos.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CreditoRepository extends JpaRepository<Credito, Long> {
    List<Credito> findByNumeroNfse(String numeroNfse);
    List<Credito> findByNumeroCredito(String numeroCredito);
}