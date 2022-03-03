package ru.atm;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String... args) {
		try {
			List<MoneyCell> moneyCellList = new ArrayList<>();
			moneyCellList.add(new FiftyMoneyCell(100, Denomination.FIFTY, 10));
			Atm atm = new ConcrateAtm(moneyCellList);
			AccountState accountState = new AccountState();
			accountState.setAmount(1000);
			accountState.printState();
			atm.depositMoney(Denomination.FIFTY, 50, accountState);
			accountState.printState();
			atm.withDraw(100000, accountState);
			accountState.printState();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
