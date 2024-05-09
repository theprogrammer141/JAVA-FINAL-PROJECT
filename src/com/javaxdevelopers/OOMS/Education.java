package com.javaxdevelopers.OOMS;

import java.io.Serializable;
import java.util.Scanner;

public class Education implements Serializable {
    private String educationLevel;
    private String institute;
    public Education(){}
    public static Education inputEducation(){
        //stores values for one degree of education and returns it
        Scanner inputString=new Scanner(System.in);
        Education degree = new Education();

        System.out.println("For highest education:");
        System.out.print("Enter education level: ");
        degree.setEducationLevel(inputString.nextLine());

        System.out.print("Enter Institute: ");
        degree.setInstitute(inputString.nextLine());

        return degree;
    }
    public static void updateEducation(Education education){
        Scanner input=new Scanner(System.in);
        Scanner inputString=new Scanner(System.in);

        System.out.println("Please make a choice");
        System.out.println("1: Update education level");
        System.out.println("2: Update institute");

        if(1==input.nextInt()){
            System.out.println("Previous education level is "+education.getEducationLevel());
            System.out.print("Enter new education level: ");
            education.setEducationLevel(inputString.nextLine());

        }else if(input.nextInt()==2){
            System.out.println("Previous institute is "+education.getInstitute());
            System.out.print("Enter new institute name: ");
            education.setInstitute(inputString.nextLine());

        }else
            System.out.println("Invalid choice!");


    }
    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }
}
