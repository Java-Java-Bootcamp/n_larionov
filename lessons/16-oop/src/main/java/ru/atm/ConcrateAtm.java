package ru.atm;

import java.util.List;

public class ConcrateAtm implements Atm {
    final List<MoneyCell> moneyCells;

    public ConcrateAtm(List<MoneyCell> moneyCells) {
        this.moneyCells = moneyCells;
    }

    @Override
    public void withDraw(int value, AccountState accountState) throws Exception {
        int atmBalance = 0;
        if (accountState.getAmount() < value) {
            throw new Exception("Overlimit");
        }
        for (MoneyCell moneyCell : moneyCells) {
            atmBalance += moneyCell.getBanknotsNumber() * moneyCell.getDenomination().getValue();
        }
        if (value > atmBalance) {
            throw new Exception("Not enough money");
        }
        accountState.setAmount(accountState.getAmount() - value);
        // Something change banknots number in cell;
    }

    @Override
    public void depositMoney(Denomination denomination, int limit, AccountState accountState) throws Exception {
        for (MoneyCell moneyCell : moneyCells) {
            if (moneyCell.getDenomination() == denomination) {

                if (moneyCell.canPut(limit)) {

                    accountState.setAmount(accountState.getAmount() + limit * denomination.getValue());
                    moneyCell.putMoney(limit);
                } else {
                    throw new Exception("You can't add money");
                }
            }
        }

    }

}
