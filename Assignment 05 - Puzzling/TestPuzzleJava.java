import java.util.ArrayList;

public class TestPuzzleJava {
    public static void main(String[] args) {
        PuzzleJava appTest = new PuzzleJava();

        System.out.println(appTest.getTenRolls());
        System.out.println("");
        System.out.println(appTest.getRandomLetter());
        System.out.println("");
        System.out.println(appTest.generatePassword());
        System.out.println("");
        System.out.println(appTest.getNewPasswordSet(8));
        System.out.println("");

        ArrayList<Object> rick = new ArrayList<Object>() {{
            add("never");
            add("gonna");
            add("give");
            add("you");
            add("up");
            add("never");
            add("gonna");
            add("let");
            add("you");
            add("down");
        }};

        System.out.println(appTest.shuffleArray(rick));
    }
}
