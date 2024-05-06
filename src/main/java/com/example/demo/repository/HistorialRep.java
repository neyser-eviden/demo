package com.example.demo.repository;

import com.example.demo.model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HistorialRep extends JpaRepository<Historial, Integer> {

}
