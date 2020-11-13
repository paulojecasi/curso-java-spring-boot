package br.com.alunos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alunos.model.Aluno;

public interface AddAlunoDao extends JpaRepository<Aluno, Integer> {

}
