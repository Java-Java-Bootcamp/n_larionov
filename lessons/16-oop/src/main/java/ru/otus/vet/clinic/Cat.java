package ru.otus.vet.clinic;

public class Cat extends Animal {
    public Cat(String nickName) {
        super(nickName);
        this.food = "meat";
        this.typeOfAnimal = "cat";
    }

    @Override
    protected void eat() {
        System.out.println("I'm eating fish");
    }

    @Override
    protected void makeNoise() {
        System.out.println(this.nickName + " Meow");
    }
}
