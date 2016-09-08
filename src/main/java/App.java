import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console console = System.console();
    boolean gameInProgress = true;
    while (gameInProgress == true) {
      String gameChoice = "";
      String gameDifficulty = "";
      String inputHiddenPhrase = "";

      System.out.println("Let's play Hangman!");

      while(!gameChoice.equalsIgnoreCase("single player") && !gameChoice.equalsIgnoreCase("multiplayer")) {
        System.out.println("Choose 'single player' or 'multiplayer'.");
        gameChoice = console.readLine();

        if (gameChoice.equalsIgnoreCase("multiplayer")) {
          System.out.println("Enter a phrase for others to guess:");
          inputHiddenPhrase = console.readLine().toLowerCase();
          System.out.print("\033[H\033[2J");
          System.out.flush();

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

      while(game.getBlankedWord().contains("-") && game.getGuessCount() < 6) {
        String inputStringGuess = console.readLine().toLowerCase();
        char inputGuess = inputStringGuess.charAt(0);
        System.out.println(game.stringContainsChar(inputGuess));
        if(game.getBlankedWord().contains("-") && game.getGuessCount() == 0) {
          System.out.print( "_____________   \n" );
          System.out.print( "|           |   \n" );
          System.out.print( "|               \n" );
          System.out.print( "|               \n" );
          System.out.print( "|               \n" );
          System.out.print( "|               \n" );
          System.out.println("Guess Again!");
        } else if(game.getBlankedWord().contains("-") && game.getGuessCount() == 1) {
          System.out.print( "_____________   \n" );
          System.out.print( "|           |   \n" );
          System.out.print( "|           0   \n" );
          System.out.print( "|               \n" );
          System.out.print( "|               \n" );
          System.out.print( "|               \n" );
          System.out.println("Guess Again!");
        } else if(game.getBlankedWord().contains("-") && game.getGuessCount() == 2) {
          System.out.print( "_____________   \n" );
          System.out.print( "|           |   \n" );
          System.out.print( "|           0   \n" );
          System.out.print( "|           |   \n" );
          System.out.print( "|               \n" );
          System.out.print( "|               \n" );
          System.out.println("Guess Again!");
        } else if(game.getBlankedWord().contains("-") && game.getGuessCount() == 3) {
          System.out.print( "_____________   \n" );
          System.out.print( "|           |   \n" );
          System.out.print( "|           0   \n" );
          System.out.print( "|          /|   \n" );
          System.out.print( "|               \n" );
          System.out.print( "|               \n" );
          System.out.println("Guess Again!");
        } else if(game.getBlankedWord().contains("-") && game.getGuessCount() == 4) {
          System.out.print( "_____________   \n" );
          System.out.print( "|           |   \n" );
          System.out.print( "|           0   \n" );
          System.out.print( "|          /|\\ \n" );
          System.out.print( "|               \n" );
          System.out.print( "|               \n" );
          System.out.println("Guess Again!");
        } else if(game.getBlankedWord().contains("-") && game.getGuessCount() == 5) {
          System.out.print( "_____________   \n" );
          System.out.print( "|           |   \n" );
          System.out.print( "|           0   \n" );
          System.out.print( "|          /|\\ \n" );
          System.out.print( "|          /    \n" );
          System.out.print( "|               \n" );
          System.out.println("Guess Again!");
        } else if(game.getBlankedWord().contains("-") && game.getGuessCount() == 6) {
          System.out.print( "_____________   \n" );
          System.out.print( "|           |   \n" );
          System.out.print( "|           0   \n" );
          System.out.print( "|          /|\\ \n" );
          System.out.print( "|          / \\ \n" );
          System.out.print( "|               \n" );
          System.out.println("You killed the hangman...");
        }
      }
      if(!game.getBlankedWord().contains("-")) {
        System.out.println("You Win!");
      }
      System.out.println("Want to play again? Enter 'yes' or 'no'");
      String userPlayAgain = console.readLine();
      if (userPlayAgain.equalsIgnoreCase("yes")) {
        gameInProgress = true;
      } else {
        gameInProgress = false;
      }
    }
  }
}
