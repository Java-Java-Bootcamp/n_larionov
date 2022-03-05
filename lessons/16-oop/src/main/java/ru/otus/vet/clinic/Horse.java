package ru.otus.vet.clinic;

public class Horse extends Animal {
    public Horse(String nickName) {
        super(nickName);
        this.typeOfAnimal = "horse";
        this.food = "grass";
    }

    @Override
    protected void eat() {
        System.out.println(typeOfAnimal + " eating " + this.food);
    }

    @Override
    protected void makeNoise() {
        System.out.println(this.nickName + " ye-ho-ho");
    }
}
