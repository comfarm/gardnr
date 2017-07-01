package com.comfarm.gardnr.repository;

import com.comfarm.gardnr.domain.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist,Long> {
}
