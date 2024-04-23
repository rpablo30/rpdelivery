package com.api.rpfood.repositories;

import com.api.rpfood.models.CachorroQuente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CachorroQuenteRepository extends JpaRepository<CachorroQuente , Integer> {

}
