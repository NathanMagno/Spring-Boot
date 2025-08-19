package br.com.fiap.universidade_fiap.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "O campo nome é obrigatório")
	@Size(min = 3, max = 90, message = "Nome deve ter, ao menos, 3 caracteres "
			+ "e no máximo 90")
	private String nome;
	@CPF(message = "O CPF informado é inválido")
	private String cpf;
	@Past(message = "A data de nascimento é inválida")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	@Enumerated(EnumType.STRING)
	private EnumNacionalidade nacionalidade;
	@NotEmpty(message =  "O campo de e-amil é obrigatório")
	@Email(message = "O formato de e-mail é inválido")
	private String email;

	public Pessoa() {

	}

	public Pessoa(Long id, String nome, String cpf, LocalDate dataNascimento, EnumNacionalidade nacionalidade,
			String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.email = email;
	}
	
	public void transferirPessoa(Pessoa pessoaAtualizada)
	{
		setNome(pessoaAtualizada.getNome());
		setCpf(pessoaAtualizada.getCpf());
		setDataNascimento(pessoaAtualizada.getDataNascimento());
		setNacionalidade(pessoaAtualizada.getNacionalidade());
		setEmail(pessoaAtualizada.getEmail());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
