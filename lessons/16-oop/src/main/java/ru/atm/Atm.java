package ru.atm;

public interface Atm {
    void withDraw(int value, AccountState accountState) throws Exception;

    void depositMoney(Denomination denomination, int limit, AccountState accountState) throws Exception;

}
