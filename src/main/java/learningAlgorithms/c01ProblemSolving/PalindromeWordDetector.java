package learningAlgorithms.c01ProblemSolving;

/**
 * Palindrome word detector: A palindrome word reads the same backward as forward,
 * such as madam. Devise an algorithm that validates whether a word of
 * N characters is a palindrome.
 */
public class PalindromeWordDetector {

  public boolean isPalindrome(String word) {
    if (word == null || word.isEmpty()) {
      throw new IllegalArgumentException();
    }

    if(word.length() == 1) {
      return false;
    }

    int characterLeft  = startCenterLeft(word);
    for(int characterRight = isOdd(word) ? startCenter(word) : startCenterRight(word); characterRight < word.length(); characterRight++) {
          char cl = word.charAt(characterLeft);
          characterLeft  = characterLeft -  1;
          char cr = word.charAt(characterRight);

          if (cl != cr) {
            return false;
          }
    }

    return true;
  }

  private static int startCenterLeft(String word) {
    return (word.length() / 2) - 1;
  }

  private static int startCenterRight(String word) {
    return (word.length() / 2) + 1;
  }

  private static int startCenter(String word) {
    return word.length() / 2;
  }

  private static boolean isOdd(String word) {
    return word.length() % 2 == 0;
  }

}
