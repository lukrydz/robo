package com.example.robodog.service;

import com.example.robodog.model.Dog;
import com.example.robodog.model.EBreed;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
public class DogStorage {
    private final DogCreator dogCreator;

    public DogStorage(DogCreator dogCreator) {
        this.dogCreator = dogCreator;
    }

    private List<Dog> dogList = new ArrayList<>();

    public void addDog(Dog dog) {
        dogList.add(dog);
    }

    ;

    public Dog addRandomDog() {
        Dog dog = dogCreator.createRandomDog();
        addDog(dog);
        return dog;
    }

    public List<Dog> getDogList() {
        return dogList.stream()
                .sorted(Comparator.comparing(Dog::getName))
                        .collect(Collectors.toList());
    }

    public Dog updateDogByName(String name, int age, EBreed ebreed) {
        Dog foundDog = getDogList().stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Not found"));

        foundDog.setAge(age);
        foundDog.setEBreed(ebreed);

        return foundDog;
    }

    ;

}
