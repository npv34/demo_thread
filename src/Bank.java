package src;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private double balance;
    private List<Account> listAccount;

    public Bank(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.listAccount = new ArrayList<>();
    }

    public void addAccount(Account account) {
        balance += account.getBalance();
        listAccount.add(account);
    }

    public void removeAccount(String id) throws Exception {
        Account account = findAccountById(id);
        if (account == null) {
            throw new Exception("Account not found");
        }
        balance -= account.getBalance();
        listAccount.remove(account);
    }

    public Account findAccountById(String id) {
        for (Account account : listAccount) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double money) {
        balance += money;
    }
}
