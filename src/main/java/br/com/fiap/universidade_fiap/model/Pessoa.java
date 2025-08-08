package br.com.fiap.universidade_fiap.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	// Local date trabalha com corrente e fusohorario de onde a gente tá
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	@Enumerated(EnumType.STRING)
	private EnumNacionalidade nacionalidade;
	private String email;

	public Pessoa() {
		super();
	}

	public Pessoa(long id, String nome, String cpf, LocalDate dataNascimento, EnumNacionalidade nacionalidade,
			String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EnumNacionalidade getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(EnumNacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
