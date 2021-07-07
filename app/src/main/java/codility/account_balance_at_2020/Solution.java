package codility.account_balance_at_2020;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

	static class Transaction {

		private final int amount;
		private final LocalDate date;

		public Transaction(int amount, LocalDate date) {
			this.amount = amount;
			this.date = date;
		}

		public int getAmount() {
			return amount;
		}

		public LocalDate getDate() {
			return date;
		}

		public boolean isTransfer() {
			return amount >=0;
		}

		public boolean isCardPayment() {
			return amount <0;
		}

		public boolean is2020() {
			return date.getYear() == 2020;
		}
	}

	public int solution(int[] A, String[] D) {
		List<Transaction> transactions = parseTransactions(A, D)
				.stream()
				.filter(Transaction::is2020)
				.collect(Collectors.toList());

		int income = transactions.stream()
				.filter(Transaction::isTransfer)
				.mapToInt(Transaction::getAmount)
				.sum();

		int expenditure = -transactions.stream()
				.filter(Transaction::isCardPayment)
				.mapToInt(Transaction::getAmount)
				.sum();

		int monthsWithoutFee = numberOfMonthsWithAtLeast3Transactions(transactions);
		int fee = (12 - monthsWithoutFee) * 5;
		return income - expenditure - fee;
	}

	private int numberOfMonthsWithAtLeast3Transactions(List<Transaction> transactions) {
		Map<Month, List<Transaction>> transactionsByMonth = transactions.stream()
				.filter(Transaction::isCardPayment)
				.collect(Collectors.groupingBy(t -> t.date.getMonth()));

		return Math.toIntExact(
				transactionsByMonth.values()
						.stream()
						.filter(monthTransactions -> monthTransactions.size() >= 3)
						.filter(monthTransactions -> totalAmount(monthTransactions) >= 100)
						.count());
	}

	private int totalAmount(List<Transaction> value) {
		return -value.stream()
				.mapToInt(Transaction::getAmount)
				.sum();
	}

	private List<Transaction> parseTransactions(int[] amounts, String[] dates) {
		if (amounts.length != dates.length) {
			throw new IllegalArgumentException(
					String.format("Amounts and dates arrays have different length (%d and %d)", amounts.length, dates.length));
		}
		List<Transaction> transactions = new ArrayList<>();
		for (int index = 0; index < amounts.length; index++) {
			int amount = amounts[index];
			LocalDate date = LocalDate.parse(dates[index]);
			transactions.add(new Transaction(amount, date));
		}
		return transactions;
	}
}

