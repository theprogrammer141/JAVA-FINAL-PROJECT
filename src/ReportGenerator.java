public class ReportGenerator {
    public ReportGenerator(OOM organization) {
        /*
        When an object of this class is created this constructor displays all stored data
        by calling respective methods of different classes*/
        for (Staff employee: organization.getStaffList())
            employee.displayData();
        for (Orphan child: organization.getOrphansList())
            child.displayData();
        for (Donation dono: organization.getDonationsList())
            dono.displayData();
        for (InventryItem item: organization.getItemsList())
            item.displayData();
        organization.getBankAccount().displayAccount();
    }
}
