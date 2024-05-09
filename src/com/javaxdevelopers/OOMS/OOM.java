package com.javaxdevelopers.OOMS;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/*
    this class contains arrayLists of other classes so that data of different
    classes can be stored and worked with
    */
public class OOM {

    private ArrayList<Staff> staffList;
    private ArrayList<Orphan> orphansList ;
    private ArrayList<Donation> donationsList ;
    private ArrayList<InventoryItem> itemsList ;
    private ArrayList<Admin> administrators ;
    private Account bankAccount ;

    /*
    This no arg constructor initialize arrayLists which are used to store data
    of different classes taken from user
    */
    public OOM(){
        setStaffList(new ArrayList<>());
        setAdministrators(new ArrayList<>());
        setDonationsList(new ArrayList<>());
        setItemsList(new ArrayList<>());
        setOrphansList(new ArrayList<>());
        setBankAccount(new Account());
        readFromFile();


    }
    public void readFromFile(){
        readStaffFromFile();
        readAccountFromFile();
        readDonationFromFile();
        readOrphanFromFile();
        readAdminFromFile();
        readItemFromFile();
    }


    public void readStaffFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\2nd sem\\OOPs\\staffData.ser"))){
            Staff staff;

            while ((staff = (Staff) in.readObject()) !=null){
                this.getStaffList().add(staff);

            }

        }catch (EOFException e){
            //end of file reached
        }
       catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
       }


    }
    public void readOrphanFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\2nd sem\\OOPs\\OrphanData.ser"))){
            Orphan orphan;

            while ((orphan = (Orphan) in.readObject()) !=null){
                this.getOrphansList().add(orphan);
            }

        }catch (EOFException e){
            //end of file reached
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    public void readItemFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\2nd sem\\OOPs\\itemData.ser"))){
            InventoryItem item;

            while ((item = (InventoryItem) in.readObject()) !=null){
                this.getItemsList().add(item);
            }

        }catch (EOFException e){
            //end of file reached
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    public void readDonationFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\2nd sem\\OOPs\\donationData.ser"))){
            Donation donation;

            while ((donation = (Donation) in.readObject()) !=null){
                this.getDonationsList().add(donation);
            }

        }catch (EOFException e){
            //end of file reached
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    public void readAdminFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\2nd sem\\OOPs\\adminData.ser"))){
            Admin admin;

            while ((admin = (Admin) in.readObject()) !=null){
                this.getAdministrators().add(admin);
            }

        }catch (EOFException e){
            //end of file reached
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    public void readAccountFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\2nd sem\\OOPs\\accountData.ser"))){
            Account account;

            while ((account = (Account) in.readObject()) !=null){
                this.setBankAccount(account);
            }

        }catch (EOFException e){
            //end of file reached
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }


    public Account getBankAccount() {
        return bankAccount;
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

    public ArrayList<Orphan> getOrphansList() {
        return orphansList;
    }

    public void setOrphansList(ArrayList<Orphan> orphansList) {
        this.orphansList = orphansList;
    }

    public ArrayList<Donation> getDonationsList() {
        return donationsList;
    }

    public void setDonationsList(ArrayList<Donation> donationsList) {
        this.donationsList = donationsList;
    }

    public ArrayList<InventoryItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<InventoryItem> itemsList) {
        this.itemsList = itemsList;
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public ArrayList<Admin> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(ArrayList<Admin> administrators) {
        this.administrators = administrators;
    }
}
