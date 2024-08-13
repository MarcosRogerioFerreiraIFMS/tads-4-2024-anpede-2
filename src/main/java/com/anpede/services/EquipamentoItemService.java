package com.anpede.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anpede.dto.EquipamentoItemDTO;
import com.anpede.entities.EquipamentoItem;
import com.anpede.repositories.EquipamentoItemRepository;

@Service
public class EquipamentoItemService {
	
	@Autowired
	private EquipamentoItemRepository repository;
	
	@Transactional(readOnly = true)
	public List<EquipamentoItemDTO> findAll(){				
		List<EquipamentoItem> list = repository.findAll();
		return list.stream().map(e -> new EquipamentoItemDTO(e)).collect(Collectors.toList());		
	}

}
