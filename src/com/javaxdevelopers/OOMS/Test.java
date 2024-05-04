package com.javaxdevelopers.OOMS;

import com.javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        OOM organization=new OOM();
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
            System.out.println("1: com.javaxdevelopers.OOMS.Staff");
            System.out.println("2: com.javaxdevelopers.OOMS.Orphan");
            System.out.println("3: Donations");
            System.out.println("4: com.javaxdevelopers.OOMS.Account");
            System.out.println("5: Inventory");
            System.out.println("6: Go to report generator");
            System.out.println("0: End");

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
                    inventryChoice(organization);
                    break;
                case 6:
                    ReportGenerator report=new ReportGenerator(organization);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please make a valid choice");
            }
        }
    }
    /*
        Here onward every method takes choice from user and calls respective
        methods in desired classes
        Again loop ensures that program is not terminated after one action
     */
    public static void inventryChoice(OOM organization){

        while(true) {
            System.out.println("Please make a choice in Inventry");
            System.out.println("1: Add Item");
            System.out.println("2: Remove Item");
            System.out.println("3: Update Inventry record");
            System.out.println("4: Display Inventry record");
            System.out.println("5: View an item");
            System.out.println("0: Return to last screen");
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
                    System.out.println("Please make a valid choice");
            }
        }
    }
    public static void getDonationChoice(OOM organization){
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("Please make a choice in donations: ");
            System.out.println("1: Add com.javaxdevelopers.OOMS.Donation");
            System.out.println("2: Display all donation");
            System.out.println("3: View a donation");
            System.out.println("0: Main menu");
            switch (input.nextInt()){
                case 1:
                    Donation.addDonation(organization);
                    break;
                case 2:
                    for (Donation dono:organization.getDonationsList())
                        dono.displayData();
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
            System.out.println("Make a choice in account: ");
            System.out.println("1: Deposit money");
            System.out.println("2: Withdraw money");
            System.out.println("3: Display balance");
            System.out.println("4: Display account details");
            System.out.println("0: Main Menu");
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
                    System.out.println("Enter a valid choice!");
            }
        }
    }
    public static void getStaffChoice(OOM organization){
        while(true) {
            System.out.println("Please make a choice in staff");
            System.out.println("1: Add com.javaxdevelopers.OOMS.Staff");
            System.out.println("2: Remove com.javaxdevelopers.OOMS.Staff");
            System.out.println("3: Update com.javaxdevelopers.OOMS.Staff record");
            System.out.println("4: Display com.javaxdevelopers.OOMS.Staff record");
            System.out.println("5: View a com.javaxdevelopers.OOMS.Staff");
            System.out.println("0: Return to last screen");
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
                    System.out.println("Please make a valid choice");
            }
        }
    }
    public static void getOrphanChoice(OOM organization){
        while(true) {
            System.out.println("Please make a choice in com.javaxdevelopers.OOMS.Orphan");
            System.out.println("1: Add Child");
            System.out.println("2: Remove Child");
            System.out.println("3: Update Child record");
            System.out.println("4: Display Child record");
            System.out.println("5: View a Child");
            System.out.println("0: Return to last screen");
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
                    System.out.println("Please make a valid choice");
            }
        }
    }



}
