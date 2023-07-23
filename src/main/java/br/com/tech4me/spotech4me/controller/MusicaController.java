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

import br.com.tech4me.spotech4me.service.MusicaService;
import br.com.tech4me.spotech4me.shared.MusicaDto;
import br.com.tech4me.spotech4me.shared.MusicaListagemDto;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaService servico;

    @GetMapping
    public ResponseEntity<List<MusicaListagemDto>> obterTodasMusicas(){
        return new ResponseEntity<> (servico.obterTodasMusicas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicaDto> obterMusicaPorId(@PathVariable Integer id){
        Optional <MusicaDto> musica = servico.obterMusicaPorId(id);

        if(musica.isPresent()){
            return new ResponseEntity<>(musica.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<MusicaDto> cadastrarMusica(@RequestBody MusicaDto Dto){
        return new ResponseEntity<>(servico.cadastrarMusica(Dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaDto> atualizarPorId(@RequestBody MusicaDto dto, @PathVariable Integer id){
        Optional<MusicaDto> musicaAtualizada = servico.atualizarPorId(id, dto);

        if(musicaAtualizada.isPresent()){
            return new ResponseEntity<>(musicaAtualizada.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPorId(@PathVariable Integer id){
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
