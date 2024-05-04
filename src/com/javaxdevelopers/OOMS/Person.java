package com.javaxdevelopers.OOMS;
import com.javaxdevelopers.exceptionhandlers.NoNegativeValueException;
import java.util.Scanner;
//Super class for staff/orphan with common attributes of both
public class Person {
    private int id;
    private String name;
    private String gender;
    private Education education;
    private int age;

    public Person(){}
    //default const. to work with no arg const. in subClasses

    public void inputData() {
        //sets parent class attributes in respective objects of subclasses
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        System.out.print("Enter name: ");
        this.setName(inputString.nextLine()) ;

        System.out.print("Enter gender: ");
        this.setGender(inputString.nextLine());

        while(true) {
            System.out.print("Enter age: ");
            try {
                this.setAge(input.nextInt());
                break;
            }catch (NoNegativeValueException e){
                System.out.println(e.getMessage());
            }
        }
        this.setEducation(Education.inputEducation());
    }
    public void displayData() {
        System.out.println("Name: " + this.getName());
        System.out.println("Gender: " + this.getGender());
        System.out.println("Age: " + this.getAge());

        System.out.println("---Printing Education details---");

        System.out.println("---For highest level degree ---");
        System.out.println("Degree level: " + this.getEducation().getEducationLevel());
        System.out.println("Institute: " + this.getEducation().getInstitute());


    }
    public void updateData(int choice){
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        switch (choice){
            case 1:
                System.out.println("Previous name is: "+this.getName());
                System.out.print("Enter new name: ");
                this.setName(inputString.nextLine());
                break;
            case 2:
                System.out.println("Previous age is: "+this.getAge());
                while(true) {
                    System.out.print("Enter New Age: ");
                    try {
                        this.setAge(input.nextInt());
                        break;
                    }catch (NoNegativeValueException e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case 3:
                Education.updateEducation(this.getEducation());
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other"))
            this.gender = gender;
        else
            System.out.println("Invalid Gender!");
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws NoNegativeValueException {
        if(age > 0 && age <= 70)
            this.age = age;
        else
            throw new NoNegativeValueException("Exception: Age must be in the range(1-70)!");
    }
}