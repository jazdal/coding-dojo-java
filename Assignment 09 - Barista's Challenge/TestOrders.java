public class TestOrders {
    public static void main(String[] args) {
        // MENU ITEMS
        Item item1 = new Item("Mocha", 185.50);
        Item item2 = new Item("Latte", 170.30);
        Item item3 = new Item("Drip Coffee", 160.10);
        Item item4 = new Item("Cappuccino", 175.55);

        // 2 ORDERS FOR UNSPECIFIED GUESTS
        Order order1 = new Order();
        Order order2 = new Order();

        // 3 ORDERS WITH NAMES
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Sam");

        // ADD 2 ITEMS TO EACH ORDER
        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item3);
        order2.addItem(item4);

        order3.addItem(item1);
        order3.addItem(item3);

        order4.addItem(item2);
        order4.addItem(item4);

        order5.addItem(item2);
        order5.addItem(item3);

        // TEST THE RESULTS AND DISPLAY METHOD
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        // TEST GETSTATUSMESSAGE FUNCTIONALITY
        System.out.println(order1.getStatusMessage());

        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        // IMPLEMENT GETORDERTOTAL METHOD
        System.out.println(order3.getOrderTotal());
    }
}