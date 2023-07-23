package br.com.tech4me.spotech4me.shared;

import br.com.tech4me.spotech4me.model.EstiloMusica;

public record MusicaDto(Integer id, String nome, int duracao, EstiloMusica estilo, CantorDto cantor) {
    
}
