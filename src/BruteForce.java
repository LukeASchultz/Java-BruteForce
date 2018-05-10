import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BruteForce {
    Random rand = new Random();

    String master = "Bruteforce";
    String solution, guessString;
    int numberOfGuesses;

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
        bruteForce.start();
    }

    public void start() {
        findWord();
        System.out.println(Integer.toString(numberOfGuesses));
    }

    public int random(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public void wait(int milliSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliSeconds);
        } catch (InterruptedException ex) {

        }
    }

    public void findWord() {
        numberOfGuesses = 0;
        solution = "";
        guessString = "";

        for (int letter = 0; letter < master.length(); letter++) {
            while (!Character.toString(master.charAt(letter)).equals(guessString)) {
                numberOfGuesses++;
                guessString = Character.toString((char) random(33, 126));
                System.out.println(solution + guessString);

                wait(10);

                if (Character.toString(master.charAt(letter)).equals(guessString)) {
                    solution += guessString;
                }
            }
        }
    }
}
