package com.javaxdevelopers.OOMS;

import java.util.ArrayList;
import java.util.Scanner;
//Methods with similar working as in staff class
public class Orphan extends Person{
    private ArrayList<Skill> skillSet;
    private String entryDate;


    public  static void addOrphan(OOM organization){
        int id = organization.getOrphansList().size() + 1;
        if (id<=10) {
            Orphan child=new Orphan();
            child.inputData();
            child.setId(id);
            organization.getOrphansList().add(child);
            System.out.println("Orphan added successfully! ");

        }
        else
            System.out.println("No more space for Orphan!");

    }
    @Override
    public void inputData() {
        System.out.println("---Input data for Orphan---");
        super.inputData();
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        System.out.print("Enter entry date of Orphan: ");
        this.setEntryDate(inputString.nextLine());

        System.out.print("Enter number of skills for Orphan: ");
        int skillNumber = input.nextInt();
        ArrayList<Skill> skills = new ArrayList<>();
        for (int i = 0; i < skillNumber; i++) {
            System.out.println("For skill "+(i+1));
            skills.add(Skill.inputSkill());

        }
        this.setSkillSet(skills);
    }
    public static void removeOrphan(OOM organization){
        System.out.print("Enter orphan id to remove: ");
        Scanner input=new Scanner(System.in);
        int id= input.nextInt();
        boolean flag=false;
        for(Orphan child : organization.getOrphansList()) {
            if (child.getId() == id) {
                flag = true;
                child.displayData();
                System.out.print("Are you sure you want to delete this com.javaxdevelopers.OOMS.Orphan?\n\"Enter 1 to continue\": ");
                int choice = input.nextInt();
                if (choice == 1) {
                    organization.getOrphansList().remove(child);
                    System.out.println("Orphan removed successfully!");
                    return;
                }
            }
        }
        if (!flag){
            System.out.println("Orphan not found!");
        }
    }
    public static void updateRecordOptions(OOM organization){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter Orphan ID to update record: ");
        int id = input.nextInt();
        boolean flag=false;

        for(Orphan child: organization.getOrphansList()){
            if(child.getId()==id){
                flag=true;
                System.out.println("Enter attribute to update record: ");
                System.out.println("1: Name");
                System.out.println("2: age");
                System.out.println("3: Education");
                System.out.println("4: Skills");
                System.out.println("5: Entry Date");
                int choice= input.nextInt();
                child.updateData(choice);

            }
            if (!flag){
                System.out.println("No such employee found");
            }
        }
    }

    @Override
    public void updateData(int choice) {
        super.updateData(choice);
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        switch (choice){
            case 1:
            case 2:
            case 3:
                break;
            case 4:
                Skill.updateSkill(this.getSkillSet());
                break;
            case 5:
                System.out.println("Previous entry date is: " + getEntryDate());
                System.out.print("Enter new entry date: ");
                this.setEntryDate(inputString.nextLine());
                break;
            default:
                System.out.println("Please make a valid choice!");
        }
    }

    @Override
    public void displayData() {
        System.out.printf("---Printing details for Orphan %d ---\n",this.getId());
        super.displayData();
        System.out.println("---Printing skill details---");
        for(Skill skill:this.getSkillSet()){
            System.out.printf("---For skill %d --- ",skill.getSkillID());
            System.out.println("Skill Name: "+skill.getSkillName());
            System.out.println("Skill Description: "+skill.getSkillDescription());
        }
        System.out.println("Entry date is: "+this.getEntryDate());

    }

    public static void viewOrphan(OOM organization){
        boolean flag=false;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter orphan id to view: ");
        int id= input.nextInt();
        for(Orphan child : organization.getOrphansList()){
            if(child.getId()==id) {
                System.out.println("Child found!");
                flag=true;
                child.displayData();
            }

        }
        if (!flag){
            System.out.println("No such child found!");
        }


    }

    public ArrayList<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(ArrayList<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }


}
