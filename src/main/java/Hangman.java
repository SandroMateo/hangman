class Hangman {

  private String mHiddenWord;
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
