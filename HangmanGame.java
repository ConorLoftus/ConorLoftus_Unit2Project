import java.util.Scanner;


public class HangmanGame {
    String enzyme1 = ("pepsin");
    String enzyme2 = ("trypsin");
    String enzyme3 = ("kinase");
    String enzyme4 = ("polymerase");
    String enzyme5 = ("amylase");
    String enzyme6 = ("lipase");

//randomly selects enzyme, 1-6
    public String selectEnzyme() {
        int enzymeIndex = (int) (Math.random() * 6) + 1;
        String enzyme = "";


        if (enzymeIndex == 1) {
            enzyme = enzyme1;
        }
        if (enzymeIndex == 2) {
            enzyme = enzyme2;
        }
        if (enzymeIndex == 3) {
            enzyme = enzyme3;
        }
        if (enzymeIndex == 4) {
            enzyme = enzyme4;
        }
        if (enzymeIndex == 5) {
            enzyme = enzyme5;
        }
        if (enzymeIndex == 6) {
            enzyme = enzyme6;
        }
        return enzyme;
    }



//makes blankWord. which is a string with underscores of equal length of the secret word
    public String blankWordGenerator(String enzyme) {
        String blankWord = "";
        for (int i = 0; i < enzyme.length(); i++) {
            blankWord = blankWord + "_";
        }
        return blankWord;
    }


    public String evaluateGuesses(String enzyme, String blankWord) {
        Scanner scan = new Scanner(System.in);
        String newBlankWord = "";
        int lives = 5;
        while (!newBlankWord.equals(enzyme)&&lives>0) {
            System.out.println("Lives remaining: " + lives);
            System.out.print("Input guess (one letter): ");
            String guess = scan.nextLine();
            char guessChar = guess.charAt(0);
            newBlankWord = "";
            //adds letter if gussed correctly, _ if not
            for (int i = 0; i < enzyme.length(); i++)
                if (guess.charAt(0) == enzyme.charAt(i)) {
                    newBlankWord = newBlankWord + guessChar;
                } else {
                    newBlankWord = newBlankWord + blankWord.charAt(i);
                }
            System.out.println("Current word: " + newBlankWord);
            //subtracts lives if newBlankWord is still blank
            if (newBlankWord.equals(blankWord)) {
                lives--;
            }
            //resets blankWord so lives system works
            blankWord = newBlankWord;
        }

        //when game ends, reveals enzyme and definition
        System.out.println("The enzyme was: "+enzyme);
        if (enzyme.equals("pepsin")) {
            System.out.println("Pepsin is a digestive enzyme in the stomach that breaks down proteins into smaller peptides, working best in very acidic conditions.");
        }
        if (enzyme.equals("trypsin")) {
            System.out.println("Trypsin is a digestive enzyme in the small intestine that splits proteins into amino acids and peptides, activated from its precursor trypsinogen.");
        }
        if (enzyme.equals("kinase")) {
            System.out.println("A kinase is an enzyme that transfers phosphate groups from ATP to other molecules (usually proteins), turning cell signals and pathways on or off.");
        }
        if (enzyme.equals("polymerase")) {
            System.out.println("A polymerase is an enzyme that builds long chains of nucleic acids, such as DNA or RNA, during replication or transcription.");
        }
        if (enzyme.equals("amylase")) {
            System.out.println("Amylase is a digestive enzyme in saliva and the pancreas that breaks starch and glycogen into sugars like maltose and glucose.");
        }
        if (enzyme.equals("lipase")) {
            System.out.println("Lipase is an enzyme that breaks down dietary fats (lipids) into fatty acids and glycerol, mainly in the small intestine.");
        }
        return "";
    }
}
