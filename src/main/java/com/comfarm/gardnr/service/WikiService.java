package com.comfarm.gardnr.service;

import com.comfarm.gardnr.domain.Checklist;
import com.comfarm.gardnr.domain.ChecklistCategory;
import com.comfarm.gardnr.domain.Steps;
import com.comfarm.gardnr.domain.Wiki;
import com.comfarm.gardnr.repository.ChecklistCategoryRepository;
import com.comfarm.gardnr.repository.ChecklistRepository;
import com.comfarm.gardnr.repository.StepsRepository;
import com.comfarm.gardnr.repository.WikiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WikiService {
    @Autowired
    private WikiRepository wikiRepository;
    @Autowired
    private StepsRepository stepsRepository;
    @Autowired
    private ChecklistRepository checklistRepository;

    @Autowired
    private ChecklistCategoryRepository checklistCategoryRepository;

    public Wiki getWikiById(Long wikiId) {
        Wiki wiki = wikiRepository.findById(wikiId);
        return wiki;
    }

    public Wiki saveWiki(Wiki newWiki) {
        return wikiRepository.save(newWiki);
    }

    public List<Steps> saveSteps(Set<Steps> steps) {
        return stepsRepository.save(steps);
    }

    public List<Checklist> saveChecklists(Set<Checklist> checklists) {
        return checklistRepository.save(checklists);
    }

    public List<Wiki> getAllWiki() {

        return wikiRepository.findAll();
    }

    public ChecklistCategory getCategoryById(Long categoryId) {
        return checklistCategoryRepository.getOne(categoryId);
    }

    public List<Wiki> getAllWikiByItemId(Long itemId) {
        return wikiRepository.findByItemId(itemId);
    }
}
