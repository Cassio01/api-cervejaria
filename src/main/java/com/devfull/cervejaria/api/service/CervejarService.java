package com.devfull.cervejaria.api.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devfull.cervejaria.api.entity.Cerveja;
import com.devfull.cervejaria.api.repository.CervejaRepository;

@Service
public class CervejarService {

	@Autowired
	private CervejaRepository repository;

	public Cerveja create(Cerveja cerveja) {
		return this.repository.save(cerveja);
	}
	
//	public List<Cerveja> findAll(){
//		return this.repository.findAll();
//	}
	
	public Optional<Cerveja> findById(Long id) {
		return this.repository.findById(id);
	}
	
	public Page<Cerveja> findAll(int page, int count){
		Pageable pages = PageRequest.of(page, count);
		return this.repository.findAll(pages);
	}

	public CervejaRepository getRepository() {
		return repository;
	}

	public void setRepository(CervejaRepository repository) {
		this.repository = repository;
	}
}
