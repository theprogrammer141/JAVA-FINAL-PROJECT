package com.javaxdevelopers.OOMS;

import com.javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import java.util.Scanner;
//there is only one account of organization so accountID and bank name are preset
public class Account {
    private String accountID;
    private String bankName;
    private double balance;

    public Account(){
        setAccountID("abl32987456247");
        setBankName("HBL");
    }

    public void depositMoney() throws NoNegativeValueException{
        //used to deposit money in account
        Scanner input=new Scanner(System.in);
            System.out.println("Enter amount to deposit: ");
            double amount= input.nextDouble();
            if (amount > 0) {
                balance += amount;
                System.out.println("Amount added successfully!");
                this.checkBalance();
            } else {
                throw new NoNegativeValueException("Negative value cannot be added!");
            }
    }
    public void depositMoney(double amount){
        //overLoaded method useful when a known amount is donated
        this.balance+=amount;
        System.out.println("Amount added successfully!");
    }
    public void withdrawMoney(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter amount to withdraw: ");
        double amount= input.nextDouble();
        if(balance>=amount){
            balance-=amount;
            System.out.println("Withdrawal successful!");
            this.checkBalance();
        }
        else {
            System.out.println("Insufficient balance");
        }


    }
    public void checkBalance(){
        System.out.println("Remaining balance is: "+this.getBalance());
    }
    public void displayAccount(){
        //Display info about organization account
        System.out.println("---Printing Account details---");
        System.out.println("Bank account no: "+this.getAccountID());
        System.out.println("Bank name: "+this.getBankName());
        System.out.println("Balance: "+this.getBalance());
    }
    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
