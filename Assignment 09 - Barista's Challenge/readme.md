# Java Stack Coding Dojo
# Assignment 09: Barista's Challenge

## Learning Objectives:
- Adding methods to object-oriented classes (custom data types)
- Implementing constructors
- Implementing setters and getters
- Practice how to use the *private* access modifier

## Tasks:
- Implement the Order and Item classes as described.
- Create a testing file and complete the following tests.
- Create 2 orders for unspecified guests (without specifying a name).
- Create 3 orders using the overloaded constructor to give each a name for the order.
- Add at least 2 items to each of the orders using the addItem method you wrote, for example, to add item1 to order3 you would need to call the addItem methods from the order3 instance like so: order3.addItem(item1).
- Test the results and the display method by calling the display method on all of your orders, like so: order3.display().
- Test your getStatusMessage functionality by setting some orders to ready and printing the messages for each order. For example: order2.setReady(true); System.out.println(order2.getStatusMessage());
- Implement the getOrderTotal method within the Order class.
- Test the total by printing the return value like so: System.out.println(order1.getOrderTotal());
- Implement the display method within the Order class.
- Finally, call the display method on all of your orders, like so: order3.display().