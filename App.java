import src.Account;
import src.Bank;

public class App {
    public static void main(String[] args) {
        Account account = new Account("01", 230000);
        Account account2 = new Account("02", 430000);
        Account account3 = new Account("03", 1430000);

        Bank tPbank = new Bank("TPbank", 0);
        tPbank.addAccount(account);
        tPbank.addAccount(account2);
        tPbank.addAccount(account3);

        System.out.println("money current: " + tPbank.getBalance());

        Thread desAc1 = account.deposit(3000, tPbank); //0
        Thread desAc2 = account2.deposit(3000, tPbank); // 1
        Thread desAc3 = account3.deposit(3000, tPbank); // 2

        desAc1.start();
        desAc2.start();
        desAc3.start();

        try {
            desAc1.join();
            desAc2.join();
            desAc3.join();
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("new money: " + tPbank.getBalance());

    }
}
