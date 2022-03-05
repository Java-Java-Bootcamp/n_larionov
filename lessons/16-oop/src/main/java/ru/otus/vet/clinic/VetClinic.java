package ru.otus.vet.clinic;

import java.util.ArrayList;
import java.util.List;

public class VetClinic {
    public static void main(String[] args) {
        Dog rex = new Dog();
        Cat murka = new Cat();

        List<Animal> animals = new ArrayList<>();
        animals.add(rex);
        animals.add(murka);

        for (Animal animal : animals) {
            animal.makeNoise();
        }


    }
}
