package com.comfarm.gardnr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class WikiListDto {

    private List<WikiListItemDto> wiki=new ArrayList<WikiListItemDto>();
}
