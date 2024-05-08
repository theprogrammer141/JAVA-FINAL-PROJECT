package com.javaxdevelopers.OOMS;


import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String adminName;

    private ArrayList<String> passwords;

    public Admin() {
    }

    public Admin(String adminName, ArrayList<String> passwords) {
        this.adminName = adminName;
        this.passwords = passwords;
    }

    public static boolean logIn(ArrayList<Admin> administrators){
        Scanner inputString = new Scanner(System.in);
        System.out.println("------To Login------");
        System.out.println("Enter Admin Name");
        String adminName = inputString.nextLine();
        System.out.println("Enter Password");
        String password = inputString.nextLine();
        for (Admin administrator : administrators){
            if (adminName.equalsIgnoreCase(administrator.getAdminName())){
               if (password.equals(administrator.getPasswords().get(0)))
                   return true;
            }
        }
        return false;

    }

    public static void newAdmin(ArrayList<Admin> administrator){
        Scanner inputString = new Scanner(System.in);
        System.out.println("To add new admin ");
        System.out.println("Only previous Admins can add new admins!");
        System.out.println("Please verify from a previous admin!");
        if (logIn(administrator)){
            Admin newAdmin= new Admin();
            System.out.print("Enter admin Name: ");
            newAdmin.setAdminName(inputString.nextLine());
            ArrayList<String> passwords = new ArrayList<>();
            System.out.print("Enter admin password: ");
            passwords.add(inputString.nextLine());
            newAdmin.setPasswords(passwords);
            administrator.add(newAdmin);
        }else
            System.out.println("Admin authentication failed!");
    }
    public static void changePassword(ArrayList<Admin> administrators){
        System.out.println("---To change password---");
        Scanner inputString = new Scanner(System.in);

        System.out.print("Enter Admin Name");
        String adminName = inputString.nextLine();
        System.out.print("Enter Last Password you remember: ");
        String password = inputString.nextLine();
        for (Admin administrator : administrators){
            if (adminName.equalsIgnoreCase(administrator.getAdminName())){
               for (String adminPassword : administrator.getPasswords()){
                   if (password.equals(adminPassword)){
                       if(adminVerification(administrators,administrator)) {
                           System.out.println("Password changed successfully!");
                           return;
                       }
                   }else
                   {
                       System.out.println("Verification failed!");
                       if(adminVerification(administrators,administrator)) {
                           System.out.println("Password changed successfully!");
                           return;
                       }
                   }
               }
            }
        }

    }

    private static boolean adminVerification(ArrayList<Admin> administrators,  Admin administrator) {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        System.out.println("For extra security we need to confirm from another admin its you: ");
        System.out.println("Please verify from any other admin!");
        if (logIn(administrators)){
            System.out.print("Please Enter 1 to verify this admin: ");
            if (input.nextInt()==1){
                System.out.print("Enter new password: ");
                administrator.getPasswords().add(0,inputString.nextLine());
                return true;
            }
            else {
                System.out.println("Could not change password!");
                return false;
            }
        }
        else {
            System.out.println("Could not change password!");
            return false;
        }
    }


    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public ArrayList<String> getPasswords() {
        return passwords;
    }

    public void setPasswords(ArrayList<String> passwords) {
        this.passwords = passwords;
    }
}
