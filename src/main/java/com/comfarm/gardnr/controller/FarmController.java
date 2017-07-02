package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.domain.Progress;
import com.comfarm.gardnr.domain.Tanim;
import com.comfarm.gardnr.dto.PlantDto;
import com.comfarm.gardnr.dto.ProgressDto;
import com.comfarm.gardnr.dto.SaveProgressDto;
import com.comfarm.gardnr.dto.StartPlantDto;
import com.comfarm.gardnr.mapper.ProgressDomainToDto;
import com.comfarm.gardnr.service.FarmService;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Controller
public class FarmController implements FarmApi {
    @Autowired
    private FarmService farmService;

//    @Autowired
//    private final StorageService storageService;

//    public FarmController(StorageService storageService) {
//        this.storageService = storageService;
//    }


    @Override
    public ResponseEntity<PlantDto> startPlanting(@RequestBody StartPlantDto request, BindingResult bindingResult) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        Tanim tanim = mapper.map(request, Tanim.class);
        Tanim saved = farmService.start(request);
        PlantDto dto = mapper.map(saved, PlantDto.class);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

//    @Override
//    public ResponseEntity<Set<ProgressDto>> getAllProgress(long tanimId) {
//        Set<ProgressDto> progressSet = farmService.getTanimProgress(tanimId);
//        return new ResponseEntity<>(progressSet, HttpStatus.CREATED);
//    }

//    @Override
//    public ResponseEntity<ProgressDto> saveProgress(@RequestBody SaveProgressDto request, BindingResult bindingResult) {
//        ModelMapper mapper=new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        mapper.addConverter(new ProgressDomainToDto());
//        Progress newProgress=mapper.map(request,Progress.class);
//        Progress savedProgress=farmService.saveProgress(request.getTanimId(),newProgress);
//        ProgressDto dto=mapper.map(savedProgress,ProgressDto.class);
//        return new ResponseEntity<>(dto,HttpStatus.CREATED);
//    }

//    @Override
//    public ResponseEntity<ProgressDto> saveProgressWithImage(@ApiParam(value = "Save progress", required = true) @ModelAttribute SaveProgressDto request, final @RequestPart(value = "file", required = false) MultipartFile file, BindingResult bindingResult) {
//        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        mapper.addConverter(new ProgressDomainToDto());
//        Progress newProgress = mapper.map(request, Progress.class);
////        storageService.store(file);
//        Progress savedProgress = farmService.saveProgress(newProgress);
//        ProgressDto dto = mapper.map(savedProgress, ProgressDto.class);
//        return new ResponseEntity<>(dto, HttpStatus.CREATED);
//    }

}
