package br.com.tech4me.spotech4me.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.spotech4me.shared.CantorDto;
import br.com.tech4me.spotech4me.shared.CantorListagemDto;

public interface CantorService {
    List<CantorListagemDto> obterTodos();
    Optional<CantorDto> obterPorId(Integer id);
    CantorDto cadastrar(CantorDto dto);
    Optional<CantorDto> atualizar(Integer id, CantorDto dto);
    void deletar(Integer id);
}
