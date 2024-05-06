package com.javaxdevelopers.OOMS;

import com.javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import java.util.Scanner;
//This class keeps record of donations made for organization
public class Donation {
    private int donationId;
    private String donorName;
    private double donationAmount;
    private String date;
    public Donation(){}
    /*
    No arg constructor makes object for which we can set values rather that storing
    them in different variables and then using fully parametrized constructor*/


    public static void addDonation(OOM organization){
    /*
    addDonation method makes object of donation, calls inputData method which sets
    values, and at last stores object of donation type to arrayList in management class
    It also adds donated money to bankAccount
    */
        Donation donation=new Donation();
        inputData(donation);
        donation.setDonationId(organization.getDonationsList().size()+1);

        organization.getDonationsList().add(donation);
        organization.getBankAccount().depositMoney(donation.getDonationAmount());
    }

    public static void inputData(Donation dono){
        //inputData method takes data from user and sets values of Donation object
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        System.out.println("---Enter donation details---");

        System.out.print("Enter donor name: ");
        dono.setDonorName(inputString.nextLine());

        while(true)
            try {
                System.out.print("Enter donation amount: ");
                dono.setDonationAmount(input.nextDouble());
                break;
            }catch (NoNegativeValueException e){
                System.out.println(e.getMessage());
        }

        System.out.print("Enter donation date (dd/mm/yyyy): ");
        dono.setDate(inputString.nextLine());

    }

    public void displayData(){
        //displayData prints details of object
        System.out.printf("---Printing details for Donation %d---\n",this.getDonationId());
        System.out.println("Donor name: "+this.getDonorName());
        System.out.println("Donation amount: "+this.getDonationAmount());
        System.out.println("Donation date: "+this.getDate());
    }
    public static void viewDonation(OOM organization){
        //checks if required object of Donation is present and
        // then calls displayData to print details
        Scanner input = new Scanner(System.in);
        System.out.print("Enter donation id to view: ");
        int id= input.nextInt();
        boolean flag=false;
        for (Donation dono:organization.getDonationsList()){

            if (dono.donationId==id){
                flag=true;
                dono.displayData();
            }
        }
        if(!flag){
            System.out.println("Donation not found!");
        }
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) throws NoNegativeValueException{
        if(donationAmount > 0)
            this.donationAmount = donationAmount;
        else
            throw new NoNegativeValueException("Donation value cannot be negative");
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
