import org.junit.*;
import static org.junit.Assert.*;

public class HangmanTest {

  @Test
  public void Hangman_instantiatesCorrectly() {
    Hangman testHangman = new Hangman("hello");
    assertEquals(true, testHangman instanceof Hangman);
  }

  @Test
  public void Hangman_getHiddenWord_hello() {
    Hangman testHangman = new Hangman("hello");
    assertEquals("hello", testHangman.getHiddenWord());
  }

  @Test
  public void Hangman_stringToDashes_dash() {
    Hangman testHangman = new Hangman("a");
    assertEquals("-", testHangman.stringToDashes());
  }

  @Test
  public void Hangman_getBlankedWord_blanks() {
    Hangman testHangman = new Hangman("hello");
    testHangman.stringToDashes();
    assertEquals("-----", testHangman.getBlankedWord());
  }

  @Test
  public void Hangman_getGuessCount_0() {
    Hangman testHangman = new Hangman("hello");
    assertEquals(0, testHangman.getGuessCount());
  }

  @Test
  public void Hangman_stringToDashesWithSpaces_dash() {
    Hangman testHangman = new Hangman("a a");
    assertEquals("- -", testHangman.stringToDashes());
  }

  @Test
  public void Hangman_stringContainsChar_aDash() {
    Hangman testHangman = new Hangman("at");
    testHangman.stringToDashes();
    assertEquals("a-", testHangman.stringContainsChar('a'));
  }

  @Test
  public void Hangman_stringContainsChar_aDashWithSpace() {
    Hangman testHangman = new Hangman("at all");
    testHangman.stringToDashes();
    assertEquals("a- a--", testHangman.stringContainsChar('a'));
  }



}
