package com.comfarm.gardnr.repository;

import com.comfarm.gardnr.domain.Tanim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TanimRepository extends JpaRepository<Tanim,Long>{

}
