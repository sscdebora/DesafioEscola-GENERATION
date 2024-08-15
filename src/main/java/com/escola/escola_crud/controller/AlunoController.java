package com.escola.escola_crud.controller;

import com.escola.escola_crud.model.Aluno;
import com.escola.escola_crud.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Endpoint para listar todos os alunos
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.findAll();
    }

    // Endpoint para buscar um aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoService.findById(id);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo aluno
    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.save(aluno);
        return ResponseEntity.status(201).body(novoAluno);
    }

    // Endpoint para atualizar um aluno existente
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoExistente = alunoService.findById(id);
        if (!alunoExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Aluno alunoAtualizado = alunoExistente.get();
        alunoAtualizado.setNome(aluno.getNome());
        alunoAtualizado.setIdade(aluno.getIdade());
        alunoAtualizado.setNotaPrimeiroSemestre(aluno.getNotaPrimeiroSemestre());
        alunoAtualizado.setNotaSegundoSemestre(aluno.getNotaSegundoSemestre());
        alunoAtualizado.setProfessor(aluno.getProfessor());
        alunoAtualizado.setSala(aluno.getSala());

        Aluno updatedAluno = alunoService.save(alunoAtualizado);
        return ResponseEntity.ok(updatedAluno);
    }

    // Endpoint para deletar um aluno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        if (!alunoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
