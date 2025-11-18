import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Genetic Engineering Study Toolkit!");
        System.out.println();
        System.out.println("Would you like to 1) Use the guide RNA generator or 2) Play Enzyme Hangman? (1/2)");
        int choice = scan.nextInt();

        if (choice == 1) {
            GuideRnaGenerator gRna = new GuideRnaGenerator();
            System.out.println("Welcome to the CRISPR Cas-9 Guide RNA Generator!");

            if (choice == 2) {
                System.out.println("Welcome to Enzyme Hangman!");
                System.out.println("You must guess the protein letter by letter related to CRISPR or DNA repair pathways.");
                System.out.println("You will receive a description of the protein once it is correctly guessed!");
                HangmanGame game = new HangmanGame();
                String secretEnzyme = game.selectEnzyme();
                String blanks = game.blankWordGenerator(secretEnzyme);
                System.out.println(secretEnzyme);
                System.out.println(game.evaluateGuesses(secretEnzyme, blanks));
            }


        }
    }
}
