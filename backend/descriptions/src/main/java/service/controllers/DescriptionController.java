package service.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import service.descriptions.DescriptionRepository;
import service.descriptions.HotelDescription;

@RestController
public class DescriptionController {

    @Autowired
    DescriptionRepository descriptionRepo;
    @GetMapping(value = "/descriptions", produces = "application/json")
    public ResponseEntity<ArrayList<HotelDescription>> getDescriptions() {
        ArrayList<HotelDescription> list = new ArrayList<>();
        for (HotelDescription description : descriptionRepo.findAll()) {
            list.add(description);
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/descriptions/{id}", produces = { "application/json" })
    public ResponseEntity<HotelDescription> getDescription(@PathVariable String id) {
        HotelDescription description = descriptionRepo.findDescriptionByID(id);
        if (description == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(description);
    }
    
}
