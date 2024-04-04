package com.anpede.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anpede.dto.EquipamentoDTO;
import com.anpede.entities.Equipamento;
import com.anpede.repositories.EquipamentoRepository;
import com.anpede.services.exceptions.EntityNotFoundException;


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
			new EntityNotFoundException("O registro não localizado na base de dados"));
		return new EquipamentoDTO(entity);
	}
	
	
	
	
	
	
	

}
