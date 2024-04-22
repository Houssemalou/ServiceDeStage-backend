package com.enicarthage.servicedestage.controller;

import com.enicarthage.servicedestage.model.Stage;
import com.enicarthage.servicedestage.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping("/{id}")
    public Stage getStageById(@PathVariable Long id) {
        return stageService.getStageById(id);
    }

    @PostMapping("/create")
    public Stage createStage(@RequestBody Stage stage) {
        return stageService.createStage(stage);
    }

    @PutMapping("/{id}")
    public Stage updateStage(@PathVariable Long id, @RequestBody Stage stage) {
        return stageService.updateStage(id, stage);
    }

    @DeleteMapping("/{id}")
    public void deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
    }

    @GetMapping("/all")
    public List<Stage> getAllStages() {
        return stageService.getAllStages();
    }
}
