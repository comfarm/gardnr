package com.comfarm.gardnr.repository;

import com.comfarm.gardnr.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{


    Set<Item> findByItemCategoryId(Long itemCategoryId);
}
