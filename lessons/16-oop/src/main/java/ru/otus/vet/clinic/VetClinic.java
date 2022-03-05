package ru.otus.vet.clinic;

import java.util.ArrayList;
import java.util.List;

public class VetClinic {
    public static void main(String[] args) {
        Dog rex = new Dog("Buldog");
        Cat murka = new Cat("Murka");


        List<Animal> animals = new ArrayList<>();
        animals.add(rex);
        animals.add(murka);
        animals.add(new Horse("horse"));

        for (Animal animal : animals) {
            if ("meat".equals(animal.getFood())) {
                animal.makeNoise();
            }

        }


    }
}
