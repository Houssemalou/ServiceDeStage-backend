package com.enicarthage.servicedestage.controller;

import com.enicarthage.servicedestage.model.Partenaire;
import com.enicarthage.servicedestage.service.PartenaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partenaires")
public class PartenaireController {

    @Autowired
    private PartenaireService partenaireService;

    @GetMapping("/")
    public List<Partenaire> getAllPartenaires() {
        return partenaireService.getAllPartenaires();
    }

    @GetMapping("/{id}")
    public Optional<Partenaire> getPartenaireById(@PathVariable Long id) {
        return partenaireService.getPartenaireById(id);
    }

    @PostMapping("/")
    public Partenaire addPartenaire(@RequestBody Partenaire partenaire) {
        return partenaireService.savePartenaire(partenaire);
    }

    @PutMapping("/{id}")
    public Partenaire updatePartenaire(@PathVariable Long id, @RequestBody Partenaire partenaire) {
        // Assurez-vous que l'ID dans le corps de la requête correspond à l'ID dans l'URL
        partenaire.setId(id);
        return partenaireService.savePartenaire(partenaire);
    }

    @DeleteMapping("/{id}")
    public void deletePartenaire(@PathVariable Long id) {
        partenaireService.deletePartenaire(id);
    }
}
