package com.comfarm.gardnr.repository;

import com.comfarm.gardnr.domain.Wiki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WikiRepository extends JpaRepository<Wiki,Long>{

    Wiki findById(Long wikiId);

    List<Wiki> findByItemId(Long itemId);
}
