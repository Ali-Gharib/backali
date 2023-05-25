package com.test.indata.controllers;

import com.test.indata.entities.ObjectModel;
import com.test.indata.repositories.ObjectRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objets")
@Api(tags = "Objet API")
public class ObjetController {
    private final ObjectRepository objetRepository;

    public ObjetController( ObjectRepository objetRepository) {
        this.objetRepository = objetRepository;
    }

    @GetMapping
    @ApiOperation("Get all objets")
    public List<ObjectModel> getAllObjets() {
        return objetRepository.findAll();
    }

    @PostMapping
    @ApiOperation("Add an objet")
    public ObjectModel addObjet(@RequestBody ObjectModel objet) {
        return objetRepository.save(objet);
    }

    @PostMapping("/aleatoire")
    @ApiOperation("Add an objet with random values")
    public ObjectModel addObjetAleatoire() {

        ObjectModel objet = new ObjectModel();
        objet.setNom("Random Name");
        objet.setDescription("Random Description");
        return objetRepository.save(objet);
    }
}
