package com.comfarm.gardnr.mapper;

import com.comfarm.gardnr.domain.Item;
import com.comfarm.gardnr.dto.ItemDto;
import org.modelmapper.AbstractConverter;

public class ItemConverter extends AbstractConverter<Item, ItemDto> {

    @Override
    protected ItemDto convert(Item item) {
        ItemDto dto = new ItemDto();
        dto.setCategory(item.getItemCategory().getName());
        dto.setDescription(item.getDescription());
        dto.setName(item.getName());
        dto.setId(item.getId());
        return dto;
    }
}
