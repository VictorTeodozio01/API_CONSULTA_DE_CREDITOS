package com.example.creditos.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.creditos.model.Credito;
import com.example.creditos.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
@CrossOrigin(origins = "http://localhost:4200") 
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        StringBuilder mensagem = new StringBuilder("Bem-vindo ao sistema de créditos!<br><br>");
        List<Credito> creditos = creditoService.findAll();

        if (creditos.isEmpty()) {
            mensagem.append("Nenhum crédito cadastrado.");
        } else {
            mensagem.append("Créditos cadastrados:<br>");
            for (Credito credito : creditos) {
                mensagem.append("- Número do Crédito: ").append(credito.getNumeroCredito())
                        .append(", Número da NFSe: ").append(credito.getNumeroNfse()).append("<br>");
            }
        }

        return ResponseEntity.ok(mensagem.toString());
    }

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<Credito>> getCreditosByNfse(@PathVariable String numeroNfse) {
        List<Credito> creditos = creditoService.findByNumeroNfse(numeroNfse);
        return ResponseEntity.ok(creditos);
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<List<Credito>> getCreditoByNumero(@PathVariable String numeroCredito) {
        List<Credito> credito = creditoService.findByNumeroCredito(numeroCredito);
        if (credito != null) {
            return ResponseEntity.ok(credito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}