package com.api.rpfood.repositories;

import com.api.rpfood.models.Pudim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PudimRepository extends JpaRepository<Pudim, Long> {
}
