package com.comfarm.gardnr.repository;

import com.comfarm.gardnr.domain.ChecklistCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistCategoryRepository extends JpaRepository<ChecklistCategory,Long>{
}
