package com.devfull.cervejaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfull.cervejaria.api.entity.Cerveja;

public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

}
