import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console console = System.console();

    String gameChoice = "";
    String gameDifficulty = "";
    String inputHiddenPhrase = "";

    System.out.println("Let's play Hangman!");

    while(!gameChoice.equalsIgnoreCase("single player") && !gameChoice.equalsIgnoreCase("multiplayer")) {
      System.out.println("Choose 'single player' or 'multiplayer'.");
      gameChoice = console.readLine();

      if (gameChoice.equalsIgnoreCase("multiplayer")) {
        System.out.println("Enter a phrase for others to guess:");
        inputHiddenPhrase = console.readLine();

      } else if (gameChoice.equalsIgnoreCase("single player")) {

        while(!gameDifficulty.equalsIgnoreCase("Easy") && !gameDifficulty.equalsIgnoreCase("Medium") && !gameDifficulty.equalsIgnoreCase("Hard")) {
          System.out.println("Choose your difficulty: 'Easy', 'Medium' or 'Hard'.");
          gameDifficulty = console.readLine();
          if(!gameDifficulty.equalsIgnoreCase("Easy") && !gameDifficulty.equalsIgnoreCase("Medium") && !gameDifficulty.equalsIgnoreCase("Hard")) {
            System.out.println("That selection isn't recognized.");
          }
        }
      } else {
        System.out.println("That selection isn't recognized.");
      }
    }

    Hangman game = new Hangman(inputHiddenPhrase);

    if (gameDifficulty.equalsIgnoreCase("Easy")) {
      game.chooseEasyWord();
    } else if (gameDifficulty.equalsIgnoreCase("Medium")) {
      game.chooseMedWord();
    } else if (gameDifficulty.equalsIgnoreCase("Hard")){
      game.chooseHardWord();
    } else {
      inputHiddenPhrase = inputHiddenPhrase;
    }
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
