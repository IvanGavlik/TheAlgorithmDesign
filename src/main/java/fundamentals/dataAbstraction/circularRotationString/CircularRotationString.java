package fundamentals.dataAbstraction.circularRotationString;

/**

 A string s is a circular rotation of a string t if it matches when the
 characters are circularly shifted by any number of positions; e.g.,
 ACTGACG is a circular shift of TGACGAC, and vice versa.

 Detecting this condition is important in the study of genomic sequences.
 Write a program that checks whether two given strings s and t are circular
 shifts of one another.

 */
public class CircularRotationString {

    public static boolean isCircular(String s1, String s2) {
        if (s1 == null || s2 == null || (s1.length() != s2.length()) ) {
            return false;
        }

        return  s1.concat(s1).indexOf(s2) >= 0;
    }

}
