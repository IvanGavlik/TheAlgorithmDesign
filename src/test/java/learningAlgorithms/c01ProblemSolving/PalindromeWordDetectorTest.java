package learningAlgorithms.c01ProblemSolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalindromeWordDetectorTest {

  private PalindromeWordDetector palindromeWordDetector;

  @BeforeEach
  void init() {
    this.palindromeWordDetector = new PalindromeWordDetector();
  }
  @Test
  void illegalInput() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> palindromeWordDetector.isPalindrome(null));

    Assertions.assertThrows(IllegalArgumentException.class,
        () -> palindromeWordDetector.isPalindrome(""));
  }

  @Test
  void palindrome() {
    Assertions.assertTrue(palindromeWordDetector.isPalindrome("civic"));
    Assertions.assertTrue(palindromeWordDetector.isPalindrome("noon"));
    Assertions.assertTrue(palindromeWordDetector.isPalindrome("level"));
    Assertions.assertTrue(palindromeWordDetector.isPalindrome("radar"));
    Assertions.assertTrue(palindromeWordDetector.isPalindrome("aibohphobia"));
    Assertions.assertTrue(palindromeWordDetector.isPalindrome("level"));
  }

  @Test
  void notPalindrome() {
    Assertions.assertFalse(palindromeWordDetector.isPalindrome("a"));
    Assertions.assertFalse(palindromeWordDetector.isPalindrome("decal"));
    Assertions.assertFalse(palindromeWordDetector.isPalindrome("draw"));
    Assertions.assertFalse(palindromeWordDetector.isPalindrome("deer"));
  }


}
