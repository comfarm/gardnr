package com.comfarm.gardnr.repository;

import com.comfarm.gardnr.domain.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone,Long>{

    List<Milestone> findByWikiId(long wikiID);
}
