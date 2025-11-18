import java.util.Scanner;

public class HangmanGame {
    String enzyme1 = ("pepsin");
    String enzyme2 = ("trypsin");
    String enzyme3 = ("kinase");
    String enzyme4 = ("polymerase");
    String enzyme5 = ("amylase");
    String enzyme6 = ("lipase");


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


    public String blankWordGenerator(String enzyme) {
        String blankWord = "";
        for (int i = 0; i < enzyme.length(); i++) {
            blankWord = blankWord + "_";
        }
        return blankWord;
    }


    public String evaluateGuesses(String enzyme, String blankWord) {
        String newBlankWord = "";
        while (newBlankWord != enzyme) {
            String guess = "";
            System.out.print("Input next guess: ");
            guess = new Scanner(System.in).nextLine();
            newBlankWord = "";
            for (int i = 0; i < enzyme.length(); i++)
                if (guess.charAt(0) == enzyme.charAt(i)) {
                    newBlankWord = newBlankWord + guess.charAt(0);
                    System.out.println(newBlankWord);
                } else {
                    newBlankWord = newBlankWord + blankWord.charAt(i);
                    System.out.println(newBlankWord);
                }


        }


        return newBlankWord;
    }
}


