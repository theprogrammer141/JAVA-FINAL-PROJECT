package com.javaxdevelopers.OOMS;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportGenerator {


    //METHOD FOR GENERATING REPORT FOR ORPHANS
    public static void generateOrphanReport(ArrayList<Orphan> orphans)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------ORPHANS REPORT------------------------------");
        System.out.println("Please choose from menu below:- ");
        System.out.println("1: Print Total orphans");
        System.out.println("2: Print Details by Age group");
        System.out.println("3: Print Details by Gender");
        System.out.println("4: Print Details by Education");
        System.out.println("5: Print Details by Skills");
        switch (input.nextInt()){
            case 1:
                totalOrphans(orphans);
                break;
            case 2:
                countOrphansByAgeGroups(orphans);
            case 3:
                ArrayList<Person> persons = new ArrayList<>(orphans);
                calculateByGender(persons);
                break;
            case 4:
                ArrayList<Person> person = new ArrayList<>(orphans);
                calculateEducatedAndNonEducated(person);
                break;
            case 5:
                calculateSkilledAndNonSkilledOrphans(orphans);
            default:
                System.out.println("Please make a valid choice!");
        }
        System.out.println("---------------------------------------------------------------------");
    }
    public static void generateStaffReport(ArrayList<Staff> staff)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------Staff REPORT------------------------------");
        System.out.println("Please choose from menu below:- ");
        System.out.println("1: Print Total Staff");
        System.out.println("2: Print Details by Age group");
        System.out.println("3: Print Details by Gender");
        System.out.println("4: Print Details by Education");
        switch (input.nextInt()){
            case 1:
                totalStaff(staff);
                break;
            case 2:
                countStaffByAgeGroups(staff);
            case 3:
                ArrayList<Person> persons = new ArrayList<>(staff);
                calculateByGender(persons);
                break;
            case 4:
                ArrayList<Person> person = new ArrayList<>(staff);
                calculateEducatedAndNonEducated(person);
                break;
            default:
                System.out.println("Please make a valid choice!");
        }
        System.out.println("---------------------------------------------------------------------");
    }

    //METHOD FOR CALCULATING TOTAL NUMBER OF ORPHANS
    public static void totalOrphans(ArrayList<Orphan> orphans)
    {
        System.out.println();
        System.out.println("TOTAL NUMBER OF ORPHANS CURRENTLY PRESENT: " + orphans.size());
        System.out.println();
    }

    //METHOD FOR CALCULATING ORPHANS ACCORDING TO AGE GROUPS
    //(1 - 5 YEARS), (6 - 10 YEARS), (11 - 15 YEARS), (16 - 20 YEARS), (20+ YEARS)
    public static void countOrphansByAgeGroups(ArrayList<Orphan> orphans)
    {
        int[] orphanAgeGroups = new int[4];
        for(Orphan orphan : orphans)
        {
            int age = orphan.getAge();
            if(age >= 1 && age <= 5)
            {
                orphanAgeGroups[0]++;
            }
            else if(age >= 6 && age <= 10)
            {
                orphanAgeGroups[1]++;
            }
            else if(age >= 11 && age <= 15)
            {
                orphanAgeGroups[2]++;
            }
            else if(age >= 16 && age <= 18)
            {
                orphanAgeGroups[3]++;
            }

        }
        System.out.println("Number Of Orphans in Age Group(1-5 years): " + orphanAgeGroups[0]);
        System.out.println("Number Of Orphans in Age Group(6-10 years): " + orphanAgeGroups[1]);
        System.out.println("Number Of Orphans in Age Group(11-15 years): " + orphanAgeGroups[2]);
        System.out.println("Number Of Orphans in Age Group(16-18 years): " + orphanAgeGroups[3]);
    }

    //METHOD FOR CALCULATING PERCENTAGE OF MALE ORPHANS
    public static void calculateByGender(ArrayList<Person> persons)
    {
        int maleOrphanCount = 0;
        int femaleOrphanCount = 0;
        for(Person person : persons)
        {
            if(person.getGender().equalsIgnoreCase("Male"))
            {
                maleOrphanCount++;
            }
            else if(person.getGender().equalsIgnoreCase("Female")){
                femaleOrphanCount++;
            }
        }
        double malePercentage =  ((double) maleOrphanCount / persons.size()) * 100;
        double femalePercentage =  ((double) femaleOrphanCount / persons.size()) * 100;
        System.out.println("\nNumber Of Males: " + maleOrphanCount);
        System.out.println("Percentage Of Males: " + malePercentage + "%");

        System.out.println("\nNumber Of Females: " + femaleOrphanCount);
        System.out.println("Percentage Of Females: " + femalePercentage + "%");

        System.out.printf("\nNumber Of Other Genders: %d", persons.size()-femaleOrphanCount-maleOrphanCount);
        System.out.printf("Percentage Of Other Genders: %f %", 100-(femalePercentage+malePercentage));
    }


    //METHOD FOR CALCULATING PERCENTAGES OF EDUCATED AND NON-EDUCATED ORPHANS
    public static void calculateEducatedAndNonEducated(ArrayList<Person> persons) {
        int educatedCount = 0;
        int nonEducatedCount = 0;
        for (Person person : persons) {
            if (!person.getEducation().getEducationLevel().equalsIgnoreCase("Null")){
                educatedCount++;
            } else {
                nonEducatedCount++;
            }
        }
        getEducatedAndNonEducatedCount(educatedCount, nonEducatedCount, persons.size());
    }
    public static void getEducatedAndNonEducatedCount(int educatedCount, int nonEducatedCount, int size) {
        double literacyPercentage = (double) educatedCount / size * 100;
        double illiteracyPercentage = (double) nonEducatedCount / size * 100;

        System.out.println();
        System.out.println("Number Of Educated: " + educatedCount);
        System.out.println("Number Of Non-Educated  : " + nonEducatedCount);
        System.out.println("Literacy Percentage: " + literacyPercentage + "%");
        System.out.println("Illiteracy Percentage: " + illiteracyPercentage + "%");
        System.out.println();
    }

    //METHOD TO CALCULATE SKILLED AND NON-SKILLED ORPHANS
    public static void calculateSkilledAndNonSkilledOrphans(ArrayList<Orphan> orphans)
    {
        int skilledOrphansCount = 0;
        int nonSkilledOrphansCount = 0;
        for(Orphan orphan : orphans)
        {
            if(orphan.getSkillSet() != null)
            {
                skilledOrphansCount++;
            }
            else
            {
                nonSkilledOrphansCount++;
            }
        }
        double skilledPercentage = (double) skilledOrphansCount / orphans.size() * 100;
        double nonSkilledPercentage = (double) nonSkilledOrphansCount / orphans.size() * 100;
        System.out.println();
        System.out.println("Number Of Skilled Orphans: " + skilledOrphansCount);
        System.out.println("Number Of Non-Skilled Orphans: " + nonSkilledOrphansCount);
        System.out.println("Skilled Percentage: " + skilledPercentage);
        System.out.println("Non-Skilled Percentage: " + nonSkilledPercentage);
        System.out.println();
    }

    //METHOD FOR GENERATING REPORT FOR STAFF


    //METHOD FOR CALCULATING TOTAL NUMBER OF STAFF
    public static void totalStaff(ArrayList<Staff> staff)
    {
        System.out.println();
        System.out.println("Total Number Of Staff Currently Present: " + staff.size());
        System.out.println();
    }

    //METHOD FOR CALCULATING STAFF ACCORDING TO AGE GROUPS
    //(20-25 YEARS), (26-30 YEARS), (31-35 YEARS), (36-40 YEARS), (40+ YEARS)
    public static void countStaffByAgeGroups(ArrayList<Staff> staff) {
        int[] staffAgeGroups = new int[5];
        for (Staff staff1 : staff) {
            int age = staff1.getAge();
            if (age >= 20 && age <= 25) {
                staffAgeGroups[0]++;
            } else if (age >= 26 && age <= 30) {
                staffAgeGroups[1]++;
            } else if (age >= 31 && age <= 35) {
                staffAgeGroups[2]++;
            } else if (age >= 36 && age <= 40) {
                staffAgeGroups[3]++;
            } else if (age > 40) {
                staffAgeGroups[4]++;
            }
        }
        System.out.println("Number Of Staff In Age Group(20-25 years): " + staffAgeGroups[0]++);
        System.out.println("Number Of Staff In Age Group(25-30 years): " + staffAgeGroups[1]++);
        System.out.println("Number Of Staff In Age Group(30-35 years): " + staffAgeGroups[2]++);
        System.out.println("Number Of Staff In Age Group(35-40 years): " + staffAgeGroups[3]++);
        System.out.println("Number Of Staff In Age Group(40+ years): " + staffAgeGroups[4]++);


    }

    //METHOD FOR GENERATING REPORT FOR INVENTORY ITEMS
    public static void generateReportForInventoryItems(ArrayList<InventoryItem> items)
    {
        System.out.println();
        System.out.println("------------------------INVENTORY ITEMS REPORT-----------------------");
        System.out.println("Total Number Of Items: " + items.size());

        for(InventoryItem inventoryItem : items)
        {
            inventoryItem.displayData();
            int usedQuantity = getUsedQuantity(inventoryItem);
            int remainingQuantity = inventoryItem.getQuantity() - usedQuantity;

            System.out.println("Used Quantity: " + usedQuantity);
            System.out.println("Remaining Quantity: " + remainingQuantity);

        }
        System.out.println("---------------------------------------------------------------------");
    }

    //METHOD FOR CALCULATING QUANTITY OF ITEM BEING USED
    public static int getUsedQuantity(InventoryItem inventoryItem)
    {
        return inventoryItem.getQuantity() / 2;
    }

    //METHOD FOR GENERATING DONATIONS REPORT
    public static void generateDonationsReport(ArrayList<Donation> donations) {
        System.out.println("--------------------------DONATIONS REPORT---------------------------");
        System.out.println("Total Number Of Donations: " + donations.size());

        for (Donation donation : donations) {
            donation.displayData();
        }
        System.out.println("---------------------------------------------------------------------");
    }

    //METHOD FOR GENERATING ACCOUNTS REPORT
    public static void generateAccountsReport(Account account)
    {
        System.out.println("--------------------------ACCOUNTS REPORT----------------------------");
        account.displayAccount();
        System.out.println("---------------------------------------------------------------------");
    }
}
