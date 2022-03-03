package ru.atm;

public enum Denomination {
    FIFTY(50),
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    THOUSAND(1000),
    TWO_THOUSAND(2000),
    FIVE_THOUSAND(5000);

    public int getValue() {
        return value;
    }

    private int value;

    Denomination(int value) {
        this.value = value;
    }

}
