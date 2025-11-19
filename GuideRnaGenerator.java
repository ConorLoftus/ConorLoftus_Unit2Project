import java.sql.SQLOutput;
import java.util.Scanner;

public class GuideRnaGenerator {
    public void promptUser(){

        Scanner scan = new Scanner(System.in);

        //should make it so user selects between begining with 3' or 5'
        System.out.println("Enter a DNA sequence. Specify directionality by writing 3' and 5' on each end, no spaces: ");
        System.out.println("Example: ");
        String dnaSequence = scan.nextLine();
        System.out.println("How long will the guide RNA be? (enter integer) ");
        String gRnaLength = scan.nextLine();
        System.out.print("How many nucleotides upstream of PAM will the DNA be cleaved?");
        System.out.println(" Cas9 cuts 3 nucleotide Sequences Upstream of PAM");

        //remember T ---> U
        if (dnaSequence.indexOf("3'")==0 && dnaSequence.indexOf("5'")==dnaSequence.length()-1){

        }
        if (dnaSequence.indexOf("3'")==0 && dnaSequence.indexOf("5'")==dnaSequence.length()-1){

        }
        else{
            System.out.println("The DNA sequence is not correctly formatted. Begin and end your sequence with either 3' or 5'");
        }
    }
}
