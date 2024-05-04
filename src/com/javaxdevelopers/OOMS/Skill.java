package com.javaxdevelopers.OOMS;

import java.util.ArrayList;
import java.util.Scanner;

public class Skill {
    private int skillID;
    private String skillName;
    private String skillDescription;

    public Skill(){}

    public static Skill inputSkill(){
        Scanner input=new Scanner(System.in);
        Scanner inputString=new Scanner(System.in);
        Skill skill=new Skill();
        System.out.print("Enter Skill ID: ");
        skill.setSkillID(input.nextInt());
        System.out.print("Enter skill name: ");
        skill.setSkillName(inputString.nextLine());
        System.out.print("Enter skill description: ");
        skill.setSkillDescription(inputString.nextLine());
        return skill;
    }
    public static void updateSkill(ArrayList<Skill> skills){
        Scanner input=new Scanner(System.in);
        Scanner inputString=new Scanner(System.in);

        System.out.println("Please make a choice in Skill: ");
        System.out.println("1: Add a Skill");
        System.out.println("2: Remove a Skill");

        int choice= input.nextInt();
        switch(choice){
            case 1:
                skills.add(Skill.inputSkill());
                break;
            case 2:
                System.out.println("Enter skill name to remove: ");
                String skillName=inputString.nextLine();

                for (Skill skill:skills){
                    if (skill.getSkillName().equals(skillName)) {

                        skills.remove(skill);
                        System.out.println("Skill removed successfully!");
                        return;
                    }
                }
                System.out.println("Skill not found!");
                break;
            default:
                System.out.println("Make a valid choice!");
        }

    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

}
