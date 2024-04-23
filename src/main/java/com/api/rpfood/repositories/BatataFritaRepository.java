package com.api.rpfood.repositories;

import com.api.rpfood.models.Batatafrita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatataFritaRepository extends JpaRepository<Batatafrita , Long> {
}
