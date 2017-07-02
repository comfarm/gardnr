package com.comfarm.gardnr.controller;

import com.comfarm.gardnr.domain.Milestone;
import com.comfarm.gardnr.domain.Tanim;
import com.comfarm.gardnr.dto.MilestoneDto;
import com.comfarm.gardnr.dto.PlantProgressDto;
import com.comfarm.gardnr.dto.PlantProgressItemDto;
import com.comfarm.gardnr.dto.ProgressDto;
import com.comfarm.gardnr.service.FarmService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class TanimController implements TanimApi {

    @Autowired
    FarmService farmService;

    @ResponseBody
    @Override
    public List<PlantProgressItemDto> plantProgresss(@ApiParam(value = "Get all progress", required = true) @PathVariable("tanimId") long tanimId) {
        PlantProgressDto result=new PlantProgressDto();
//        result.setPlantProgressLists(getPlantProgressList(tanimId));
        return getPlantProgressList(tanimId);
    }

    private List<PlantProgressItemDto> getPlantProgressList(Long tanimId) {
        Tanim tanim=farmService.getTanim(tanimId);
        List<PlantProgressItemDto> plantProgressList=new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.setTime(tanim.getStartDate());
        List<Milestone> milestoneList=farmService.getMilestoneByWikiId(1L);
        for(int x=0;x<=72;x++) {
            c.add(Calendar.DATE, 1);
            PlantProgressItemDto day1Prog = new PlantProgressItemDto();
            day1Prog.setDate(c.getTime());
            for(Milestone m:milestoneList){
                if(m.getDayNum()==x){
                    MilestoneDto milestone=new MilestoneDto();
                    milestone.setContent(m.getContent());
                    milestone.setTitle(m.getTitle());
                    milestone.setImage(m.getImage());
                    milestone.setDayNum(m.getDayNum());
                    milestone.setDate(c.getTime());
                    day1Prog.setMilestoneDto(milestone);
                }
            }
            ProgressDto progress=new ProgressDto();
            progress.setContent("asdasd");
            day1Prog.setProgressDto(progress);
            plantProgressList.add(day1Prog);
        }
        return plantProgressList;
    }
}
