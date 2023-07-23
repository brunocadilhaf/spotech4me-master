package br.com.tech4me.spotech4me.model;

import br.com.tech4me.spotech4me.shared.MusicaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nome;
    @Column
    private int duracao;
    @Enumerated(EnumType.STRING)
    @Column
    private EstiloMusica estilo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Cantor.class)
    @JoinColumn(name = "id_cantor", referencedColumnName = "id", nullable = false)
    private Cantor cantor;

    public Musica(){}

    public Musica(MusicaDto dto) {
        this.nome = dto.nome();
        this.duracao = dto.duracao();
        this.estilo = dto.estilo();
        this.cantor = new Cantor(dto.cantor());
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public EstiloMusica getEstilo() {
        return estilo;
    }
    public void setEstilo(EstiloMusica estilo) {
        this.estilo = estilo;
    }

    public Cantor getCantor() {
        return cantor;
    }

    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
    }
}
