/**
* This class creates a bank account object.
* @author Jacob Schwartz
* @since 2020-10-6
*/
public class BankAccount{

// Variables
  private double balance, monthlyFee, transactionFee;

// Constructors

  /**
  * This constructor is the default and sets the balance to 0
  */
  public BankAccount(){
    this.balance = 0;
    this.transactionFee = 10;
    this.monthlyFee = 10;
  }

  /**
  * This constructor takes a parameter to set an initial amount in the balance
  * @param initial
  */
  public BankAccount(double initial){
    this.balance = initial;
    this.transactionFee = 10;
    this.monthlyFee = 10;
  }

// Methods

  /**
  * This method puts money into the bank acount by adding to the balance
  * @param amount This is the amount you want to deposit
  */
  public void deposit(double amount){
    this.balance += amount;
  }

  /**
  * This method takes money out of the bank acount by subtracting from the balance
  * @param amount This is the amount you want to withdraw
  */
  public void withdrawal(double amount){
    this.balance -= amount;
  }

  /**
  * This method takes a transaction fee from the balance whenever a withdrawal is made
  * @return double This returns the private double transactionFee
  */
  public double transactionFee(){
    this.balance -= this.transactionFee;
    return transactionFee;
  }

  /**
  * This method gets the balance
  * @return double This returns the private double balance
  */
  public double getBalance(){
    return this.balance;
  }

  /**
  * This method gets the monthly fee
  * @return double This returns the private double monthlyFee
  */
  public double getMonthlyFee(){
    return this.monthlyFee;
  }

  /**
  * This method sets the transaction fee
  * @param fee This is the new amount for the fee
  */
  public void setTransactionFee(double fee){
    this.transactionFee = fee;
  }

  /**
  * This method deducts the monthly fee from the Balance
  */
  public void deductMonthlyFee(){
    this.balance -= monthlyFee;
  }

}
