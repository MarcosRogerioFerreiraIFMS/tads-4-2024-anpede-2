package com.anpede.entities;

import java.io.Serializable;
import java.util.Objects;

import com.anpede.entities.enums.Situacao;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_equipamento_item")
public class EquipamentoItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String numeroSerie;
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	@ManyToOne
	private Equipamento equipamento;
	
	public EquipamentoItem() {
		// TODO Auto-generated constructor stub
	}
	
	public EquipamentoItem(Long id, String numeroSerie, Situacao situacao) {		
		this.id = id;
		this.numeroSerie = numeroSerie;
		this.situacao = situacao;
	}

	public EquipamentoItem(Long id, String numeroSerie, Situacao situacao, Equipamento equipamento) {
		super();
		this.id = id;
		this.numeroSerie = numeroSerie;
		this.situacao = situacao;
		this.equipamento = equipamento;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipamentoItem other = (EquipamentoItem) obj;
		return Objects.equals(id, other.id);
	}	

}



