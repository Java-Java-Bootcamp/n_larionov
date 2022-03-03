package ru.atm;

public interface MoneyCell {
    void putMoney(int value) throws Exception;

    boolean canPut(int value);

    void getMoney(int value) throws Exception;

    boolean canGet(int value);

    Denomination getDenomination();

    int getBanknotsNumber();

    int getMaxNumber();
}
