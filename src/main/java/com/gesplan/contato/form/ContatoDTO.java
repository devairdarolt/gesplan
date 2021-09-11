package com.gesplan.contato.form;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.gesplan.contato.entity.Contato;

public class ContatoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String sobrenome;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "E-mail inválido")
	private String email;

	// TODO Criar @TelefoneCollection para validação
	@NotEmpty(message = "Informe ao menos um telefone")
	private Set<String> telefones = new HashSet<>();

	private String observacao;

	public ContatoDTO() {

	}

	public ContatoDTO(Contato obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sobrenome = obj.getSobrenome();
		this.email = obj.getEmail();
		this.observacao = obj.getObservacao();
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobreNome) {
		this.sobrenome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> phones) {
		this.telefones = phones;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String note) {
		this.observacao = note;
	}

}
