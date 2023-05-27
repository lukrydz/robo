package com.example.robodog.controller;

import com.example.robodog.model.Dog;
import com.example.robodog.service.DogStorage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {
    private final DogStorage dogStorage;


    public DogController(DogStorage dogStorage) {
        this.dogStorage = dogStorage;
    }

    @GetMapping()
    public List<Dog> getDogs() {
        return dogStorage.getDogList();
    }

    @GetMapping("/random")
    public Dog getRandomDog() {
        return dogStorage.addRandomDog();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createDog(@RequestBody Dog dog) {
        dogStorage.addDog(dog);
    }

    @PutMapping("/{name}")
    public void updateDog(@RequestBody Dog dog, @PathVariable String name) {
        dogStorage.updateDogByName(name, dog.getAge(), dog.getEBreed());
    }
}
