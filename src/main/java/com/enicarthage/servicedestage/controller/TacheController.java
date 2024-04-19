package com.enicarthage.servicedestage.controller;

import com.enicarthage.servicedestage.model.Tache;
import com.enicarthage.servicedestage.service.TacheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/tache"})
public class TacheController {
    private final TacheService tacheService ;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }
    @GetMapping({"/all"})
    public ResponseEntity<List<Tache>> getAllTaches() {
        List<Tache> taches = this.tacheService.findAllTaches() ;
        return new ResponseEntity(taches, HttpStatus.OK) ;
    }

    @GetMapping({"/find/{id}"})
    public ResponseEntity<Tache> getTacheById(@PathVariable("id") Long id) {
        Tache tache = this.tacheService.findTacheById(id) ;
        return new ResponseEntity(tache,HttpStatus.OK) ;
    }

    @PostMapping({"/add"})
    public ResponseEntity<Tache> addTache(@RequestBody Tache tache) {
        Tache newtache = this.tacheService.addTache(tache) ;
        return new ResponseEntity(newtache,HttpStatus.CREATED) ;
    }

    @PutMapping({"/update"})
    public ResponseEntity<Tache> updateTache(@RequestBody Tache tache) {
        Tache updateTache = this.tacheService.updateTache(tache);
        return new ResponseEntity(updateTache,HttpStatus.OK) ;
    }
    @DeleteMapping({"/delete/{id}"})
    public ResponseEntity<?> deleteTache(@PathVariable("id") Long id) {
        try {
            this.tacheService.deleteTache(id);
            return new ResponseEntity(HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity("echec de supprimer la tache par id :" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
