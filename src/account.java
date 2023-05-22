import java.text.DecimalFormat;
import java.util.Scanner;

public class account {
    private int customarNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00");

    public int getCustomarNumber() {
        return customarNumber;
    }

    public void setCustomarNumber(int customarNumber) {
        this.customarNumber = customarNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void calcCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
    }

    public void calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
    }

    public void calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
    }

    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from your Checking Account: ");
        double amount = input.nextDouble();

        if((checkingBalance - amount) >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
        } else{
            System.out.println("Balance can't be Negative." + "\n");
        }
    }

    public void getSavingWithdrawInput(){
        System.out.println("Saving account balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from your Saving Account: ");
        double amount = input.nextDouble();

        if((savingBalance - amount) >= 0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
        } else{
            System.out.println("Balance can't be Negative." + "\n");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from your Checking Account: ");
        double amount = input.nextDouble();

        if((checkingBalance + amount) >= 0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
        } else{
            System.out.println("Balance can't be Negative." + "\n");
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Saving account balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to Deposit to your Saving Account: ");
        double amount = input.nextDouble();

        if((savingBalance - amount) >= 0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
        } else{
            System.out.println("Balance can't be Negative." + "\n");
        }
    }
}