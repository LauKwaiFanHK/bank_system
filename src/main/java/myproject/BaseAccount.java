package myproject;

public abstract class BaseAccount {
	private int id;
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

	protected abstract double getCredit();

	protected abstract void setCredit(double d);
}
