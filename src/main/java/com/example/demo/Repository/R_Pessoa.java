package com.example.demo.Repository;

import com.example.demo.Model.M_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Pessoa extends JpaRepository<M_Pessoa, Long> {
    @Query(value = "SELECT * FROM pessoa WHERE cpf = :usuario and senha = :senha limit 1", nativeQuery = true)
    M_Pessoa findByUsuarioESenha(@Param("usuario") Long usuario, @Param("senha") String senha);

    @Query(value = "SELECT dinheiro FROM pessoa WHERE id = :id", nativeQuery = true)
    int pegarSaldo(@Param("id") long id);
}
