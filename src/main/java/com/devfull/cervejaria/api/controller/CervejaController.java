package com.devfull.cervejaria.api.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfull.cervejaria.api.entity.Cerveja;
import com.devfull.cervejaria.api.response.Response;
import com.devfull.cervejaria.api.service.CervejarService;

@RestController
@RequestMapping("/api/cervejas")
@CrossOrigin("*")
public class CervejaController {

	@Autowired
	private CervejarService service;

	@PostMapping
	public ResponseEntity<Response<Cerveja>> create(HttpServletRequest request, @RequestBody Cerveja cerveja,
			BindingResult result) {

		Response<Cerveja> response = new Response<Cerveja>();

		Cerveja cervejaPersistida = service.create(cerveja);
		response.setData(cervejaPersistida);

		return ResponseEntity.ok(response);
	}

	@GetMapping (value = "/{page}/{count}")
	public ResponseEntity<Response<Page<Cerveja>>> findAll(@PathVariable int page, @PathVariable int count){
		Response<Page<Cerveja>> response = new Response<Page<Cerveja>>();
		Page<Cerveja> cervejas = service.findAll(page, count);
		response.setData(cervejas);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping (value = "{id}")
	public ResponseEntity<Response<Optional<Cerveja>>> findById(@PathVariable("id") Long id){
		Response<Optional<Cerveja>> response = new Response<Optional<Cerveja>>();
		Optional<Cerveja> cervejas = service.findById(id);
		response.setData(cervejas);
		return ResponseEntity.ok(response);
	}
	
	public CervejarService getService() {
		return service;
	}

	public void setService(CervejarService service) {
		this.service = service;
	}
	
	
}
