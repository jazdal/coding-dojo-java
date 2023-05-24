import java.util.ArrayList;

public class ExceptionList {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>() {{
            add("13");
            add("hello world");
            add(48);
            add("Goodbye world");
        }};

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(castedValue);
            } catch (ClassCastException e) {
                System.out.printf("\nOops. Error %s at index %s with value '%s'\n\n", e, i, myList.get(i));
            }
        }
    }
}