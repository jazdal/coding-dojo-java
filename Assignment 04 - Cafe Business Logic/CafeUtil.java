import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(int numweeks) {
        int total = 0;
        for (int i = 1; i < numweeks + 1; i ++) {
            total += i;
        }
        return total;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0.0;
        for (int i = 0; i < prices.length; i ++) {
            total += prices[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i ++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        } else {
            for (int i = 0; i < menuItems.size(); i ++) {
                System.out.printf("%s %s -- $%.2f \n", i, menuItems.get(i), prices.get(i));
            }
            return true;
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name.");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! \n", userName);
        System.out.printf("There are %s people in front of you. \n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        double discounter = 0.00;
        System.out.println(product);
        for (int i = 1; i < maxQuantity + 1; i ++) {
            System.out.printf("%s - $%.2f \n", i, (i * price) - discounter);
            discounter += 0.50;
        }
        System.out.println("");
    }

    public void addCustomers() {
        ArrayList<String> customerList = new ArrayList<String>();
        while (true) {
            System.out.println("Enter customer name.");
            System.out.println("Otherwise, if you are done, enter 'q'.");
            String customerName = System.console().readLine();
            if (customerName.equals("q")) {
                break;
            } else {
                customerList.add(customerName);
                System.out.println("");
            }
        }
        System.out.printf("\nHere is the list of customers...\n");
        System.out.println(customerList);
        System.out.println("");
    }
}