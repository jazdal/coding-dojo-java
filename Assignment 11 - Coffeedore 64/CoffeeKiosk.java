import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
        newItem.setIndex(menu.indexOf(newItem));
    }

    public void displayMenu() {
        for (Item item: menu) {
            System.out.printf("%s %s -- $%.2f \n", item.getIndex(), item.getName(), item.getPrice());
        }
    }

    public void newOrder() {
        System.out.println("Please enter customer name for new order: ");
        String name = System.console().readLine();
        String itemNumber = "";
        
        Order order = new Order(name);

        while (!itemNumber.equals("q")) {
            displayMenu();
            System.out.println("Please enter a menu item index or 'q' to quit:\n");
            itemNumber = System.console().readLine();

            try {
                order.addItem(menu.get(Integer.parseInt(itemNumber)));
            } catch(IndexOutOfBoundsException e) {
                System.out.println("Invalid choice. Please enter a number from the menu or 'q' to quit.\n");
            } catch(NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number from the menu or 'q' to quit.\n");
            }
        }
        order.display();
    }

    public void addMenuItemByInput() {
        String reply = "y";

        while(!reply.equalsIgnoreCase("n")) {
            System.out.println("Please enter the name of the new menu item:");
            String newMenuItem = System.console().readLine();
            System.out.println("Set the price of the new menu item:");
            String priceOfNewMenuItem = System.console().readLine();

            try {
                addMenuItem(newMenuItem, Double.parseDouble(priceOfNewMenuItem));
            } catch(NumberFormatException e) {
                System.out.println("Error: Invalid price input. Please enter a number in decimal format.");
            }
            System.out.println("Would you like to add another menu item? (y/n)");
            reply = System.console().readLine();

        }
        System.out.println("Here is your updated menu:");
        displayMenu();
    }
}
