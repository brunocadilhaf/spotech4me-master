package br.com.tech4me.spotech4me.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.spotech4me.Repository.CantorRepository;
import br.com.tech4me.spotech4me.model.Cantor;
import br.com.tech4me.spotech4me.shared.CantorDto;
import br.com.tech4me.spotech4me.shared.CantorListagemDto;

@Service
public class CantorServiceImpl implements CantorService {

    @Autowired
    private CantorRepository repositorio;

    @Override
    public List<CantorListagemDto> obterTodos() {
        return repositorio.findAll()
            .stream()
            .map(c -> new CantorListagemDto(c.getNome(), c.getSobrenome()))
            .toList();
    }

    @Override
    public Optional<CantorDto> obterPorId(Integer id) {
        Optional<Cantor> cantor = repositorio.findById(id);
        if (cantor.isPresent()) {
            return Optional.of(new CantorDto(cantor.get().getId(), cantor.get().getNome(), cantor.get().getSobrenome()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public CantorDto cadastrar(CantorDto dto) {
        Cantor cantor = new Cantor(dto);
        repositorio.save(cantor);
        return new CantorDto(cantor.getId(), cantor.getNome(), cantor.getSobrenome());
    }

    @Override
    public Optional<CantorDto> atualizar(Integer id, CantorDto dto) {
        Optional<Cantor> cantor = repositorio.findById(id);
        if (cantor.isPresent()) {
            Cantor cantorAtualizar = new Cantor(dto);
            cantorAtualizar.setId(id);
            repositorio.save(cantorAtualizar);
            return Optional.of(new CantorDto(cantorAtualizar.getId(), cantorAtualizar.getNome(), cantorAtualizar.getSobrenome()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deletar(Integer id) {
        repositorio.deleteById(id);
    }
    
}
