package com.anpede.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.anpede.entities.Associado;

public class AssociadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;	
	private String nome;
	private String CPF;
	private LocalDate dataNascimento;
	private String telefone;
	private String email;
	private String endereco;
	
	public AssociadoDTO() {
		// TODO Auto-generated constructor stub
	}

	public AssociadoDTO(Long id, String nome, String cPF, LocalDate dataNascimento, String telefone, String email,
			String endereco) {
		this.id = id;
		this.nome = nome;
		this.CPF = cPF;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	public AssociadoDTO(Associado entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.CPF = entity.getCPF();
		this.dataNascimento = entity.getDataNascimento();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
		this.endereco = entity.getEndereco();
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	

}






