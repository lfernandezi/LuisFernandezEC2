package com.idat.Evaluacion2SW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Evaluacion2SW.model.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

}
