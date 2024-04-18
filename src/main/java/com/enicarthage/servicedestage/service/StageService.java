package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import com.enicarthage.servicedestage.repository.StageRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;

    public Stage saveStage(Stage stage) {
        return stageRepository.save(stage);
    }

    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    public Optional<Stage> getStageById(Long id) {
        return stageRepository.findById(id);
    }

    public void deleteStage(Long id) {
        stageRepository.deleteById(id);
    }
}
