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

	public static void main(String[] args) {
		
		Interface gameInterface = new Interface();
		
		gameInterface.showText("WELCOME_PH");
		
		Player player = new Player(gameInterface.promptUserName()); /*construct player, 	
																		takes a string argument, which 
																		is returned from promptUserName */
			
		/* Main game loop. Branches out to playGame, or to Interface methods.
			Executes until boolean value wantsToPlay is set to false */
		boolean wantsToPlay = true;
		while(wantsToPlay) {
						
			int playerSelection = gameInterface.promptMainMenu("MAIN_MENU_PH_123450");
			
			if(playerSelection == PLAY){//player wants to start a game
				playGame(player, gameInterface);
			}
			else if(playerSelection == INSTRUCTIONS) { //player wants to see instructions
				String[] instructionsPlaceholder = {"INSTRUCTIONS", "PH"};
				gameInterface.showInstructions(instructionsPlaceholder);
			}
			else if(playerSelection == STATS) { //player wants to see gameplay stats
				gameInterface.showText("STATS_PH");
			}
			else if(playerSelection == ABOUT) { //player wants to see the about text
				gameInterface.showText("ABOUT_PH");
			}
			else if(playerSelection == RESET_PLAYER) { //Player wants to reset name/profile
				if(gameInterface.confirmRename())
					player = new Player(gameInterface.promptUserName());
			}
			else if(playerSelection == EXIT) { //Selected 0, prompt to quit first
				wantsToPlay = !gameInterface.promptWantsToQuit();
			}
			else //Invalid selection is made
				gameInterface.showText("Invalid Selection. Please select a valid option from the menu.");
		}//while	
	gameInterface.showText("BYE_PH");
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
		
			/* Constructs what is to be the computer "player", passes in the difficulty
			   to the constructor */
			Computer computer = new Computer(gameInterface.promptDifficulty());
			boolean isGameDone = false;
			while(!isGameDone) {
				//Player is asked for a move. Function can only return 4 things.
				
				String input = gameInterface.promptPlayerMove(computer.getTrueValidColors(),
																					"MOVEOPTIONS_PH");
				
				//start of if branching depending on player's move. Exhaustive.
				if(input.equalsIgnoreCase("hint")) {
					gameInterface.showText("HINT_PH");
					//gameInterface.showHint(computer.getHint());
				}//if
				else if(input.equalsIgnoreCase("give up")
												 && gameInterface.promptGiveUp()) {	 
					isGameDone = true;
					gameInterface.showText("LOSE_PH");
					gameInterface.showText("The solution was: " + computer.getPegOrder());
					isPlaying = gameInterface.promptPlayAgain();
				}//else if
				else if(input.equalsIgnoreCase("instructions")) {
					gameInterface.showText("INSTRUCTIONS_PH");
				}//else if
				else { //falls to here if the user input was a guess.
					if(computer.scoreGuess(input)) { //win
						//gameInterface.showText(computer.getBoard());
						gameInterface.showText("PLACEHOLDER_WIN");
						player.updateStats(1, computer.getTurnsUsed(), computer.getDifficulty());
					}//if
					else {//goes to here if the guess is not a win.
						if(computer.getTurnsUsed() >= 10) { // Lose
						}//if
					}//else	
				}//else
				
				/*if(computer.getTurnsLeft() <= 0) {
					gameInterface.showText("PLACEHOLDER_LOSE");
					isGameDone = true;
				}*/
			}//while
		}//while
	}//playGame()
}
