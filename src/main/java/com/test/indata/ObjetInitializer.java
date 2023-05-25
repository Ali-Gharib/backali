package com.test.indata;

import com.test.indata.entities.ObjectModel;
import com.test.indata.repositories.ObjectRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class ObjetInitializer implements ApplicationRunner {
    private final ObjectRepository objetRepository;

    public ObjetInitializer(ObjectRepository objetRepository) {
        this.objetRepository = objetRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("objet.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ObjectModel objet = new ObjectModel();
                objet.setNom(data[0]);
                objet.setDescription(data[1]);
                objetRepository.save(objet);
            }
        }
    }
}
