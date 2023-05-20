public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 3.0;
        double latte = 3.5;
        double cappuccino = 3.4;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean cindhuriOrderReady = true;
        boolean samOrderReady = true;
        boolean jimmyOrderReady = true;
        boolean noahOrderReady = false;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        // ** Your customer interaction print statements will go here ** //
        if (cindhuriOrderReady) {
            System.out.println(customer1 + readyMessage);
        }
        System.out.println("");

        if (noahOrderReady) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + mochaPrice);
        } else {
            System.out.println(customer4 + pendingMessage);
        }
        System.out.println("");

        if (samOrderReady) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + (latte * 2));
        } else {
            System.out.println(customer2 + pendingMessage);
        }
        System.out.println("");

        if (jimmyOrderReady) {
            System.out.println(displayTotalMessage + (latte - dripCoffee) + ", " + customer3);
        }
    }
}
