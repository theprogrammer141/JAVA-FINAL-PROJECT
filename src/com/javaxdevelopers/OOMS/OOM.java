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
        readStaffFromFile();
        readAccountFromFile();
        readDonationFromFile();
        readOrphanFromFile();
        readAdminFromFile();
        readItemFromFile();


    }



    public void readStaffFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("staffData.ser"))){

            this.setStaffList( (ArrayList<Staff>) in.readObject());

        }catch (EOFException e){
            //end of file reached
        }
       catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
       }


    }
    public void readOrphanFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("OrphanData.ser"))){

                this.setOrphansList((ArrayList<Orphan>) in.readObject());


        }catch (EOFException e){
            //end of file reached
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    public void readItemFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("itemData.ser"))){

            this.setItemsList((ArrayList<InventoryItem>) in.readObject());

        }catch (EOFException e){
            //end of file reached
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    public void readDonationFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("donationData.ser"))){
            this.setDonationsList((ArrayList<Donation>) in.readObject());


        }catch (EOFException e){
            //end of file reached
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    public void readAdminFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("adminData.ser"))){
            this.setAdministrators((ArrayList<Admin>) in.readObject());


        }catch (EOFException e){
            //end of file reached
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    public void readAccountFromFile(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("accountData.ser"))){
           this.setBankAccount((Account) in.readObject());

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
