package com.api.rpfood.repositories;

import com.api.rpfood.models.Pastel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastelRepository extends JpaRepository<Pastel,Integer> {
}
