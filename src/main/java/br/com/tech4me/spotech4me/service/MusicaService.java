package br.com.tech4me.spotech4me.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.spotech4me.shared.MusicaDto;
import br.com.tech4me.spotech4me.shared.MusicaListagemDto;

public interface MusicaService {
    List<MusicaListagemDto> obterTodasMusicas();
    Optional<MusicaDto> obterMusicaPorId(Integer id);
    MusicaDto cadastrarMusica(MusicaDto dto);
    Optional<MusicaDto> atualizarPorId(Integer id,MusicaDto dto);
    void excluirPorId(Integer id);

}
