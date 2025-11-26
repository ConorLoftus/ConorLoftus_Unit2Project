import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to the Genetic Engineering Study Toolkit!");
        System.out.println("-. .-.   .-. .-.   .-. .-.   .  \n" +
                "||\\|||\\ /|||\\|||\\ /|||\\|||\\ /|\n" +
                "|/ \\|||\\|||/ \\|||\\|||/ \\|||\\||\n" +
                "~   `-~ `-`   `-~ `-`   `-~ `-");
        System.out.println();


        System.out.println("Would you like to 1) Use the guide RNA generator or 2) Play Enzyme Hangman? (1 or 2)");
        int choice = scan.nextInt();
        scan.nextLine();


        if (choice == 1) {
            System.out.println("Welcome to the CRISPR-Cas Guide RNA Generator!");
            System.out.println("Cas9 randomly associates and dissociates with DNA at different PAM (5' NGG 3') locations.");
            System.out.println("Enter a DNA sequence. You must first specify directionality.");


            System.out.print("Do you wish to start with 3' or 5' (type 3 or 5): ");
            String direction = scan.nextLine().trim();


            System.out.print("Great! Now type your DNA sequence, as a series of nucleotides (A, T, C, G), all caps: ");
            String dnaSequence = scan.nextLine().trim();

//adds 3' and 5' to each end of the sequence
            String finalDnaSequence = "";
            if (direction.equals("3")) {
                finalDnaSequence = "3'" + dnaSequence + "5'";
            } else if (direction.equals("5")) {
                finalDnaSequence = "5'" + dnaSequence + "3'";
            } else {
                System.out.println("Invalid direction. Please restart and enter 3 or 5.");
                return;
            }


            System.out.print("How long will the guide RNA be? (enter integer): ");
            int gRnaLength = scan.nextInt();


            String pam = GuideRnaGenerator.identifyPam(finalDnaSequence);


            if (pam == null) {
                System.out.println("No NGG PAM found in your sequence. Cannot generate a guide RNA.");
                return;
            }


            String guideRna = GuideRnaGenerator.createGuideRna(finalDnaSequence, gRnaLength);


            if (guideRna == null) {
                System.out.println("A PAM was found, but there are not enough bases upstream");
                System.out.println("to make a guide RNA of length " + gRnaLength + ".");
                return;
            }


            String complementary = GuideRnaGenerator.complementaryStrand(finalDnaSequence);

//prints results
            System.out.println("\n--- GUIDE RNA DESIGN RESULTS ---");
            System.out.println("Input DNA (with direction): " + finalDnaSequence);
            System.out.println("Reverse Complementary strand: " + complementary);
            System.out.println("PAM (5' NGG 3' ) identified: " + pam);
            System.out.println("Guide RNA spacer (" + gRnaLength + " nucleotides, 3'->5'): " + guideRna);


        } else if (choice == 2) {
            System.out.println("Welcome to Enzyme Hangman!");
            System.out.println("You must guess the protein letter by letter.");
            System.out.println("You will receive a description of the protein once it is correctly guessed!");


            HangmanGame game = new HangmanGame();
            String secretEnzyme = game.selectEnzyme();
            String blanks = game.blankWordGenerator(secretEnzyme);
            System.out.println(blanks);
            System.out.println(game.evaluateGuesses(secretEnzyme, blanks));
        } else {
            System.out.println("Invalid choice. Please restart and enter 1 or 2.");
        }
    }
}
