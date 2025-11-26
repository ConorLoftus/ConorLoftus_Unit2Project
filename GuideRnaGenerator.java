public class GuideRnaGenerator {

    //creates complementary bases to be used for reverse compliment and gRNA
    public static String complementaryBase(String nucleotide) {
        if (nucleotide.equals("A")) {
            return "U";
        }
        if (nucleotide.equals("T")) {
            return "A";
        }
        if (nucleotide.equals("C")) {
            return "G";
        }
        if (nucleotide.equals("G")) {
            return "C";
        }
        return "";
    }

//returns substring of sequence that represents pam
    public static String identifyPam(String sequence) {
        if (sequence.charAt(0) == '3') {
            for (int i = 1; i < sequence.length()-2; i++) {
                if (sequence.charAt(i) == 'G' && sequence.charAt(i + 1) == 'G') {
                    String pamSequence = sequence.substring(i, i + 3);
                    return pamSequence;
                }
            }
        }
        if (sequence.charAt(0) == '5') {
            for (int i = 1; i < sequence.length()-2; i++) {
                if (sequence.charAt(i) == 'G' && sequence.charAt(i + 1) == 'G') {
                    String pamSequence = sequence.substring(i - 1, i + 2);
                    return pamSequence;
                }
            }
        }
        return null;
    }

//returns index of pam in sequence
    public static int locatePam(String sequence) {
        if (sequence.charAt(0) == '3') {
            for (int i = 1; i < sequence.length()-1; i++) {
                if (sequence.charAt(i) == 'G' && sequence.charAt(i + 1) == 'G') {
                    int pamIndex = i;
                    return pamIndex;
                }
            }
        }
        if (sequence.charAt(0) == '5') {
            for (int i = 1; i < sequence.length()-1; i++) {
                if (sequence.charAt(i) == 'G' && sequence.charAt(i + 1) == 'G') {
                    int pamIndex = i - 1;
                    return pamIndex;
                }
            }
        }
        return -1;
    }

//returns reverse compliment
    public static String complementaryStrand(String sequence) {
        String result = "";


        for (int i = sequence.length() - 1; i >= 0; i--) {
            char base = sequence.charAt(i);
            if (base == '3') {
                result += "5'";
            }
            else if (base == '5') {
                result += "3'";
            }
            else if (base == '\'' ) {
            }
            else {
                result += complementaryBase(String.valueOf(base));
            }
        }
        return result;
    }

//returns guide RNA
    public static String createGuideRna(String sequence,int guideRnaLength){
        int pamIndex = locatePam(sequence);
        if (pamIndex == -1) {
            String nullStatement = "No PAM sequence, so DNA can not be cleaved";
            return nullStatement;
        }
        //reverses sequence
        if (sequence.charAt(0) == '3') {
            String reversed = "";
            for (int i = sequence.length() - 1; i >= 0; i--) {
                char placeholder = sequence.charAt(i);
                if (placeholder == '\'') {
                    continue;
                }
                reversed = reversed + placeholder;
            }
            sequence = reversed;
            pamIndex = locatePam(sequence);
        }
        //creates complimentary strand with length of protospacer, which is the bases before PAM
        int startingIndex = pamIndex - guideRnaLength;
        if (startingIndex < 0) {
            return "Not enough sequence before PAM to make a guide RNA of length "+guideRnaLength;
        }
        String protospacer = sequence.substring(startingIndex, pamIndex);
        String guideRna = "3'";
        for (int i = protospacer.length()-1; i >= 0; i--) {
            char base = protospacer.charAt(i);
            if (base == '3'||base == '5'||base == '\'') {
                continue;
            }
            if(base=='T'){
                guideRna+='U';
            }
            else {
                guideRna += (String.valueOf(base));
            }
        }
        guideRna += "5'";
        return guideRna;
    }
}
