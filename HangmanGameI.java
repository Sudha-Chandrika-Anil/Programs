import java.util.Scanner;

public class HangmanGameI {
    private static final String[] WORDS = {"java", "programming", "computer", "hangman", "code", "algorithm"};
    private static final int MAX_TRIES = 6;

    private String wordToGuess;
    private char[] guessedLetters;
    private int triesLeft;

    public HangmanGameI() {
        wordToGuess = WORDS[(int) (Math.random() * WORDS.length)];
        guessedLetters = new char[wordToGuess.length()];
        triesLeft = MAX_TRIES;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (triesLeft > 0 && !isWordGuessed()) {
            System.out.println("Word: " + getCurrentGuess());
            System.out.println("Tries left: " + triesLeft);
            System.out.println("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (!checkGuess(guess)) {
                printHangman(MAX_TRIES - triesLeft + 1);
                triesLeft--;
            }
        }

        if (isWordGuessed()) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you've run out of tries. The word was: " + wordToGuess);
        }
    }

    private boolean checkGuess(char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedLetters[i] = guess;
                correctGuess = true;
            }
        }
        if (!correctGuess) {
            System.out.println("Incorrect guess: " + guess);
        }
        return correctGuess;
    }

    private String getCurrentGuess() {
        StringBuilder currentGuess = new StringBuilder();
        for (char c : guessedLetters) {
            currentGuess.append(c == '\0' ? '_' : c);
            currentGuess.append(' ');
        }
        return currentGuess.toString();
    }

    private boolean isWordGuessed() {
        for (char c : guessedLetters) {
            if (c == '\0') {
                return false;
            }
        }
        return true;
    }

    private void printHangman(int attempts) {
        switch (attempts) {
            case 1:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" O    |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 2:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" O    |");
                System.out.println(" |    |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 3:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" O    |");
                System.out.println("/|    |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 4:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" O    |");
                System.out.println("/|\\   |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 5:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" O    |");
                System.out.println("/|\\   |");
                System.out.println("/     |");
                System.out.println("      |");
                break;
            case 6:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" O    |");
                System.out.println("/|\\   |");
                System.out.println("/ \\   |");
                System.out.println("      |");
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hangman!");
        HangmanGame game = new HangmanGame();
        game.play();
    }
}
