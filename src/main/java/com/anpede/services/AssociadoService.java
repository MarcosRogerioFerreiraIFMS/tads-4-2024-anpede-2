package com.anpede.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anpede.entities.Associado;
import com.anpede.repositories.AssociadoRepository;


@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository repository;
	
	@Transactional(readOnly = true)
	public List<Associado> findAll(){
		return repository.findAll();
	}
	
	

}
