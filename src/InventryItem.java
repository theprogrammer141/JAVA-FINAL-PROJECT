import java.util.Scanner;
//methods with similar working as in donation class
public class InventryItem {
    private int itemID;
    private String itemName;
    private double itemPrice;
    private int quantity;
    public InventryItem(){}

    public static void addItem(OOM organization){
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        System.out.println("---Enter Item details---");

        InventryItem item=new InventryItem();
        item.setItemID(organization.getItemsList().size()+1);

        System.out.print("Enter item name: ");
        item.setItemName(inputString.nextLine());

        System.out.print("Enter item Price: ");
        item.setItemPrice(input.nextDouble());

        System.out.print("Enter Quantity: ");
        item.setQuantity(input.nextInt());

        organization.getItemsList().add(item);

        System.out.println("Item added successfully!");

    }
    public static void removeItem(OOM organization){
        System.out.print("Enter Item id to remove: ");
        Scanner input=new Scanner(System.in);
        int id= input.nextInt();
        boolean flag=false;
        for(InventryItem item: organization.getItemsList()) {
            if (item.getItemID() == id) {
                flag = true;
                item.displayData();
                System.out.print("Are you sure you want to delete this Item?\n\"Enter 1 to continue\": ");
                int choice = input.nextInt();
                if (choice == 1) {
                    organization.getItemsList().remove(item);
                    System.out.println("Item removed successfully!");
                    return;
                }
            }
        }
        if (!flag){
            System.out.println("Item not found!");
        }
    }
    public static void updateRecord(OOM organization) {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        System.out.print("Enter Item ID to update record: ");
        int id = input.nextInt();

        for (InventryItem item : organization.getItemsList()) {
            if (item.getItemID() == id) {
                System.out.println("Enter attribute to update record: ");
                System.out.println("1: Name");
                System.out.println("2: Price");
                System.out.println("3: Quantity");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Previous name is: "+item.getItemName());
                        System.out.print("Enter new name: ");
                        item.setItemName(inputString.nextLine());
                        return;
                    case 2:
                        System.out.println("Previous Price is: " + item.getItemPrice());
                        System.out.print("Enter new price: ");
                        item.setItemPrice(input.nextDouble());
                        return;
                    case 3:
                        System.out.println("Previous Quantity is: " + item.getQuantity());
                        System.out.print("Enter new Quantity: ");
                        item.setQuantity(input.nextInt());
                        return;
                    default:
                        System.out.println("Make a valid choice!");
                }
            }
        }
            System.out.println("Item not found!");
    }
    public void displayData(){
        System.out.printf("---Printing details for item %d---\n",this.getItemID());
        System.out.println("Item Name: "+this.getItemName());
        System.out.println("Item Price: "+this.getItemPrice());
        System.out.println("Item Quantity: "+this.getQuantity());
    }
    public static void viewItem(OOM organization){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter ID to view item: ");
        int id= input.nextInt();
        boolean flag=false;
        for(InventryItem item: organization.getItemsList()){
            if(item.getItemID()==id){
                flag=true;
                item.displayData();
            }
        }
        if (!flag){
            System.out.println("Item not found!");
        }
    }


    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
