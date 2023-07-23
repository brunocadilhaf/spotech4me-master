package br.com.tech4me.spotech4me.shared;

import br.com.tech4me.spotech4me.model.EstiloMusica;

public record MusicaListagemDto(String nome, EstiloMusica estilo, CantorDto cantor) {
    
}
