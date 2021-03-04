package com.devsuperior.dslearnbd.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.service.NotificationService;

@RestController
@RequestMapping(value = "/notications")
public class NotificationResource {

	@Autowired
	private NotificationService service;
	
	@GetMapping
	// create a list with all categories in it! ReuestParam -> used for pagination!
	public ResponseEntity<Page<NotificationDTO>> findAll(
			@RequestParam(value = "unreadOnly", defaultValue = "") Boolean unreadOnly,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "12") Integer size
			){
		PageRequest pageRequest = PageRequest.of(page, size);

		Page<NotificationDTO> list = service.notificationForCurrentUser(pageRequest, unreadOnly);

		return ResponseEntity.ok().body(list);
	}

}
