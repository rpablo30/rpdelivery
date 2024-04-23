package com.api.rpfood.repositories;

import com.api.rpfood.models.Picole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicoleRepository extends JpaRepository<Picole , Long> {


}
