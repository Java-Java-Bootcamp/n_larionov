package ru.otus.vet.clinic;

public class Dog extends Animal {
    public Dog(String nickName) {
        super(nickName);
        this.food = "meat";
        this.typeOfAnimal = "dog";
    }

    @Override
    protected void eat() {
        System.out.println(typeOfAnimal + " eating " + this.food);
    }

    @Override
    protected void makeNoise() {
        System.out.println(this.nickName + " gav-gav");
    }

}
