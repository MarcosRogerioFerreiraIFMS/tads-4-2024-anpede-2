package com.anpede.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anpede.dto.AssociadoDTO;
import com.anpede.entities.Associado;
import com.anpede.repositories.AssociadoRepository;


@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository repository;
	
	@Transactional(readOnly = true)
	public List<AssociadoDTO> findAll(){
		
		List<Associado> list = repository.findAll();		
		List<AssociadoDTO> listDTO = new ArrayList<>();
		
		for(Associado a : list) {
			listDTO.add(new AssociadoDTO(a));
		}
				
		return listDTO;
	}
	
	
	
	
	

}
