import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BruteForce {

    String master = "Bruteforce";
    String solution;

    Random rand = new Random();
    String[] possibleGuesses = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M",
                                "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m",
                                " ", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", ",", ":", ":", "\n"};

    String guessString;
    int guessInt;

    boolean goOn = false;

    int numberOfGuesses;

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
        bruteForce.start();
    }

    public void start() {
        for (int i = 0; i < 10; i++) {
            findWord();
            System.out.println(Integer.toString(numberOfGuesses));
        }
    }

    public int random(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public void findWord() {
        numberOfGuesses = 0;
        solution = "";
        guessInt = -1;
        guessString = "null";


        for (int letter = 0; letter < master.length(); letter++) {
            while (!Character.toString(master.charAt(letter)).equals(guessString)) {
                if (!goOn) {
                    /*try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException ex) {

                    }*/

                    guessInt = random(0, possibleGuesses.length - 1);
                    guessString = possibleGuesses[guessInt];
                    //System.out.println(solution + guessString);
                    numberOfGuesses++;

                    if (Character.toString(master.charAt(letter)).equals(guessString)) {
                        solution += guessString;
                        goOn = true;
                    }
                }
                goOn = false;
                if (solution.equals(master)) {
                    break;
                }

            }
        }
    }
}
