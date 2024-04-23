package com.api.rpfood.repositories;

import com.api.rpfood.models.Acai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaiRepository extends JpaRepository<Acai, Long> {


}