package service.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    private HotelDescription hotelDescription;


/*     @GetMapping(value="/descriptions", produces="application/json")
    public ResponseEntity<ArrayList<String>>  descriptions() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(descriptionRepo.findAll());
    } */

    @GetMapping(value = "/descriptions/{id}", produces = { "application/json" })
    public ResponseEntity<HotelDescription> getDescription(@PathVariable String id) {
        HotelDescription description = descriptionRepo.findDescriptionByID(id);
        if (description == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(description);
    }
    
}
