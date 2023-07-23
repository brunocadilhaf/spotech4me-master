package br.com.tech4me.spotech4me.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tech4me.spotech4me.model.Cantor;

public interface CantorRepository extends JpaRepository<Cantor, Integer> {
    
}
