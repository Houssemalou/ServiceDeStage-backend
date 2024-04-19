package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.exception.TacheNotFoundException;
import com.enicarthage.servicedestage.model.Tache;
import com.enicarthage.servicedestage.repository.TacheRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheService {
    private  final TacheRepo tacheRepo ;

    @Autowired
    public TacheService(TacheRepo tacheRepo) {
        this.tacheRepo = tacheRepo;
    }

    public Tache addTache(Tache tache) {
        return(Tache)this.tacheRepo.save(tache);
    }

    public Tache updateTache(Tache tache) {
        return (Tache)this.tacheRepo.save(tache) ;
    }

    public List<Tache> findAllTaches() {
        return tacheRepo.findAll() ;
    }

    public Tache findTacheById(Long id){
        return (Tache)this.tacheRepo.findTacheById(id).orElseThrow(() -> {
            return new TacheNotFoundException("User par id " + id + "nest pas trouve") ;
        }) ;
    };

    public void deleteTache(Long id) {
        this.tacheRepo.deleteTacheRepoById(id);
    }


}
