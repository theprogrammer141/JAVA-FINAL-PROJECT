package com.javaxdevelopers.OOMS;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class ReportGenerator {
    ArrayList<Orphan> orphans = new ArrayList<>();
    ArrayList<Staff> staff = new ArrayList<>();
    ArrayList<InventoryItem> inventoryItems = new ArrayList<>();
    ArrayList<Donation> donations = new ArrayList<>();
    ArrayList<Account> accounts = new ArrayList<>();

    //METHOD FOR GENERATING REPORT FOR ORPHANS
    public void generateOrphanReport()
    {
        System.out.println("------------------------ORPHANS REPORT------------------------------");
        totalOrphans();
        countOrphansByAgeGroups();
        calculateMaleOrphansPercentage();
        calculateFemaleOrphansPercentage();
        calculateNationalitiesOfOrphans();
        calculateReligionsOfOrphans();
        calculateEducatedAndNonEducatedOrphans();
        calculateSkilledAndNonSkilledOrphans();
        System.out.println("---------------------------------------------------------------------");
    }

    //METHOD FOR CALCULATING TOTAL NUMBER OF ORPHANS
    public void totalOrphans()
    {
        System.out.println();
        System.out.println("TOTAL NUMBER OF ORPHANS CURRENTLY PRESENT: " + orphans.size());
        System.out.println();
    }

    //METHOD FOR CALCULATING ORPHANS ACCORDING TO AGE GROUPS
    //(1 - 5 YEARS), (6 - 10 YEARS), (11 - 15 YEARS), (16 - 20 YEARS), (20+ YEARS)
    public void countOrphansByAgeGroups()
    {
        int[] orphanAgeGroups = new int[5];
        for(Orphan orphan : orphans)
        {
            int age = orphan.getAge();
            if(age >= 1 && age <= 5)
            {
                System.out.println("Number Of Orphans in Age Group(1 - 5 years): " + orphanAgeGroups[0]++);
            }
            else if(age >= 6 && age <= 10)
            {
                System.out.println("Number Of Orphans in Age Group(6 - 10 years): " + orphanAgeGroups[1]++);
            }
            else if(age >= 11 && age <= 15)
            {
                System.out.println("Number Of Orphans in Age Group(11 - 15 years): " + orphanAgeGroups[2]++);
            }
            else if(age >= 16 && age <= 20)
            {
                System.out.println("Number Of Orphans in Age Group(16 - 20 years): " + orphanAgeGroups[3]++);
            }
            else if(age > 20)
            {
                System.out.println("Number Of Orphans in Age Group(20+ years): " + orphanAgeGroups[4]++);
            }
        }
    }

    //METHOD FOR CALCULATING PERCENTAGE OF MALE ORPHANS
    public void calculateMaleOrphansPercentage()
    {
        int maleOrphanCount = 0;
        for(Orphan orphan : orphans)
        {
            if(orphan.getGender().equalsIgnoreCase("Male"))
            {
                maleOrphanCount++;
            }
        }
        double malePercentage =  (double) maleOrphanCount / orphans.size() * 100;
        System.out.println();
        System.out.println("Number Of Male Orphans: " + maleOrphanCount);
        System.out.println("Percentage Of Male Orphans: " + malePercentage + "%");
        System.out.println();
    }

    //METHOD FOR CALCULATING PERCENTAGE OF FEMALE ORPHANS
    public void calculateFemaleOrphansPercentage()
    {
        int femaleOrphanCount = 0;
        for(Orphan orphan : orphans)
        {
            if(orphan.getGender().equalsIgnoreCase("Female"))
            {
                femaleOrphanCount++;
            }
        }
        double femalePercentage =  (double) femaleOrphanCount / orphans.size() * 100;
        System.out.println();
        System.out.println("Number Of Female Orphans: " + femaleOrphanCount);
        System.out.println("Percentage Of Female Orphans: " + femalePercentage + "%");
        System.out.println();
    }

    //METHOD FOR CALCULATING NATIONALITIES OF ORPHANS
    public void calculateNationalitiesOfOrphans()
    {
        int pakistaniNationalityCount = 0;
        int otherNationalityCount = 0;
        for(Orphan orphan : orphans)
        {
            if(orphan.getNationality().equalsIgnoreCase("Pakistani"))
            {
                pakistaniNationalityCount++;
            }
            else
            {
                otherNationalityCount++;
            }
        }
        System.out.println();
        System.out.println("Pakistani Nationality Orphans: " + pakistaniNationalityCount);
        System.out.println("Other Nationality Orphans: " + otherNationalityCount);
        System.out.println();
    }

    //METHOD FOR CALCULATING RELIGIONS OF ORPHANS
    public void calculateReligionsOfOrphans()
    {
        int islamicReligionCount = 0;
        int otherReligionCount = 0;
        for(Orphan orphan : orphans)
        {
            if(orphan.getReligion().equalsIgnoreCase("Islam"))
            {
                islamicReligionCount++;
            }
            else
            {
                otherReligionCount++;
            }
        }
        System.out.println();
        System.out.println("Islamic Religion Orphans: " + islamicReligionCount);
        System.out.println("Other Religion Orphans: " + otherReligionCount);
        System.out.println();
    }

    //METHOD FOR CALCULATING PERCENTAGES OF EDUCATED AND NON-EDUCATED ORPHANS
    public void calculateEducatedAndNonEducatedOrphans() {
        int educatedCount = 0;
        int nonEducatedCount = 0;
        for (Orphan orphan : orphans) {
            if (!orphan.getEducation().getDescription().equalsIgnoreCase("Null") && !orphan.getEducation().getInstitute().equalsIgnoreCase("Null")) {
                educatedCount++;
            } else {
                nonEducatedCount++;
            }
        }
        getEducatedAndNonEducatedCount(educatedCount, nonEducatedCount, orphans.size());
    }

    //METHOD TO CALCULATE SKILLED AND NON-SKILLED ORPHANS
    public void calculateSkilledAndNonSkilledOrphans()
    {
        int skilledOrphansCount = 0;
        int nonSkilledOrphansCount = 0;
        for(Orphan orphan : orphans)
        {
            if(orphan.getSkill() != null)
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
    public void generateStaffReport()
    {
        System.out.println("----------------------------STAFF REPORT-----------------------------");
        totalStaff();
        countStaffByAgeGroups();
        calculateMaleOrphansPercentage();
        calculateFemaleOrphansPercentage();
        calculateNationalitiesOfStaff();
        calculateReligionsOfStaff();
        calculateEducatedAndNonEducatedStaff();
        System.out.println("---------------------------------------------------------------------");
    }

    //METHOD FOR CALCULATING TOTAL NUMBER OF STAFF
    public void totalStaff()
    {
        System.out.println();
        System.out.println("Total Number Of Staff Currently Present: " + staff.size());
        System.out.println();
    }

    //METHOD FOR CALCULATING STAFF ACCORDING TO AGE GROUPS
    //(20-25 YEARS), (26-30 YEARS), (31-35 YEARS), (36-40 YEARS), (40+ YEARS)
    public void countStaffByAgeGroups() {
        int[] staffAgeGroups = new int[5];
        for (Staff staff1 : staff) {
            int age = staff1.getAge();
            if (age >= 20 && age <= 25) {
                System.out.println("Number Of Staff In Age Group(20 - 25 years): " + staffAgeGroups[0]++);
            } else if (age >= 26 && age <= 30) {
                System.out.println("Number Of Staff In Age Group(26 - 30 years): " + staffAgeGroups[1]++);
            } else if (age >= 31 && age <= 35) {
                System.out.println("Number Of Staff In Age Group(31 - 35 years): " + staffAgeGroups[2]++);
            } else if (age >= 36 && age <= 40) {
                System.out.println("Number Of Staff In Age Group(36- 40 years): " + staffAgeGroups[3]++);
            } else if (age > 40) {
                System.out.println("Number Of Staff In Age Group(40+ years): " + staffAgeGroups[4]++);
            }
        }
    }

    //METHOD FOR CALCULATING PERCENTAGE OF MALE STAFF
    public void calculateMaleStaffPercentage()
    {
        int maleStaffCount = 0;
        for(Staff staff1 : staff)
        {
            if(staff1.getGender().equalsIgnoreCase("Male"))
            {
                maleStaffCount++;
            }
        }
        double malePercentage =  (double) maleStaffCount / staff.size() * 100;
        System.out.println();
        System.out.println("Number Of Male Staff: " + maleStaffCount);
        System.out.println("Percentage Of Male Staff: " + malePercentage + "%");
        System.out.println();
    }

    //METHOD FOR CALCULATING PERCENTAGE OF FEMALE STAFF
    public void calculateFemaleStaffPercentage()
    {
        int femaleStaffCount = 0;
        for(Staff staff1 : staff)
        {
            if(staff1.getGender().equalsIgnoreCase("Female"))
            {
                femaleStaffCount++;
            }
        }
        double femalePercentage =  (double) femaleStaffCount / staff.size() * 100;
        System.out.println();
        System.out.println("Number Of Female Staff: " + femaleStaffCount);
        System.out.println("Percentage Of Female Staff: " + femalePercentage + "%");
        System.out.println();
    }

    //METHOD FOR CALCULATING NATIONALITIES OF STAFF
    public void calculateNationalitiesOfStaff()
    {
        int pakistaniNationalityCount = 0;
        int otherNationalityCount = 0;
        for(Staff staff1 : staff)
        {
            if(staff1.getNationality().equalsIgnoreCase("Pakistani"))
            {
                pakistaniNationalityCount++;
            }
            else
            {
                otherNationalityCount++;
            }
        }
        System.out.println();
        System.out.println("Pakistani Nationality Staff: " + pakistaniNationalityCount);
        System.out.println("Other Nationality Staff: " + otherNationalityCount);
        System.out.println();
    }

    //METHOD FOR CALCULATING RELIGIONS OF STAFF
    public void calculateReligionsOfStaff()
    {
        int islamicReligionCount = 0;
        int otherReligionCount = 0;
        for(Staff staff1 : staff)
        {
            if(staff1.getReligion().equalsIgnoreCase("Islam"))
            {
                islamicReligionCount++;
            }
            else
            {
                otherReligionCount++;
            }
        }
        System.out.println();
        System.out.println("Islamic Religion Staff: " + islamicReligionCount);
        System.out.println("Other Religion Staff: " + otherReligionCount);
        System.out.println();
    }

    //METHOD FOR CALCULATING EDUCATED AND NON-EDUCATED STAFF
    public void calculateEducatedAndNonEducatedStaff() {
        int educatedCount = 0;
        int nonEducatedCount = 0;
        for (Staff staff1 : staff) {
            if (!staff1.getEducation().getDescription().equalsIgnoreCase("Null") && !staff1.getEducation().getInstitute().equalsIgnoreCase("Null")) {
                educatedCount++;
            } else {
                nonEducatedCount++;
            }
        }
        getEducatedAndNonEducatedCount(educatedCount, nonEducatedCount, staff.size());
    }

    //METHOD FOR GETTING EDUCATED AND NON-EDUCATED COUNT FOR NON-DUPLICATION PURPOSE
    private void getEducatedAndNonEducatedCount(int educatedCount, int nonEducatedCount, int size) {
        double literacyPercentage = (double) educatedCount / size * 100;
        double illiteracyPercentage = (double) nonEducatedCount / size * 100;

        System.out.println();
        System.out.println("Number Of Educated Orphans: " + educatedCount);
        System.out.println("Number Of Non-Educated Orphans: " + nonEducatedCount);
        System.out.println("Literacy Percentage: " + literacyPercentage + "%");
        System.out.println("Illiteracy Percentage: " + illiteracyPercentage + "%");
        System.out.println();
    }

    //METHOD FOR GENERATING REPORT FOR INVENTORY ITEMS
    public void generateReportForInventoryItems()
    {
        System.out.println();
        System.out.println("------------------------INVENTORY ITEMS REPORT-----------------------");
        System.out.println("Total Number Of Items: " + inventoryItems.size());

        for(InventoryItem inventoryItem : inventoryItems)
        {
            System.out.println("Item ID: " + inventoryItem.getId());
            System.out.println("Item Name: " + inventoryItem.getItemName());
            System.out.println("Item Quantity: " + inventoryItem.getQuantity());

            int usedQuantity = getUsedQuantity(inventoryItem);
            int remainingQuantity = inventoryItem.getQuantity() - usedQuantity;

            System.out.println("Used Quantity: " + usedQuantity);
            System.out.println("Remaining Quantity: " + remainingQuantity);
            System.out.println("Item Description: " + inventoryItem.getDescription());
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------");
    }

    //METHOD FOR CALCULATING QUANTITY OF ITEM BEING USED
    public int getUsedQuantity(InventoryItem inventoryItem)
    {
        return inventoryItem.getQuantity() / 2;
    }

    //METHOD FOR GENERATING DONATIONS REPORT
    public void generateDonationsReport() {
        System.out.println("--------------------------DONATIONS REPORT---------------------------");
        System.out.println("Total Number Of Donations: " + donations.size());

        for (Donation donation : donations) {
            System.out.println("Donation ID: " + donation.getId());
            System.out.println("Donor Name: " + donation.getDonorName());
            System.out.println("Donation Amount: " + donation.getAmount());
            System.out.println("Donation Date: " + donation.getDate());
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------");
    }

    //METHOD FOR GENERATING ACCOUNTS REPORT
    public void generateAccountsReport()
    {
        System.out.println("--------------------------ACCOUNTS REPORT----------------------------");
        System.out.println("Total Accounts Currently Activated: " + accounts.size());

        for(Account account : accounts)
        {
            System.out.println("Account ID: " + account.getId());
            System.out.println("Bank Name: " + account.getBankName());
            System.out.println("Available Balance: " + "Rs. " + account.getBalance());
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
