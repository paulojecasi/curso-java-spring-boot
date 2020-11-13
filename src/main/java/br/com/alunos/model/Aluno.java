package br.com.alunos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.alunos.Enums.Curso;
import br.com.alunos.Enums.Status;
import br.com.alunos.Enums.Turno;


@Entity
public class Aluno {
	
	@Id                                                       // identficador da classe 
	@GeneratedValue(strategy = GenerationType.AUTO)           // o Id vai ser AUTO-incremento
	private Integer Id;
	
	@Column(name = "nome",length = 100)                                    // nome e tamanho do campo no BD
	private String nome;
	
	@Column(name = "curso",length = 50)
	@Enumerated(EnumType.STRING)
	private Curso curso;
	
	@Column(name = "matricula",length = 15)
	private String matricula;
	
	@Column(name = "status",length = 20)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "turno",length = 20)
	@Enumerated(EnumType.STRING)
	private Turno turno;

	
	//------	GETS AND SETS
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}
