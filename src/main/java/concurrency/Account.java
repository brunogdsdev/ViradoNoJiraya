package concurrency;

public class Account {
    private int balance = 50;

    public void withDrawl(int amount){
        this.balance -= amount;
    }



//    public Account(int balance) {
//        this.balance = balance;
//    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
