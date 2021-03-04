package com.devsuperior.dslearnbd.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.service.DeliverService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResources {

	@Autowired
	private DeliverService service;
	
	@PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update (@PathVariable Long id, @RequestBody DeliverRevisionDTO dto){
	service.saveRevision(id, dto);
	return ResponseEntity.noContent().build();
	}
}
