package com.anpede.dto;

import java.io.Serializable;

import com.anpede.entities.Equipamento;
import com.anpede.entities.EquipamentoItem;
import com.anpede.entities.enums.Situacao;

public class EquipamentoItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id; 
	private String numeroSerie;
	private Situacao situacao;
	private Equipamento equipamento;
	
	public EquipamentoItemDTO() {
		// TODO Auto-generated constructor stub
	}

	public EquipamentoItemDTO(Long id, String numeroSerie, Situacao situacao, Equipamento equipamento) {
		this.id = id;
		this.numeroSerie = numeroSerie;
		this.situacao = situacao;
		this.equipamento = equipamento;
	}
	
	public EquipamentoItemDTO(EquipamentoItem entity) {
		this.id = entity.getId();
		this.numeroSerie = entity.getNumeroSerie();
		this.situacao = entity.getSituacao();
		this.equipamento = entity.getEquipamento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

}
