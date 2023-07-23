package br.com.tech4me.spotech4me.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.spotech4me.service.CantorService;
import br.com.tech4me.spotech4me.shared.CantorDto;
import br.com.tech4me.spotech4me.shared.CantorListagemDto;

@RestController
@RequestMapping("/cantores")
public class CantorController {

    @Autowired
    private CantorService servico;

    @GetMapping
    public ResponseEntity<List<CantorListagemDto>> obterTodos() {
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CantorDto> obterPorId(@PathVariable Integer id) {
        Optional<CantorDto> cantor = servico.obterPorId(id);
        if (cantor.isPresent()) {
            return new ResponseEntity<>(cantor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<CantorDto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CantorDto> cadastrar(@RequestBody CantorDto dto) {
        return new ResponseEntity<>(servico.cadastrar(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CantorDto> atualizar(@PathVariable Integer id, @RequestBody CantorDto dto) {
        Optional<CantorDto> cantor = servico.atualizar(id, dto);
        if (cantor.isPresent()) {
            return new ResponseEntity<>(cantor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<CantorDto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        servico.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
