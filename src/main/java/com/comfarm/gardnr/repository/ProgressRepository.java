package com.comfarm.gardnr.repository;

import com.comfarm.gardnr.domain.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress,Long>{
    Progress findById(Long id);
}
