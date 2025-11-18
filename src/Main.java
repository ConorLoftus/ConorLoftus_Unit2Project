import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Genetic Engineering Study Toolkit!");
        System.out.println();
        System.out.println("Would you like to 1) Use the guide RNA generator or 2) Play Enzyme Hangman? (1/2)");


            HangmanGame game = new HangmanGame();
            String secretEnzyme = game.selectEnzyme();
            String blanks = game.blankWordGenerator(secretEnzyme);
            System.out.println(secretEnzyme);
            System.out.println(game.evaluateGuesses(secretEnzyme, blanks));
        }
    }
