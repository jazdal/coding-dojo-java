# Java Stack Coding Dojo
# Assignment 10: BankAccount

## Learning Objectives:
- Practice member variables
- Practice instance methods and getters and setters
- Implement static variables and methods

## Tasks:
- Create a BankAccount class.
- The class should have the following attributes: (double) checking balance, (double) saving balance.
- Create a class member (static) that has the number of accounts created thus far.
- Create a class member (static) that tracks the total amount of money stored in every account created.
- In the constructor, be sure to increment the account count.
- Create a getter method for the user's checking account balance.
- Create a getter method for the user's saving account balance.
- Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
- Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funcds.
- Create a method to see the total money from the checking and saving.
- Users should not be able to set any of the attributes from the class.
- Create a 'TestBankAccount' class to test each BankAccount method you have created.
- NINJA BONUS: Add the following class attribute: account number. The type is up to you, can be a String or a Long or another type.
- NINJA BONUS: Create a private method that returns a random ten digit account number.
- NINJA BONUS: In the constructor, call the private method from above so that each user has a random ten digit account.