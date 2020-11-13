package br.com.alunos.Enums;

public enum Turno {
	
	PREMATUTINO("Pre-Matutino"),
	MANHA("Manha"),
	TARDE("Tarde"),
	NOITE("Noite");
	
	private String turno;
	
	private Turno(String turno) {
		this.turno = turno;
	}
	

}
