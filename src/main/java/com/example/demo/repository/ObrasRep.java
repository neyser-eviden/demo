package com.example.demo.repository;

import com.example.demo.model.Obras;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ObrasRep extends JpaRepository<Obras, Integer>{
	@Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM Historial WHERE ID_obra = :ID_obra")
    void deleteHistorialByIdObra(@Param("ID_obra") int ID_obra);
}
