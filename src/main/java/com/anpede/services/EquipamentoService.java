package com.anpede.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anpede.dto.EquipamentoDTO;
import com.anpede.entities.Equipamento;
import com.anpede.repositories.EquipamentoRepository;
import com.anpede.services.exceptions.DataBaseException;
import com.anpede.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


@Service
public class EquipamentoService {
	
	@Autowired
	private EquipamentoRepository repository;
	
	@Transactional(readOnly = true)
	public List<EquipamentoDTO> findAll(){				
		List<Equipamento> list = repository.findAll();
		return list.stream().map(e -> new EquipamentoDTO(e)).collect(Collectors.toList());		
	}

	@Transactional(readOnly = true)
	public EquipamentoDTO findById(Long id) {
		Optional<Equipamento> obj = repository.findById(id);
		Equipamento entity = obj.orElseThrow(() -> 
			new ResourceNotFoundException("O registro não localizado na base de dados"));
		return new EquipamentoDTO(entity);
	}
	
	@Transactional
	public EquipamentoDTO insert(EquipamentoDTO dto) {
		Equipamento entity = new Equipamento();
		converterDtoEmEntidade(dto, entity);					
		entity = repository.save(entity);
		return new EquipamentoDTO(entity);
	}
	
	@Transactional
	public EquipamentoDTO update(Long id, EquipamentoDTO dto) {
		try {
			
			Equipamento entity = repository.getReferenceById(id);
			converterDtoEmEntidade(dto, entity);
				
			entity = repository.save(entity);
			return new EquipamentoDTO(entity);
			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID "+id
					+" não foi localizado");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O recurso com o ID "+id
					+" não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de Integride, "
					+ "você não pode excluir este arquivo.");
		}
	}

	private void converterDtoEmEntidade(EquipamentoDTO dto, Equipamento entity) {
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setMarca(dto.getMarca());
		entity.setCategoria(dto.getCategoria());
		entity.setFoto(dto.getFoto());
		entity.setValor(dto.getValor());
		entity.setQuantidade(dto.getQuantidade());		
	}
	
	
	
	
	
	
	

}
