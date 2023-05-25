public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("Tom", 33);
        Person person2 = new Person("Jane", 23);
        Person person3 = new Person("Sam", 29);
        
        System.out.println(Person.peopleCount());
    }
}