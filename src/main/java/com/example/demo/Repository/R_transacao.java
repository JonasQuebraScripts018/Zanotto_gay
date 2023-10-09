package com.example.demo.Repository;

import com.example.demo.Model.M_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_transacao extends JpaRepository<M_Pessoa, Long> {
    @Query(value = "UPDATE pessoa SET dinheiro 0 =''+ M_Pessoa.getdinheiro''", nativeQuery = true)
    M_Pessoa deposito(@Param("dinheiro") Long dinheiro, @Param("valorTransacao") Long valorTransacao);
}
