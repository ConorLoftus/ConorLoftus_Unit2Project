import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Genetic Engineering Study Toolkit!");
        System.out.println();
        System.out.println("Would you like to 1) Use the guide RNA generator or 2) Play Enzyme Hangman? (1 or 2)");
        int choice = scan.nextInt();

        if (choice == 1) {
            GuideRnaGenerator gRna = new GuideRnaGenerator();
            System.out.println("Welcome to the CRISPR-Cas Guide RNA Generator!");
            System.out.println("Cas9 randomly associates and dissociates with the DNA until it recognizes and binds to a PAM sequence. In humans,  PAM sequences (5’ NGG 3’) occur about 1 in every 50 bases or less.");



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
