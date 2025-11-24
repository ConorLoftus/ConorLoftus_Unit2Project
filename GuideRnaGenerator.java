import java.sql.SQLOutput;
import java.util.Scanner;

public class GuideRnaGenerator {
    public static String complementaryBase(String nucleotide){
        if (nucleotide == "A"){
            String compliment ="U";
            return compliment;
        }
        if (nucleotide =="T"){
            String compliment = "A";
            return compliment;
        }
        if (nucleotide =="C"){
            String compliment = "U";
            return compliment;
        }
        if (nucleotide =="G"){
            String compliment = "C";
            return compliment;
        }
        return null;
    }

    public static String locatePam(String sequence){
        if()
    }
}
