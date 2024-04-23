package com.api.rpfood.repositories;

import com.api.rpfood.models.Salgado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalgadoRepository extends JpaRepository<Salgado, Long> {
}
