package ru.atm;

public class FiftyMoneyCell implements MoneyCell {
    private int banknotesNumber;
    private int maxNumber;
    private Denomination denomination;

    public FiftyMoneyCell(int maxNumber, Denomination denomination, int banknotesNumber) {
        this.maxNumber = maxNumber;
        this.denomination = denomination;
        this.banknotesNumber = banknotesNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public void putMoney(int value) throws Exception {
        if (canPut(value)) {
            banknotesNumber += value;
        } else {
            throw new Exception("Cell overload");
        }

    }

    @Override
    public boolean canPut(int value) {
        return value + banknotesNumber <= maxNumber;
    }

    @Override
    public void getMoney(int value) throws Exception {

        if (value <= banknotesNumber) {
            banknotesNumber -= value;
        } else {
            throw new Exception("Not enough banknots");
        }
    }

    @Override
    public boolean canGet(int value) {
        return value <= banknotesNumber;
    }

    @Override
    public Denomination getDenomination() {
        return Denomination.FIFTY;
    }

    @Override
    public int getBanknotsNumber() {
        return banknotesNumber;
    }
}
