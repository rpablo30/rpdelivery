package com.api.rpfood.repositories;

import com.api.rpfood.models.Refrigerante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefrigeranteRepository extends JpaRepository<Refrigerante,Long> {
    Page<Refrigerante> findAll(Pageable pageable);

}
