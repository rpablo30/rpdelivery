package com.api.rpfood.repositories;

import com.api.rpfood.models.Pedidos;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos,Long> {

    List<Pedidos> findByStatus(String status);

    // Outro exemplo usando uma consulta JPQL
    @Query("SELECT p FROM Pedidos p WHERE p.status = :status")
    List<Pedidos> buscarPorStatus(@Param("status") String status);

}
