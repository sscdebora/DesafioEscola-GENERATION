package com.escola.escola_crud.repository;


import com.escola.escola_crud.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Método para encontrar alunos pelo nome
    List<Aluno> findByNome(String nome);

    // Método para encontrar alunos com idade maior que um valor especificado
    List<Aluno> findByIdadeGreaterThan(int idade);

    // Método para encontrar alunos por professor
    List<Aluno> findByProfessor(String professor);

    // Consulta personalizada usando JPQL
    @Query("SELECT a FROM Aluno a WHERE a.notaPrimeiroSemestre > :nota")
    List<Aluno> findAlunosWithNotaPrimeiroSemestreGreaterThan(@Param("nota") double nota);
}
