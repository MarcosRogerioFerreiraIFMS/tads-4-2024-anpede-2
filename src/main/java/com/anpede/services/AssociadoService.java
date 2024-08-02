package com.anpede.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anpede.dto.AssociadoDTO;
import com.anpede.entities.Associado;
import com.anpede.repositories.AssociadoRepository;
import com.anpede.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


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
	public Page<AssociadoDTO> findAllPaged(Pageable pageable) {		
		Page<Associado> list = repository.findAll(pageable);		
		return null;
	}
	
	@Transactional(readOnly = true)
	public AssociadoDTO findById(Long id) {
		Optional<Associado> obj = repository.findById(id);
		Associado a = obj.get();
		return new AssociadoDTO(a);
	}

	@Transactional
	public AssociadoDTO insert(AssociadoDTO dto) {
		Associado entity = new Associado();
		converterDtoEmEntidade(dto, entity);
			
		entity = repository.save(entity);
		return new AssociadoDTO(entity);
	}

	private void converterDtoEmEntidade(AssociadoDTO dto, Associado entity) {
		entity.setNome(dto.getNome());
		entity.setCPF(dto.getCPF());
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity.setEndereco(dto.getEndereco());
	}

	@Transactional
	public AssociadoDTO update(Long id, AssociadoDTO dto) {
		try {
			
			Associado entity = repository.getReferenceById(id);			
			converterDtoEmEntidade(dto, entity);				
			entity = repository.save(entity);
			return new AssociadoDTO(entity);
			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID "+id
					+" não foi localizado");
		}
	}
		
	public void delete(Long id) {
		/*try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O recurso com o ID "+id
					+" não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de Integride, "
					+ "você não pode excluir este arquivo.");
		}*/
		
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("O recurso com o ID "+id
					+" não foi localizado");
		}
		repository.deleteById(id);
	}



	

	
	
	
	
	
	
	

}
