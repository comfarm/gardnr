package com.comfarm.gardnr.service;

import com.comfarm.gardnr.domain.Progress;
import com.comfarm.gardnr.domain.Tanim;
import com.comfarm.gardnr.repository.ProgressRepository;
import com.comfarm.gardnr.repository.TanimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {
    @Autowired
    private TanimRepository tanimRepository;

    @Autowired
    private ProgressRepository progressRepository;

    public Tanim start(Tanim tanim) {
        return tanimRepository.save(tanim);
    }

    public Progress saveProgress(Long tanimId, Progress newProgress) {
        Tanim tanim=tanimRepository.getOne(tanimId);
        newProgress.setTanim(tanim);
        return progressRepository.save(newProgress);
    }
}
