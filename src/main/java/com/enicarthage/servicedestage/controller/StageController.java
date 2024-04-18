package com.enicarthage.servicedestage.controller;

import com.enicarthage.servicedestage.model.Stage;
import com.enicarthage.servicedestage.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping("/")
    public List<Stage> getAllStages() {
        return stageService.getAllStages();
    }

    @GetMapping("/{id}")
    public Optional<Stage> getStageById(@PathVariable Long id) {
        return stageService.getStageById(id);
    }

    @PostMapping("/")
    public Stage addStage(@RequestBody Stage stage) {
        return stageService.saveStage(stage);
    }

    @PutMapping("/{id}")
    public Stage updateStage(@PathVariable Long id, @RequestBody Stage stage) {
        // Assurez-vous que l'ID dans le corps de la requête correspond à l'ID dans l'URL
        stage.setId(id);
        return stageService.saveStage(stage);
    }

    @DeleteMapping("/{id}")
    public void deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
    }
}
