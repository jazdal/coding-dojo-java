import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        while (randomNumbers.size() < 10) {
            int randomNumber = randMachine.nextInt(20) + 1;
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public char getRandomLetter() {
        ArrayList<Character> letters = new ArrayList<Character>(26);
        for (char letter = 'A'; letter <= 'Z'; letter ++) {
            letters.add(letter);
        }
        return letters.get(randMachine.nextInt(26));
    }

    public String generatePassword() {
        String password = "";
        while (password.length() < 8) {
            password += getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int arrayLength) {
        ArrayList<String> passwordArray = new ArrayList<String>();
        while (passwordArray.size() < arrayLength) {
            passwordArray.add(generatePassword());
        }
        return passwordArray;
    }

    public ArrayList<Object> shuffleArray(ArrayList<Object> inputArray) {
        ArrayList<Object> scrambledArray = new ArrayList<Object>();
        ArrayList<Integer> scrambledArrayIndex = new ArrayList<Integer>();

        while (scrambledArrayIndex.size() < inputArray.size()) {
            Integer randomIndex = randMachine.nextInt(inputArray.size());
            if (!scrambledArrayIndex.contains(randomIndex)) {
                scrambledArrayIndex.add(randomIndex);
            }
        }
        for (int i = 0; i < scrambledArrayIndex.size(); i ++) {
            scrambledArray.add(inputArray.get(scrambledArrayIndex.get(i)));
        }
        return scrambledArray;
    }
}