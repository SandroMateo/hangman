import java.util.Random;

class Hangman {

  private String mHiddenWord;
  private String[] mEasyWords = {"cat", "dog", "hat"};
  private String[] mMedWords = {"hotdog", "yachtsman", "javascript", "jazz"};
  private String[] mHardWords = {"equilibrium", "mathematica", "symposium"};
  private String mBlankedWord;
  private char[] mHiddenArray;
  private char[] mBlankedArray;
  private String mTempBlankedWord;
  private int mGuessCount;

  public Hangman(String hiddenWord) {
    mHiddenWord = hiddenWord;
    mGuessCount = 0;
  }

  public String getHiddenWord() {
    return mHiddenWord;
  }

  public String getBlankedWord() {
    return mBlankedWord;
  }

  public int getGuessCount() {
    return mGuessCount;
  }

  public String chooseEasyWord() {
    Random myRandomGenerator = new Random();
    int randomSelection = myRandomGenerator.nextInt(mEasyWords.length);
    mHiddenWord = mEasyWords[randomSelection];
    return mHiddenWord;
  }

  public String chooseMedWord() {
    Random myRandomGenerator = new Random();
    int randomSelection = myRandomGenerator.nextInt(mMedWords.length);
    mHiddenWord = mMedWords[randomSelection];
    return mHiddenWord;
  }

  public String chooseHardWord() {
    Random myRandomGenerator = new Random();
    int randomSelection = myRandomGenerator.nextInt(mHardWords.length);
    mHiddenWord = mHardWords[randomSelection];
    return mHiddenWord;
  }

  

  public String stringToDashes() {
    mBlankedWord = mHiddenWord.replaceAll("[a-zA-Z]", "-");
    return mBlankedWord;
  }

  public String stringContainsChar(char guessedChar) {
    mTempBlankedWord = "";
    mHiddenArray = mHiddenWord.toCharArray();
    mBlankedArray = mBlankedWord.toCharArray();
    if(mHiddenWord.indexOf(guessedChar) >= 0) {
      for (int i = 0; i < mHiddenArray.length; i++) {
        if (mHiddenArray[i] == guessedChar) {
          mBlankedArray[i] = guessedChar;
        }
      }
    } else {
      mGuessCount++;
    }
    for(int j = 0; j < mBlankedArray.length; j++) {
      mTempBlankedWord += mBlankedArray[j];
    }
    mBlankedWord = mTempBlankedWord;
    return mBlankedWord;
  }
}
