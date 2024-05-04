package com.javaxdevelopers.OOMS;

import java.util.ArrayList;
/*
    this class contains arrayLists of other classes so that data of different
    classes can be stored and worked with
    */
public class OOM {

    private ArrayList<Staff> staffList;
    private ArrayList<Orphan> orphansList;
    private ArrayList<Donation> donationsList;
    private ArrayList<InventryItem> itemsList;
    private Account bankAccount;

    /*
    This no arg constructor initialize arrayLists which are used to store data
    of different classes taken from user
    */
    public OOM(){
        setStaffList(new ArrayList<>());
        setOrphansList(new ArrayList<>());
        setDonationsList(new ArrayList<>());
        setItemsList(new ArrayList<>());
        setBankAccount(new Account());
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

    public ArrayList<InventryItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<InventryItem> itemsList) {
        this.itemsList = itemsList;
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }
}