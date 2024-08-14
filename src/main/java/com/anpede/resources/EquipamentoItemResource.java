package com.anpede.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anpede.dto.EquipamentoItemDTO;
import com.anpede.services.EquipamentoItemService;

@RestController
@RequestMapping(value = "/equipamento_item")
public class EquipamentoItemResource {
	
	@Autowired
	private EquipamentoItemService service;
	
	@GetMapping
	public ResponseEntity<List<EquipamentoItemDTO>> findAll(){
		List<EquipamentoItemDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}







