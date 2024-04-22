package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.model.Stage;
import com.enicarthage.servicedestage.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;

    public Stage getStageById(Long id) {
        return stageRepository.findById(id).orElse(null);
    }

    public Stage createStage(Stage stage) {
        return stageRepository.save(stage);
    }

    public Stage updateStage(Long id, Stage stage) {
        if (stageRepository.existsById(id)) {
            stage.setId(id);
            return stageRepository.save(stage);
        }
        return null;
    }

    public void deleteStage(Long id) {
        stageRepository.deleteById(id);
    }

    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }
}
