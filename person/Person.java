public class Person {
    // MEMBER VARIABLES
    private int age;
    private String name;

    // STATIC VARIABLE (BELONGS TO THE CLASS ITSELF, NOT THE INSTANCE OF THE CLASS)
    private static int numberOfPeople = 0;

    // CONSTRUCTOR
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfPeople++;
    }

    public void objectMethods(Person anotherObject) {
        System.out.println("Class name: " + this.getClass().getSimpleName());
        System.out.println("toString: " + this.toString());
        System.out.println("Equals: " + this.equals(anotherObject));
    }

    // STATIC METHOD (CLASS METHOD - CANNOT ACCESS INSTANCE VARIABLES ('THIS') AND METHODS DIRECTLY)
    public static int peopleCount() {
        return numberOfPeople;
    }
}