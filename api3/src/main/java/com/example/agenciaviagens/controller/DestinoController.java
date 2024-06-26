package com.example.agenciaviagens.controller;

import com.example.agenciaviagens.model.Destino;
import com.example.agenciaviagens.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @PostMapping
    public ResponseEntity<Destino> cadastrarDestino(@RequestBody Destino destino) {
        Destino novoDestino = destinoService.salvarDestino(destino);
        return ResponseEntity.ok(novoDestino);
    }

    @GetMapping
    public ResponseEntity<List<Destino>> listarDestinos() {
        List<Destino> destinos = destinoService.listarDestinos();
        return ResponseEntity.ok(destinos);
    }

    @GetMapping("/pesquisa")
    public ResponseEntity<List<Destino>> pesquisarDestinos(@RequestParam(required = false) String nome, @RequestParam(required = false) String localizacao) {
        if (nome != null) {
            return ResponseEntity.ok(destinoService.pesquisarPorNome(nome));
        } else if (localizacao != null) {
            return ResponseEntity.ok(destinoService.pesquisarPorLocalizacao(localizacao));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> obterDestino(@PathVariable Long id) {
        Optional<Destino> destino = destinoService.obterDestinoPorId(id);
        return destino.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/avaliar")
    public ResponseEntity<Destino> avaliarDestino(@PathVariable Long id, @RequestParam double nota) {
        Destino destinoAvaliado = destinoService.avaliarDestino(id, nota);
        if (destinoAvaliado != null) {
            return ResponseEntity.ok(destinoAvaliado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDestino(@PathVariable Long id) {
        destinoService.excluirDestino(id);
        return ResponseEntity.noContent().build();
    }
}
