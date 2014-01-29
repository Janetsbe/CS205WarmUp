/*
   GameText.java 
      the static text used throughout the game. 
*/

public class GameText{
   private static String welcomeScreen = "//////////////////////////////////////////////////////////////////\n"+
                                  "/ *      *      *  ***** *      ****    ****   **       ** ***** /\n"+
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
                                  "/          *   * *   *  *     *      *    *    *     *  *        /\n"+
                                  "/          *    *    *  *     *   ***     *    ***** *   *       /\n"+
                                  "/                                                                /\n"+
                                  "/                   **       **  *  **    *  ****                /\n"+
                                  "/                   * *     * *  *  * *   *  *   *               /\n"+
                                  "/                   *  *   *  *  *  *  *  *  *   *               /\n"+
                                  "/                   *   * *   *  *  *   * *  *   *               /\n"+
                                  "/                   *    *    *  *  *    **  ****                /\n"+
                                  "/                                                                /\n"+
                                  "/                                                                /\n"+
                                  "//////////////////////////////////////////////////////////////////\n";
   
   private static String playerInput = "//////////////////////////////////////////////////////////////////\n"+
                                "/                                                                /\n"+
                                "/      U S E R,  W H A T  W O U L D  Y O U                       /\n"+
                                "/                 L I K E  T O  B E  C A L L E D?                /\n"+ 
                                "/                                                                /\n"+
                                "//////////////////////////////////////////////////////////////////\n";
                                
   private static String mainMenuScreen = "//////////////////////////////////////////////////////////////////\n"+
                                   "/                 **       **     *     ***  **    *             /\n"+
                                   "/                 * *     * *    * *     *   * *   *             /\n"+
                                   "/                 *  *   *  *   * * *    *   *  *  *             /\n"+
                                   "/                 *   * *   *  *     *   *   *   * *             /\n"+
                                   "/                 *    *    * *       * ***  *    **             /\n"+
                                   "/                                                                /\n"+
											  "/              **       **   *****  **    *   *      *           /\n"+
                                   "/              * *     * *   *      * *   *   *      *           /\n"+
                                   "/              *  *   *  *   ***    *  *  *   *      *           /\n"+
                                   "/              *   * *   *   *      *   * *    *    *            /\n"+
                                   "/              *    *    *   *****  *    **     **** *           /\n"+
                                   "/                                                                /\n"+
                                   "/        (1) P L A Y                                             /\n"+
                                   "/                                                                /\n"+
                                   "/        (2) I N S T R U C T I O N S                             /\n"+
                                   "/                                                                /\n"+
                                   "/        (3) S T A T S                                           /\n"+
                                   "/                                                                /\n"+
                                   "/        (4) N E W  P L A Y E R                                  /\n"+
                                   "/                                                                /\n"+
                                   "/        (5) A B O U T                                           /\n"+
                                   "/                                                                /\n"+
                                   "/        (0) Q U I T                                             /\n"+
                                   "/                                                                /\n"+ 
                                   "//////////////////////////////////////////////////////////////////\n";
   
   private static String instructions = "";
   
   private static String aboutScreen = "//////////////////////////////////////////////////////////////////\n";
   
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
                               "/*        *****             /\n"+
                               "/*       *     *            /\n"+
                               "/*      *       *           /\n"+
                               "/*      *       *           /\n"+
                               "/*      *       *           /\n"+
                               "/*       *     *            /\n"+
                               "/*******  *****             /\n"+
                               "//////////////////////////////////////////////////////////////////\n";
   
   
   private static String boardTop = "*************************\n"+
                             "*  M a s t e r m i n d  *\n"+
                             "*************************\n"+
                             "*   G u e s s   * Score *\n"+
                             "*************************\n";

   public static void main(String[] args ){
      System.out.println(boardTop.length());
   }
   public static StringBuffer getGameBoard(boolean difficulty, String gameBoardTop){
      StringBuffer gBStr = new StringBuffer();
      gBStr.append(gameBoardTop);
      String[] guessArray;
      String[] scoreArray;
      guessArray = new String[10];
      scoreArray = new String[10];
      if ( difficulty == true ){
         for (int i = 0; i<10;i++){
            guessArray[i] = "*   _ _ _ _ _   *";
            gBStr.append(guessArray[i]);
            scoreArray[i] = " _____ *\n";
            gBStr.append(scoreArray[i]);
         
         }
         String gBAnswer = "*   # # # # #   *";
         String gBClue = " __?__ *\n";
         String gBFoot = "*************************\n"+
                      "*    Answer    *  CLUE *\n"+ 
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
                      "*    Answer   ** CLUE **\n"+ 
                      gBAnswer + gBClue+
                      "*************************\n";
         gBStr.append(gBFoot);
      }
      
      
   return gBStr; 
   }
   public static StringBuffer setGameBoard(int turn, String guessInput, String scoreInput, boolean winOrLose, StringBuffer gBStr){
      int CONSTANT_COUNT = 130;
      
      int charLocationStart = CONSTANT_COUNT + turn*27;
      String guessStr = "* "+guessInput+" *";
      String scoreStr = " "+scoreInput+" *\n";
      gBStr.replace(charLocationStart, charLocationStart + 27, guessStr+scoreStr);
   
   return gBStr;
   }
}