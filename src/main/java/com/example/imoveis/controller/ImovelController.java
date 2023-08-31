package com.example.imoveis.controller;

import com.example.imoveis.dto.CriarImovelDTO;
import com.example.imoveis.exceptions.ImovelNotFoundException;
import com.example.imoveis.model.Imovel;
import com.example.imoveis.service.ImovelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imovel")
public class ImovelController {
    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @GetMapping
    public ResponseEntity<List<Imovel>> findAll(@RequestParam(name = "tipo", required = false) String tipo) {
        List<Imovel> imoveis = imovelService.findAll(tipo);
        return ResponseEntity.ok().body(imoveis);
    }

    @PostMapping
    public ResponseEntity<Imovel> create(@RequestBody CriarImovelDTO criarImovelDTO) {
        Imovel imovel = imovelService.create(criarImovelDTO);
        return ResponseEntity.ok().body(imovel);
    }

    @GetMapping("{id}")
    public ResponseEntity<Imovel> findById(@PathVariable("id") Integer id) throws ImovelNotFoundException {
        Imovel imovel = imovelService.findById(id);
        return ResponseEntity.ok().body(imovel);
    }
}
