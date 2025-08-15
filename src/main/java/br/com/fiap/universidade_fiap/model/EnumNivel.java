package br.com.fiap.universidade_fiap.model;

public enum EnumNivel {

	TECNICO("Técnico"), BACHARELADO("Bacharelado"), TECNOLOGO("Tecnólogo"), MBA("MBA"),
	ESPECIALIZACAO("Especialização"), MESTRADO("Mestrado"), DOUTORADO("Doutorado"), A_DEFINIR("A definir");

	private final String descricao;

	EnumNivel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
