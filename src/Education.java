import Exceptions.NoNegativeValueException;

import java.util.ArrayList;
import java.util.Scanner;

public class Education {
    private int id;
    private String educationLevel;
    private char grades;
    private double marksPercentage;
    private String institute;

    public Education(){}

    public static Education inputEducation(){
        //stores values for one degree of education and returns it
        Scanner input=new Scanner(System.in);
        Scanner inputString=new Scanner(System.in);
        Education degree = new Education();

        System.out.print("Enter education level: ");
        degree.setEducationLevel(inputString.nextLine());

        System.out.print("Enter grades: ");
        degree.setGrades(input.next().charAt(0));

        while(true) {
            try {
                System.out.print("Enter marks percentage: ");
                degree.setMarksPercentage(input.nextDouble());
                break;
            }catch (NoNegativeValueException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter Institute: ");
        degree.setInstitute(inputString.nextLine());

        return degree;
    }
    public static void updateEducation(ArrayList<Education> educations){
        Scanner input=new Scanner(System.in);
        Scanner inputString=new Scanner(System.in);

        System.out.println("Please make a choice in education: ");
        System.out.println("1: Add a degree");
        System.out.println("2: Remove a degree");
        int choice= input.nextInt();

        switch(choice){
            case 1:
                educations.add(Education.inputEducation());
                break;

            case 2:
                System.out.println("Enter degree name to remove: ");
                String degreeName=inputString.nextLine();
                for (Education edu:educations){
                    if (edu.getEducationLevel().equals(degreeName)) {
                        educations.remove(edu);
                        System.out.println("Degree removed successfully!");
                        return;
                        //if degree is found and removed methods ends
                        //else proceeds
                    }
                }
                System.out.println("Degree not found!");
                break;
            default:
                System.out.println("Make a valid choice!");
        }

    }
    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public char getGrades() {
        return grades;
    }

    public void setGrades(char grades) {
        this.grades = grades;
    }

    public double getMarksPercentage() {
        return marksPercentage;
    }

    public void setMarksPercentage(double marksPercentage) throws NoNegativeValueException{
        if(marksPercentage >0 )
            this.marksPercentage = marksPercentage;
        else
            throw new NoNegativeValueException("Marks cannot be negative!");
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
