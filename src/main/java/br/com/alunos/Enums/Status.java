package br.com.alunos.Enums;

public enum Status {
	
	ABERTO("Aberto"),
	ENCERRADO("Encerrado"),
	CANCELADO("Cancelado"),
	TRANCADO("Trancado"),
	JUBILADO("Jubilado"),
	CONCLUIDO("Concluido");
	
	private String status;

	private Status(String status) {
		this.status = status;
	}
	
	
	
}
