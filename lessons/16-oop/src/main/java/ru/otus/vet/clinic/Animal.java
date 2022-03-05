package ru.otus.vet.clinic;

public class Animal {
    protected String food;
    protected String nickName;
    protected String typeOfAnimal;

    public Animal(String nickName) {
        this.nickName = nickName;
    }


    protected void eat() {
        System.out.println("I'm eating ");
    }

    protected void makeNoise() {
        System.out.println("Uhr-r-r-r-r-r");
    }

    public String getFood() {
        return this.food;
    }

}
