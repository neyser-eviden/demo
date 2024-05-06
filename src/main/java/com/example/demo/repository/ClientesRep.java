package com.example.demo.repository;

import com.example.demo.model.Clientes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientesRep extends JpaRepository<Clientes, Integer> {
	
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM Historial WHERE ID_cliente = :ID_cliente")
    void deleteHistorialByIdSocio(@Param("ID_cliente") int ID_cliente);


}
