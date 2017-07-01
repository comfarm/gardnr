package com.comfarm.gardnr.service;

import com.comfarm.gardnr.domain.Item;
import com.comfarm.gardnr.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ItemService {

    private static final Long VEGETABLE_ID = 1L;
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllVegetables() {
        Long categoryId=VEGETABLE_ID;
        Set<Item> items=itemRepository.findByItemCategoryId(categoryId);
        List<Item> allVegetables=new ArrayList<>(items);
        return allVegetables;
    }
}
