/******************************************************************************************
* Project: Mastermind
* File:    MastermindMain.java
* Author:  Joey Anetsberger
* 
* Description:
* 		This class contains main(). It performs game logic
*		functions, handles flow of execution, and connects
*		all game play elements/classes.
*
*/

public class MastermindMain {

	//enumeration of options for main menu.
	private static final int PLAY = 1;
	private static final int INSTRUCTIONS = 2;
	private static final int STATS = 3;
	private static final int ABOUT = 4;
	private static final int RESET_PLAYER = 5;
	private static final int EXIT = 0;
	private static final int TURNS_ALLOWED = 10;

	public static void main(String[] args) {
		
		Interface gameInterface = new Interface();
		
		gameInterface.showText(GameText.getWelcome());
		gameInterface.pushUp();

  	   //construct player, takes a string argument, which is returned from promptUserName()
		Player player = new Player(gameInterface.promptUserName(GameText.getPlayerNaming())); 
			
		/* Main game loop. Branches out to playGame, or to Interface methods.
			Executes until boolean value wantsToPlay is set to false */
		boolean wantsToPlay = true;
		while(wantsToPlay) {
			gameInterface.pushUp();						
			int playerSelection = gameInterface.promptMainMenu(GameText.getMainMenu());
			gameInterface.pushUp();	
			if(playerSelection == PLAY){//player wants to start a game
				playGame(player, gameInterface);
			}
			else if(playerSelection == INSTRUCTIONS) { //player wants to see instructions
				gameInterface.showInstructions(GameText.getInstructions());
			}
			else if(playerSelection == STATS) { //player wants to see gameplay stats
				gameInterface.showText(GameText.getStats(player));
			}
			else if(playerSelection == ABOUT) { //player wants to see the about text
				gameInterface.showText(GameText.getAboutScreen());
			}
			else if(playerSelection == RESET_PLAYER) { //Player wants to reset name/profile
				if(gameInterface.confirmRename())
					player = new Player(gameInterface.promptUserName(GameText.getPlayerNaming()));
			}
			else if(playerSelection == EXIT) { //Selected 0, prompt to quit first
				wantsToPlay = !gameInterface.promptWantsToQuit();
			}
			else //Invalid selection is made
				gameInterface.showText("Invalid Selection. Please select a valid option from the menu.");
		}//while	
	gameInterface.showText(GameText.getByeScreen());
	}//main
	
	
	/************************************************************************************ 
	* Method is called if player makes selection 1 in main menu. This method will
	* run the game until the player quits to the main menu.
	* Instance of Computer object is constructed here.
	* In: reference to Player, Interface
	* Out: -
	************************************************************************************/
	public static void playGame(Player player, Interface gameInterface) {
		
		boolean isPlaying = true;
		while(isPlaying) {
			gameInterface.pushUp();	
			/* Constructs what is to be the computer "player", passes in the difficulty
			   to the constructor */
			Computer computer = new Computer(gameInterface.promptDifficulty("Select your difficulty level:"
																		+ "\n(1) Normal - 4 Pegs, 6 Colors"
																		+ "\n(2) Challenge - 5 Pegs, 7 Colors"));

			boolean isGameDone = false;
			while(!isGameDone) {
			gameInterface.pushUp();	
			
			//Player is asked for a move. Function can only return 4 things.
			String input = gameInterface.promptPlayerMove(computer.getTrueValidColors(),
													GameText.askMoveText(computer.getTrueValidColors()),
													computer.getGameboard());
			gameInterface.pushUp();
				
				//start of if branching depending on player's move. Exhaustive.
				if(input.equalsIgnoreCase("hint")) {
					if(!computer.getHintUsed()) {
						computer.revealHint();
					}
					else {
						gameInterface.showText("You may only ask for a hint ONCE!");
					}
				}//if
				else if(input.equalsIgnoreCase("give up")) {
					if(gameInterface.promptGiveUp()) {	 
						isGameDone = true;
						gameInterface.showText(GameText.getLoseScreen());
						gameInterface.showText("The solution was: " + computer.getPegOrder());
						player.updateStats(0, computer.getTurnsUsed(), computer.getDifficulty());
					}//if
				}//else if
				else if(input.equalsIgnoreCase("instructions")) {
					gameInterface.showInstructions(GameText.getInstructions());
				}//else if
				else { //falls to here if the user input was a guess.
					if(computer.scoreGuess(input)) { //win
						gameInterface.showText(computer.getGameboard());
						gameInterface.showText(GameText.getWinScreen());
						player.updateStats(1, computer.getTurnsUsed(), computer.getDifficulty());
						isGameDone = true;
					}//if
					else {//goes to here if the guess is not a win.
						if(computer.getTurnsUsed() >= TURNS_ALLOWED) { // Lose
							player.updateStats(0, computer.getTurnsUsed(), computer.getDifficulty());
							gameInterface.showText(GameText.getLoseScreen());
							gameInterface.showText("The solution was: " + computer.getPegOrder());
							isGameDone = true;
						}//if
					}//else	
				}//else
			}//while
			isPlaying = gameInterface.promptPlayAgain();
		}//while
	}//playGame()
}
