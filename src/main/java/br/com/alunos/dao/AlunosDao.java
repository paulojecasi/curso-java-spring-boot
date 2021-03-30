package br.com.alunos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alunos.model.Aluno;

public interface AlunosDao extends JpaRepository<Aluno, Integer> {
	
	@Query("select p from Aluno p where p.status= '0'")
	public List<Aluno> findByStatusAtivos();
	
	@Query("select p from Aluno p where p.status= '1'")
	public List<Aluno> findByStatusInativos();
	
}
