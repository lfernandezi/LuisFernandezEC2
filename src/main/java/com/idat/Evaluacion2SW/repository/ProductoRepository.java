package com.idat.Evaluacion2SW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Evaluacion2SW.model.Productos;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {

}
