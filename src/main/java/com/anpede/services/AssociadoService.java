package com.anpede.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		/*
		List<Associado> list = repository.findAll();		
		List<AssociadoDTO> listDTO = new ArrayList<>();
		
		for(Associado a : list) {
			listDTO.add(new AssociadoDTO(a));
		}
				
		return listDTO;
		*/
		//Lista utilizando Lambdas
		/*
		List<Associado> list = repository.findAll();
		List<AssociadoDTO> listDTO = list.stream()
										 .map(a -> new AssociadoDTO(a))
										 .collect(Collectors.toList());
		
		return listDTO;
		*/
		
		//Lista utilizando Lambdas com retorno direto
		List<Associado> list = repository.findAll();
		return list.stream().map(a -> new AssociadoDTO(a)).collect(Collectors.toList());		
	}

	@Transactional(readOnly = true)
	public AssociadoDTO findById(Long id) {
		Optional<Associado> obj = repository.findById(id);
		Associado a = obj.get();
		return new AssociadoDTO(a);
	}
	
	
	
	
	
	
	

}
