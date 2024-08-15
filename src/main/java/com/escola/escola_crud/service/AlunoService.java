package com.escola.escola_crud.service;

import com.escola.escola_crud.model.Aluno;
import com.escola.escola_crud.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Método para listar todos os alunos
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    // Método para encontrar um aluno pelo ID
    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    // Método para salvar um aluno (criar ou atualizar)
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Método para deletar um aluno pelo ID
    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}
