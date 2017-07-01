package com.comfarm.gardnr.service;

import com.comfarm.gardnr.domain.*;
import com.comfarm.gardnr.dto.ProgressDto;
import com.comfarm.gardnr.dto.StartPlantDto;
import com.comfarm.gardnr.mapper.ProgressDomainToDto;
import com.comfarm.gardnr.repository.ItemRepository;
import com.comfarm.gardnr.repository.ProgressRepository;
import com.comfarm.gardnr.repository.TanimRepository;
import com.comfarm.gardnr.repository.WikiRepository;
import org.joda.time.LocalDate;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class FarmService {
    @Autowired
    private TanimRepository tanimRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private WikiRepository wikiRepository;

    @Autowired
    private ProgressRepository progressRepository;

    public Tanim start(StartPlantDto start) {
//        get itemid from wikiId
        Wiki wiki = wikiRepository.findById(start.getWikiId());
        Item item = itemRepository.findById(wiki.getItemId());
        Tanim tanim = new Tanim();
        tanim.setUserId(start.getUsername());
        tanim.setItemId(item.getId());
        tanim.setStartDate(new Date());
        tanim = tanimRepository.save(tanim);

//        Set<Progress> progressLst = new HashSet<>();
//        Set<Steps> stepLst = wiki.getSteps();
//        for (Steps step:stepLst) {
//            Progress prog = calculateProgress(step, tanim);
//            progressLst.add(prog);
//        }
//        tanim.setProgress(progressLst);


        return tanim;
    }

    private Progress calculateProgress(Steps step, Tanim tanim) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, step.getCountDays());
        Date date = c.getTime();

        Progress progress = new Progress();
        progress.setProgressDate(date);
        progress.setTitle(step.getTitle());
        progress.setTanim(tanim);
        return progress;
    }

    public Progress saveProgress(Progress newProgress) {
        Progress progress = progressRepository.findById(newProgress.getId());
        progress.setContent(newProgress.getContent());
        progress.setImage(newProgress.getImage());
//        Tanim tanim = tanimRepository.getOne(progress);
//        newProgress.setTanim(tanim);
        return progressRepository.save(newProgress);
    }

    public Set<ProgressDto> getTanimProgress(long tanimId) {
        Tanim tanim = tanimRepository.getOne(tanimId);
        Set<Progress> progressSet = tanim.getProgress();

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Set<ProgressDto> progressDtoSet = new HashSet<>();
        for (Progress progress:progressSet) {
            ProgressDto progressDto = mapper.map(progress, ProgressDto.class);
            progressDtoSet.add(progressDto);
        }
        return progressDtoSet;
    }
}
