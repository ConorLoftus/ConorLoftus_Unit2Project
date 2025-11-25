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


    public static String identifyPam(String sequence){
        if(sequence.charAt(0)=='3'){
            for (int i=1;i<sequence.length();i++){
                if(sequence.charAt(i)=='G'&&sequence.charAt(i+1)=='G'){
                    String pamSequence =  sequence.substring(i,i+2);
                    return pamSequence;
                }
            }
        }
        if(sequence.charAt(0)=='5'){
            for (int i=1;i<sequence.length();i++){
                if(sequence.charAt(i)=='G'&&sequence.charAt(i+1)=='G'){
                    String pamSequence =  sequence.substring(i-1,i+1);
                    return pamSequence;
                }
            }
        }
        return null;
    }

    public static int locatePam(String sequence){
        if(sequence.charAt(0)=='3'){
            for (int i=1;i<sequence.length();i++){
                if(sequence.charAt(i)=='G'&&sequence.charAt(i+1)=='G'){
                    int pamIndex = i;
                    return pamIndex;
                }
            }
        }
        if(sequence.charAt(0)=='5'){
            for (int i=1;i<sequence.length();i++){
                if(sequence.charAt(i)=='G'&&sequence.charAt(i+1)=='G'){
                    int pamIndex = i-1;
                    return pamIndex;
                }
            }
        }
        return 0;
    }

    public static String complementaryStrand(String sequence){
        String complementaryStrand = "";
        for (int i=sequence.length()-1; i>=0;i--){
            char base = sequence.charAt(i);
            if (String.valueOf(base)=="3"){
                complementaryStrand+=3;
            }
            if (String.valueOf(base)=="5"){
                complementaryStrand+="5";
            }
            complementaryStrand+=complementaryBase(String.valueOf(base));
        }
        return complementaryStrand;
    }
}
