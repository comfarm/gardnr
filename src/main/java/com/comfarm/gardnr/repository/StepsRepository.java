package com.comfarm.gardnr.repository;

import com.comfarm.gardnr.domain.Steps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepsRepository extends JpaRepository<Steps,Long> {


}
