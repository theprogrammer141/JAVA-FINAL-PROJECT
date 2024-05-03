import java.util.ArrayList;
import java.util.Scanner;
//Super class for staff/orphan with common attributes of both
public class Person {
    private int id;
    private String name;
    private String gender;
    private ArrayList<Education> education;
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

        System.out.print("Enter age: ");
        this.setAge(input.nextInt());

        ArrayList<Education> edu = new ArrayList<>();

        System.out.print("Enter no of degrees: ");
        int degNumber = input.nextInt();

        for (int i = 0; i < degNumber; i++) {
            //to input education details method in education class is called
            //so that inputEducation method is reusable when updating record
            System.out.printf("---For degree %d : ---\n",(i+1));
            Education degree=Education.inputEducation();
            degree.setId(edu.size());
            edu.add(degree);
        }
        this.setEducation(edu);

    }
    public void displayData() {
        System.out.println("Name: " + this.getName());
        System.out.println("Gender: " + this.getGender());
        System.out.println("Age: " + this.getAge());

        System.out.println("---Printing Education details---");
        for (Education degree : this.getEducation()) {
            System.out.printf("---For degree %d ---\n",degree.getId());
            System.out.println("Degree level: " + degree.getEducationLevel());
            System.out.println("Marks: " + degree.getMarksPercentage());
            System.out.println("Grade: " + degree.getGrades());
            System.out.println("Institute: " + degree.getInstitute());
        }

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
                System.out.print("Enter new age: ");
                this.setAge(input.nextInt());
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
        this.gender = gender;
    }

    public ArrayList<Education> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<Education> education) {
        this.education = education;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


