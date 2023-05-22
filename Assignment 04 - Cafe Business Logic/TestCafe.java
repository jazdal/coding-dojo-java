import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil appTest = new CafeUtil();

        /* ============ App Test Cases ============= */
        
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(10));

        System.out.println("----- Order Total Test -----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n", appTest.getOrderTotal(lineItems));

        System.out.println("----- Display Menu Test -----");
        ArrayList<String> menu = new ArrayList<String>() {{
            add("Drip Coffee");
            add("Cappuccino");
            add("Latte");
            add("Mocha");
        }};
        appTest.displayMenu(menu);
        System.out.println("");

        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i ++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        System.out.println("----- Print Price Chart Test -----");
        appTest.printPriceChart("Columbian Coffee Grounds", 2.00, 4);

        System.out.println("----- Display Menu Test 2 -----");
        ArrayList<String> menu2 = new ArrayList<String>() {{
            add("Drip Coffee");
            add("Cappuccino");
            add("Latte");
            add("Mocha");
        }};
        ArrayList<Double> itemPrices = new ArrayList<Double>() {{
            add(1.50);
            add(3.50);
            add(4.50);
            add(3.50);
        }};
        appTest.displayMenu(menu2, itemPrices);
        System.out.println("");

        appTest.addCustomers();
    }
}