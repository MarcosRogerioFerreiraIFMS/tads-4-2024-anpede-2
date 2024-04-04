package com.anpede.dto;

import java.io.Serializable;

import com.anpede.entities.Equipamento;
import com.anpede.entities.enums.CategoriaEquipamento;

public class EquipamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String descricao;
	private String marca;
	private CategoriaEquipamento categoria;
	private String foto;
	private Double valor;
	private Integer quantidade;
	
	public EquipamentoDTO() {
		// TODO Auto-generated constructor stub
	}

	public EquipamentoDTO(Long id, String nome, String descricao, String marca, CategoriaEquipamento categoria,
			String foto, Double valor, Integer quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.categoria = categoria;
		this.foto = foto;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public EquipamentoDTO(Equipamento entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
		this.marca = entity.getMarca();
		this.categoria = entity.getCategoria();
		this.foto = entity.getFoto();
		this.valor = entity.getValor();
		this.quantidade = entity.getQuantidade();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public CategoriaEquipamento getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEquipamento categoria) {
		this.categoria = categoria;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
