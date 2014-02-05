/*
   GameText.java 
      the static text used throughout the game. 
*/

public class GameText{
   private static String welcomeScreen = "//////////////////////////////////////////////////////////////////\n"+
                                  "/*       *       * ***** *      ****    ****   **       ** ***** /\n"+
                                  "/ *     * *     *  *     *     *       *    *  * *     * * *     /\n"+
                                  "/  *   *   *   *   ***   *     *      *      * *  *   *  * ***   /\n"+
                                  "/   * *     * *    *     *     *       *    *  *   * *   * *     /\n"+
                                  "/    *       *     ***** *****  ****    ****   *    *    * ***** /\n"+
                                  "/                                                                /\n"+
                                  "/                        *******      ****                       /\n"+
                                  "/                           *        *    *                      /\n"+
                                  "/                           *       *      *                     /\n"+
                                  "/                           *        *    *                      /\n"+
                                  "/                           *         ****                       /\n"+
                                  "/                                                                /\n"+
                                  "/          **       **     *      ***  ******* ***** ****        /\n"+
                                  "/          * *     * *    * *    *        *    *     *   *       /\n"+ 
                                  "/          *  *   *  *   * * *    ***     *    ***   ****        /\n"+
                                  "/          *   * *   *  *     *      *    *    *     * *         /\n"+
                                  "/          *    *    * *       *  ***     *    ***** *  *        /\n"+
                                  "/                                                                /\n"+
                                  "/                   **       **  *  **    *  ****                /\n"+
                                  "/                   * *     * *  *  * *   *  *   *               /\n"+
                                  "/                   *  *   *  *  *  *  *  *  *   *               /\n"+
                                  "/                   *   * *   *  *  *   * *  *   *               /\n"+
                                  "/                   *    *    *  *  *    **  ****                /\n"+
                                  "/                                                                /\n"+
                                  "/                                                                /\n"+
                                  "//////////////////////////////////////////////////////////////////\n";
   
   private static String playerNaming = "//////////////////////////////////////////////////////////////////\n"+
                                "/                                                                /\n"+
                                "/ U S E R,  W H A T  W O U L D  Y O U                            /\n"+
                                "/                 L I K E  T O  B E  C A L L E D?                /\n"+ 
                                "/                                   (2 to 10 characters)         /\n"+
                                "/                                                                /\n"+
                                "//////////////////////////////////////////////////////////////////\n";
                                
   private static String mainMenuScreen = "//////////////////////////////////////////////////////////////////\n"+
                                   "/                 **       **     *     ***  **    *             /\n"+
                                   "/                 * *     * *    * *     *   * *   *             /\n"+
                                   "/                 *  *   *  *   * * *    *   *  *  *             /\n"+
                                   "/                 *   * *   *  *     *   *   *   * *             /\n"+
                                   "/                 *    *    * *       * ***  *    **             /\n"+
                                   "/              **       **   *****  **    *   *      *           /\n"+
                                   "/              * *     * *   *      * *   *   *      *           /\n"+
                                   "/              *  *   *  *   ***    *  *  *   *      *           /\n"+
                                   "/              *   * *   *   *      *   * *    *    *            /\n"+
                                   "/              *    *    *   *****  *    **     ****             /\n"+
                                   "/                                                                /\n"+
                                   "/        (1) P L A Y                                             /\n"+
                                   "/                                                                /\n"+
                                   "/        (2) I N S T R U C T I O N S                             /\n"+
                                   "/                                                                /\n"+
                                   "/        (3) S T A T S                                           /\n"+
                                   "/                                                                /\n"+
                                   "/        (4) A B O U T                                           /\n"+
                                   "/                                                                /\n"+
                                   "/        (5) N E W  P L A Y E R                                  /\n"+
                                   "/                                                                /\n"+
                                   "/        (0) Q U I T                                             /\n"+
                                   "/                                                                /\n"+ 
                                   "//////////////////////////////////////////////////////////////////\n";
   
   private static String[] instructions =   {"//////////////////////////////////////////////////////////////////\n"+
                                             "/ Instructions:                                                  /\n"+
                                             "/                                                                /\n"+
                                             "/ Mastermind is a game where the player must successfully guess  /\n"+
                                             "/ a sequence of colored pegs. You get 10 guesses. After every    /\n"+
                                             "/ guess, you receive a score which will give you clues as to     /\n"+
                                             "/ what the solution is. You may ask for one hint, which          /\n"+
                                             "/ will tell you one of the colors present in the answer          /\n"+
                                             "/ (but not its position).                                        /\n",
                                             "/                                                                /\n"+
                                             "/ This game of mastermind uses ASCII representations for pegs.   /\n"+
                                             "/ Two types of pegs exist, color pegs, and score pegs. Color pegs/\n"+ 
                                             "/ are represented by the first letter of the name of the color,  /\n"+
                                             "/ and score pegs are represented by either a 0, 1, or 2.         /\n",
                                             "/                                                                /\n"+
                                             "/ The computer player will make a selection of 4 (5 on challenge /\n"+
                                             "/ mode) colored pegs. The colors will be selected from: red,     /\n"+
                                             "/ orange, yellow, green, blue, and indigo                        /\n"+
                                             "/ (plus violet on challenge mode).                               /\n",
                                             "/                                                                /\n"+
                                             "/ In order to win the game, you must correctly guess the sequence/\n"+
                                             "/ of pegs.                                                       /\n"+
                                             "/                                                                /\n"+
                                             "/ After making a guess, you will be given feedback in the form of/\n"+
                                             "/ score pegs. A 2 is awarded if your guess contains a correct    /\n"+
                                             "/ color in the correct location. A 1 is awarded if your guess    /\n"+
                                             "/ contains a correct color in an incorrect location, and a 0     /\n"+
                                             "/ represents a complete miss; one of your guess colors is not    /\n"+
															"/ found in the answer.                                           /\n"+
                                             "//////////////////////////////////////////////////////////////////\n"};
   
   private static String aboutScreen = "//////////////////////////////////////////////////////////////////\n"+
                                       "/                                                                /\n"+
                                       "/ About:                                                         /\n"+
                                       "/ Mastermind v. 1.0                                              /\n"+
                                       "/                                                                /\n"+
                                       "/ Project Lead:                   Joey Anetsberger               /\n"+
                                       "/ String Guru/ASCII Artist:       Scott Akeson                   /\n"+
                                       "/ AI Programmer:                  Sarah Clarke                   /\n"+
                                       "/                                                                /\n"+
                                       "/ This program was developed as the warm-up project for UVM's    /\n"+
                                       "/ CS205 - Software Engineering class.                            /\n"+
                                       "/                                                                /\n"+
                                       "//////////////////////////////////////////////////////////////////\n";   
   
   private static String byeScreen = "//////////////////////////////////////////////////////////////////\n"+
                              "/                     ****   *     *   ******                    /\n"+
                              "/                     *   *   *   *    *                         /\n"+
                              "/                     *   *    * *     *                         /\n"+
                              "/                     ****      *      ****                      /\n"+
                              "/                     *   *     *      *                         /\n"+
                              "/                     *   *     *      *                         /\n"+
                              "/                     ****      *      ******                    /\n"+
                              "//////////////////////////////////////////////////////////////////\n";
   
   private static String loseScreen = "//////////////////////////////////////////////////////////////////\n"+
                                      "/               L        OOOOO    SSSSS  EEEEEE RRRRR            /\n"+
                                      "/               L       O     O  S       E      R    R           /\n"+
                                      "/               L      O       O S       E      R    R           /\n"+
                                      "/               L      O       O  SSSSS  EEEE   RRRRR            /\n"+
                                      "/               L      O       O       S E      R R              /\n"+
                                      "/               L       O     O        S E      R  R             /\n"+
                                      "/               LLLLLLL  OOOOO    SSSSS  EEEEEE R   R            /\n"+
                                      "//////////////////////////////////////////////////////////////////\n";
                                      
   private static String winScreen = "//////////////////////////////////////////////////////////////////\n"+
                                     "/       W           W III  NN     N  NN     N  EEEEEE  RRRR      /\n"+
                                     "/       W     W     W  I   N N    N  N N    N  E       R   R     /\n"+
                                     "/       W    W W    W  I   N  N   N  N  N   N  EEE     RRRR      /\n"+
                                     "/        W  W  W   W   I   N   N  N  N   N  N  EEE     RR        /\n"+
                                     "/         W W   W W    I   N    N N  N    N N  E       R  R      /\n"+
                                     "/          W     W    III  N     NN  N     NN  EEEEEE  R   R     /\n"+
                                     "//////////////////////////////////////////////////////////////////\n";
   
   private static String boardTop = "*************************\n"+
                                    "*  M a s t e r m i n d  *\n"+
                                    "*************************\n"+
                                    "*   G u e s s   * Score *\n"+
                                    "*************************\n";
                                    
   public static StringBuffer getGameBoard(int difficulty, String hint){
      StringBuffer gBStr = new StringBuffer();
      gBStr.append(boardTop);
      String[] guessArray;
      String[] scoreArray;
      guessArray = new String[10];
      scoreArray = new String[10];
      if ( difficulty == 1 ){
         for (int i = 0; i<10;i++){
            guessArray[i] = "*   _ _ _ _ _   *";
            gBStr.append(guessArray[i]);
            scoreArray[i] = " _____ *\n";
            gBStr.append(scoreArray[i]);
         
         }
         String gBAnswer = "*   # # # # #   *";
         String gBClue = " __" + hint + "__ *\n";
         String gBFoot = "*************************\n"+
                      "*    ANSWER     *  HINT *\n"+ 
                      gBAnswer + gBClue+
                      "*************************\n";
         gBStr.append(gBFoot);
      }
      else {
         for (int i = 0; i<10;i++){
            guessArray[i] = "*   _ _ _ _    **";
            gBStr.append(guessArray[i]);
            scoreArray[i] = " ____ **\n";
            gBStr.append(scoreArray[i]);
         
         }
         String gBAnswer = "*   # # # #    **";
         String gBClue = " __?_ **\n";
         String gBFoot = "*************************\n"+
                      "*    ANSWER    ** HINT **\n"+ 
                      gBAnswer + gBClue+
                      "*************************\n";
         gBStr.append(gBFoot);
      }
      
      
   return gBStr; 
   }

	public static StringBuffer setGameBoard(int turn, String guessInput, String scoreInput, StringBuffer gBStr, 
																String clueInsert){
      int CONSTANT_COUNT = 130;
      
      String guess = guessInput;
		guessInput = "";
		for(int i = 0; i < guess.length(); i++) {
			guessInput += guess.charAt(i) + " ";
		}		
		guessInput = guessInput.substring(0, guessInput.length() - 1);
		if(!clueInsert.equals("?")){
         if (guessInput.length() == 9){
            int clueLocation = CONSTANT_COUNT + 332;
           gBStr.replace(clueLocation, clueLocation+1,clueInsert);
         }
         else {
            int clueLocation = CONSTANT_COUNT + 332;
            gBStr.replace(clueLocation, clueLocation+1,clueInsert);
         }
      }
      if (guessInput.length() == 9){
			int charLocationStart = 0;
			if (turn == 0){
	         charLocationStart = CONSTANT_COUNT + (turn)*26;
			}
			else{
         	charLocationStart = CONSTANT_COUNT + (turn-1)*26;
			}
         if ( turn == 1){
         }
         else{
         }
         String guessStr = "*   "+guessInput+"   *";
         String scoreStr = " "+scoreInput+" *";
         gBStr.replace(charLocationStart, charLocationStart + 25, guessStr+scoreStr);
      }
      else if ( guessInput.length() == 7){
			int charLocationStart = 0;
			if (turn == 0){
	         charLocationStart = CONSTANT_COUNT + (turn)*26;
			}
			else{
         	charLocationStart = CONSTANT_COUNT + (turn-1)*26;
			}
         String guessStr = "*   "+guessInput+"    **";
         String scoreStr = " "+scoreInput+" **";
         gBStr.replace(charLocationStart, charLocationStart + 25, guessStr+scoreStr);
      
      }
  		return gBStr;
	}
   
   public static String getBoardTop(){
      return boardTop;
   }
   public static String getWelcome(){
      return welcomeScreen;
   }
   public static String getPlayerNaming(){
      return playerNaming;
   }
   public static String getMainMenu(){
      return mainMenuScreen;
   }
   public static String[] getInstructions(){
      return instructions;
   }
   public static String getAboutScreen(){
      return aboutScreen;
   }
   public static String getByeScreen(){
      return byeScreen;
   }
   public static String getLoseScreen(){
      return loseScreen;
   }
   public static String getWinScreen(){
      return winScreen;
   }
   public static String askMoveText (String[] colorArray){
      StringBuffer askMoveStringBuffer = new StringBuffer("");
      String askMoveString;
      for (int i = 0; i < colorArray.length; i++){
            askMoveStringBuffer.append("("+colorArray[i].charAt(0)+")"+colorArray[i].substring(1)+" ");
         } 
      askMoveString = askMoveStringBuffer.toString();
      
      return "Please make your move. Enter " + (colorArray.length - 2) + 
		" letters representing colors from:\n " +askMoveString+
      "\n You may also ask for a (hint), get (instructions), or (give up).";
   }
public static String getStats(Player player){
      String playerStr = player.getPlayerName();
		
      int[] totalGamesArray = player.getGamesPlayed();
      int[] totalWinsArray = player.getTotalWins();
      int[] totalTurnsArray = player.getTotalTurns();
      int[] totelLosesArray = player.getTotalLosses();
      int[] turnsWinsRatioArray = player.getTurnsWinsRatio();
      
      String sessionStats = "||**********Player's Stats**********||\n||\n"+
                           "|| Player: "+playerStr+"\n"+
                           "||\n" +
									"||                      Easy | Hard \n" +
									"|| Games Played:"+String.format("%12d | %d", totalGamesArray[0], totalGamesArray[1])+"\n"+
                           "|| Wins:"+String.format("%20d | %d", totalWinsArray[0], totalWinsArray[1])+"\n"+ 
									"|| Losses:"+String.format("%18d | %d", totelLosesArray[0], totelLosesArray[1])+"\n"+
                           "|| Total Turns:"+String.format("%13d | %d", totalTurnsArray[0], totalTurnsArray[1])+"\n"+
									"|| Turn/Win Average:"+String.format("%8d | %d", turnsWinsRatioArray[0], turnsWinsRatioArray[1])+"\n"+
									"||**********************************||";
		 return sessionStats;
   
   }
} 