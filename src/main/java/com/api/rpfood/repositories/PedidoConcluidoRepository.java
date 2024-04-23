package com.api.rpfood.repositories;


import com.api.rpfood.models.PedidoConcluido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoConcluidoRepository extends JpaRepository<PedidoConcluido,Long> {

}
