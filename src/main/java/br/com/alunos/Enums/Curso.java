package br.com.alunos.Enums;

public enum Curso {
	
	ADMINISTRACAO("Administracao"),
	TECNOLOGIA("Tecnologia"),
	CONTABILIDADE("Contabilidade"),
	ENFERMAGEM("Enfermagem"),
	MEDICINA("Medicina");
	
	private String curso;

	private Curso(String curso) {
		this.curso = curso;
	}
	
}
