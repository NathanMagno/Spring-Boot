package br.com.fiap.universidade_fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "discente")
public class Discente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// JoinColmn = coluna de ligação para chaves estrangeiras
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	private long rm;
	@Enumerated(EnumType.STRING)
	private EnumStatus status;
	@Enumerated(EnumType.STRING)
	private EnumNivel nivel;

	
	
	public Discente() {
		super();
	}

	public Discente(long id, Pessoa pessoa, long rm, EnumStatus status, EnumNivel nivel) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.rm = rm;
		this.status = status;
		this.nivel = nivel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public long getRm() {
		return rm;
	}

	public void setRm(long rm) {
		this.rm = rm;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public EnumNivel getNivel() {
		return nivel;
	}

	public void setNivel(EnumNivel nivel) {
		this.nivel = nivel;
	}

}
