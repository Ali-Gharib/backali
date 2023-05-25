package com.test.indata.services;

import com.test.indata.entities.ObjectModel;
import com.test.indata.repositories.ObjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ObjetService {
    private final ObjectRepository objetRepository;

    public ObjetService(ObjectRepository objetRepository) {
        this.objetRepository = objetRepository;
    }

    public ObjectModel getObjetById(Long id) {
        return objetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Objet not found with id: " + id));
    }

    public List<ObjectModel> getAllObjets() {
        return objetRepository.findAll();
    }

    public ObjectModel createObjet(ObjectModel objet) {
        return objetRepository.save(objet);
    }

    public ObjectModel updateObjet(Long id, ObjectModel updatedObjet) {
        ObjectModel existingObjet = objetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Objet not found with id: " + id));

        existingObjet.setNom(updatedObjet.getNom());
        existingObjet.setDescription(updatedObjet.getDescription());

        return objetRepository.save(existingObjet);
    }

    public void deleteObjet(Long id) {
        ObjectModel existingObjet = objetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Objet not found with id: " + id));

        objetRepository.delete(existingObjet);
    }
}
