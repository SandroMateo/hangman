import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console console = System.console();

    System.out.println("Let's play Hangman!");
    System.out.println("Enter a phrase for others to guess:");
    String inputHiddenPhrase = console.readLine();

    Hangman game = new Hangman(inputHiddenPhrase);

    System.out.println(game.stringToDashes());
    System.out.println("Start guessing!");

    while(game.getBlankedWord().contains("-") && game.getGuessCount() <= 6) {
      String inputStringGuess = console.readLine();
      char inputGuess = inputStringGuess.charAt(0);
      System.out.println(game.stringContainsChar(inputGuess));
      if(game.getBlankedWord().contains("-") && game.getGuessCount() <= 6) {
        System.out.println("Guess Again!");
      }
    }
    if(!game.getBlankedWord().contains("-")) {
      System.out.println("You Win!");
    } else {
      System.out.println("You killed the hangman...");
    }
  }
}
