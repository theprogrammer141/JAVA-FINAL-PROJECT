package com.javaxdevelopers.OOMS;

import com.javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        OOM organization = new OOM();
        /*
        One object of management class is created and used throughout to ensure
        all data is stored in one object
        */

        while(true) {
            /*
           1.Here choice from user is taken and respective methods are called
            To work with different classes
           2.Loop ensures that program does not terminate after one action rather
            it terminate only when user want to
            */
            Scanner input = new Scanner(System.in);
            System.out.println("---------------Welcome to Organization Management---------------");
            System.out.println("Please choose from the menu below:-");
            System.out.println("1: Staff");
            System.out.println("2: Orphan");
            System.out.println("3: Donations");
            System.out.println("4: Account");
            System.out.println("5: Inventory");
            System.out.println("6: Go to report generator");
            System.out.println("0: Exit");
            System.out.println("-----------------------------------------------------------------");

            switch (input.nextInt()) {
                case 1:
                    getStaffChoice(organization);
                    break;
                case 2:
                    getOrphanChoice(organization);
                    break;
                case 3:
                    getDonationChoice(organization);
                    break;
                case 4:
                    accountChoice(organization);
                    break;
                case 5:
                    inventoryChoice(organization);
                    break;
                case 6:
                    generateReport(organization);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please make a valid choice!");
            }
        }
    }
    /*
        Here onward every method takes choice from user and calls respective
        methods in desired classes
        Again loop ensures that program is not terminated after one action
     */
    public static void inventoryChoice(OOM organization){

        while(true) {
            System.out.println("----------------------------------------------------");
            System.out.println("Please choose from the menu below:-");
            System.out.println("1: Add Item");
            System.out.println("2: Remove Item");
            System.out.println("3: Update Inventory record");
            System.out.println("4: Display Inventory record");
            System.out.println("5: View an item");
            System.out.println("0: Return to last screen");
            System.out.println("-----------------------------------------------------");
            Scanner input = new Scanner(System.in);

            switch (input.nextInt()) {
                case 1:
                    InventryItem.addItem(organization);
                    break;
                case 2:
                    InventryItem.removeItem(organization);
                    break;
                case 3:
                    InventryItem.updateRecord(organization);
                    break;
                case 4:
                    for(InventryItem item: organization.getItemsList())
                        item.displayData();
                    break;
                case 5:
                    InventryItem.viewItem(organization);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please make a valid choice!");
            }
        }
    }
    public static void getDonationChoice(OOM organization){
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("---------------------------------------------------");
            System.out.println("Please choose from the menu below:- ");
            System.out.println("1: Add Donation");
            System.out.println("2: Display all donations");
            System.out.println("3: View a donation");
            System.out.println("0: Main menu");
            System.out.println("----------------------------------------------------");

            switch (input.nextInt()){
                case 1:
                    Donation.addDonation(organization);
                    break;
                case 2:
                    for (Donation donation : organization.getDonationsList())
                        donation.displayData();
                    break;
                case 3:
                    Donation.viewDonation(organization);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please make a valid choice!");
            }
        }
    }
    public static void accountChoice(OOM organization){
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("Please choose from the menu below:- ");
            System.out.println("1: Deposit money");
            System.out.println("2: Withdraw money");
            System.out.println("3: Display balance");
            System.out.println("4: Display account details");
            System.out.println("0: Main Menu");
            System.out.println("-------------------------------------------------");

            switch (input.nextInt()){
                case 1:
                    while(true) {
                        try {
                            organization.getBankAccount().depositMoney();
                            break;
                        } catch (NoNegativeValueException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    organization.getBankAccount().withdrawMoney();
                    break;
                case 3:
                    organization.getBankAccount().checkBalance();
                    break;
                case 4:
                    organization.getBankAccount().displayAccount();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please make a valid choice!");
            }
        }
    }
    public static void getStaffChoice(OOM organization){
        while(true) {
            System.out.println("---------------------------------------------------");
            System.out.println("Please choose from the menu below:-");
            System.out.println("1: Add Staff");
            System.out.println("2: Remove Staff");
            System.out.println("3: Update Staff record");
            System.out.println("4: Display Staff record");
            System.out.println("5: View Staff Record");
            System.out.println("0: Return to last screen");
            System.out.println("----------------------------------------------------");

            Scanner input = new Scanner(System.in);

            switch (input.nextInt()) {
                case 1:
                    Staff.addStaff(organization);
                    break;
                case 2:
                    Staff.removeStaff(organization);
                    break;
                case 3:
                    Staff.updateRecordOptions(organization);
                    break;
                case 4:
                    for(Staff employee: organization.getStaffList())
                        employee.displayData();
                    break;
                case 5:
                    Staff.viewStaff(organization);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please make a valid choice!");
            }
        }
    }
    public static void getOrphanChoice(OOM organization){
        while(true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Please choose from the menu below:- ");
            System.out.println("1: Add Child");
            System.out.println("2: Remove Child");
            System.out.println("3: Update Child record");
            System.out.println("4: Display Child record");
            System.out.println("5: View Child Record");
            System.out.println("0: Return to last screen");
            System.out.println("---------------------------------------------------");
            Scanner input = new Scanner(System.in);

            switch (input.nextInt()) {
                case 1:
                    Orphan.addOrphan(organization);
                    break;
                case 2:
                    Orphan.removeOrphan(organization);
                    break;
                case 3:
                    Orphan.updateRecordOptions(organization);
                    break;
                case 4:
                    for(Orphan child: organization.getOrphansList())
                        child.displayData();
                    break;
                case 5:
                    Orphan.viewOrphan(organization);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please make a valid choice!");
            }
        }
    }

    public static void generateReport(OOM organization){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("--------------------------------------------------");
            System.out.println("Please choose from the menu below:- ");
            System.out.println("1: Generate Staff Report");
            System.out.println("2: Generate Orphan Report");
            System.out.println("3: Generate Donations Report");
            System.out.println("4: Generate Account Report");
            System.out.println("5: Generate Inventory Report");
            System.out.println("0: Main Menu");
            System.out.println("-----------------------------------------------------------------");

            switch (input.nextInt()) {
                case 1:
                    ReportGenerator.generateStaffReport(organization.getStaffList());
                    break;
                case 2:
                    ReportGenerator.generateOrphanReport(organization.getOrphansList());
                    break;
                case 3:
                    ReportGenerator.generateDonationsReport(organization.getDonationsList());
                    break;
                case 4:
                    ReportGenerator.generateAccountsReport(organization.getBankAccount());
                    break;
                case 5:
                    ReportGenerator.generateReportForInventoryItems(organization.getItemsList());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please make a valid choice!");
            }
        }
    }
}
