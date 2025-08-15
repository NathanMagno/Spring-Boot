package br.com.fiap.universidade_fiap.model;

public enum EnumStatus {

	ATIVO("Ativo"), INATIVO("Inativo"), TRANCADO("Trancado"),
	FORMADO("Formado"), EM_MOBILIDADE("Em Mobilidade"), CANCELADO("Cancelado"), A_DEFINIR("A definir");

	private final String descricao;

	private EnumStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
