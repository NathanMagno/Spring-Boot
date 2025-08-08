package br.com.fiap.universidade_fiap.model;

public enum EnumNivel {

	TECNICO("Técnico"), BACHARELADO("Bacharelado"), TECNOLOGO("Tecnólogo"), MBA("MBA"),
	ESPECIALIZACAO("Especialização"), MESTRADO("Mestrado"), DOUTORADO("Doutorado");

	private final String descricao;

	private EnumNivel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
