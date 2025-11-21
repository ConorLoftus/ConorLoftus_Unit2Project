import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Genetic Engineering Study Toolkit!");
        System.out.println("-. .-.   .-. .-.   .-. .-.   .  \n" +
                "||\\|||\\ /|||\\|||\\ /|||\\|||\\ /|\n" +
                "|/ \\|||\\|||/ \\|||\\|||/ \\|||\\||\n" +
                "~   `-~ `-`   `-~ `-`   `-~ `--. .-.   .-. .-.   .-. .-.   .  \\n\" +\n" +
                "                \"||\\\\|||\\\\ /|||\\\\|||\\\\ /|||\\\\|||\\\\ /|\\n\" +\n" +
                "                \"|/ \\\\|||\\\\|||/ \\\\|||\\\\|||/ \\\\|||\\\\||\\n\" +\n" +
                "                \"~   `-~ `-`   `-~ `-`   `-~ `-");
        System.out.println();
        System.out.println("Would you like to 1) Use the guide RNA generator or 2) Play Enzyme Hangman? (1 or 2)");
        int choice = scan.nextInt();

        if (choice == 1) {
            GuideRnaGenerator gRna = new GuideRnaGenerator();
            System.out.println("Welcome to the CRISPR-Cas Guide RNA Generator!");
            System.out.println("Cas9 randomly associates and dissociates with the DNA at different PAM (5' NGG 3') locations");
            //should make it so user selects between begining with 3' or 5'
            System.out.println("Enter a DNA sequence. You must first specify directionality.");
            System.out.println("Example: ");
            System.out.println("Do you wish to start with 3' or 5' (type 3 or 5): ");
            String direction = scan.nextLine();
            System.out.println("Great! Now type your DNA sequence, as a series of nucleotides (A, T, C, G), all caps: ");
            String dnaSequence = scan.nextLine();
            if(direction == "3"){
                String finalDnaSequence = "3'"+dnaSequence+"5'";
            }
            if(direction == "5'"){
                String finalDnaSequence = "5'"+dnaSequence+"3'";
            }
            System.out.println("How long will the guide RNA be? (enter integer): ");
            String gRnaLength = scan.nextLine();
            System.out.print("How many nucleotides upstream of PAM will the DNA be cleaved?");
            System.out.println(" Cas9 cuts 3 nucleotide Sequences Upstream of PAM");


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

//ASCII art of DNA sourced from ASCII Art Archive