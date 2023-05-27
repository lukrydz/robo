package com.example.robodog.service;

import com.example.robodog.model.Dog;
import com.example.robodog.model.EBreed;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Service
public class DogCreator {

    Random random = new Random();

    private List<String> namesList = new ArrayList<>(List.of("Burek", "Szczepan", "MarekOwczarek", "Zbychu", "Reksio", "Fafik"));

    public Dog createRandomDog() {
        return new Dog(
                getRandomAge(),
                getRandomName(),
                getRandomBreed()
        );
    }

    public Integer getRandomAge() {
        return random.nextInt(50);
    }

    public String getRandomName() {
        return namesList.get(random.nextInt(namesList.size() - 1));
    }

    public EBreed getRandomBreed() {
        EBreed[] values = EBreed.values();
        return values[random.nextInt(values.length - 1)];
    }


}
