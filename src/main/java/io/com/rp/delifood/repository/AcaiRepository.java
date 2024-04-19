package io.com.rp.delifood.repository;

import io.com.rp.delifood.models.Acai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaiRepository extends JpaRepository<Acai, Long> {


}
