package br.com.fiap.universidade_fiap.model;

public enum EnumNacionalidade {

	BRASILEIRA("Brasileira"), NORTE_AMERICANA("Norte-Americana"), 
	JAPONESA("Japonesa"), 
	ITALIANA("Italiana"),
	ARGENTINA("Argentina"), CHILENA("Chilena"), COLOMBIANA("Colombiana");

	private final String descricao;

	private EnumNacionalidade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
