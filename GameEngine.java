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
		
		gameInterface.showText(GameText.getWelcome());
		
		Player player = new Player(gameInterface.promptUserName()); /*construct player, 	
																		takes a string argument, which 
																		is returned from promptUserName */
			
		/* Main game loop. Branches out to playGame, or to Interface methods.
			Executes until boolean value wantsToPlay is set to false */
		boolean wantsToPlay = true;
		while(wantsToPlay) {
						
			int playerSelection = gameInterface.promptMainMenu(GameText.getMainMenu());
			
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
				gameInterface.showText(GameText.getAbout());
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
	gameInterface.showText(GameText.getBye());
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
				String playerInput = gameInterface.promptPlayerMove(computer.getValidColors(),
																					GameText.getMoveOptions());
				
				//start of if branching depending on player's move. Exhaustive.
				if(playerInput.equalsIgnoreCase("hint")) {
					gameInterface.showHint(computer.getHint());
				}//if
				else if(playerInput.equalsIgnoreCase("give up")) {
					if(gameInterface.promptGiveUp()) {
						isGameDone = true;
						gameInterface.showText(GameText.getLoseScreen());
						gameInterface.showText("The solution was: " + computer.getSolution());
						isPlaying = gameInterface.promptPlayAgain();
					}//if
				}//else if
				else if(playerInput.equalsIgnoreCase("instructions")) {
					gameInterface.showText(GameText.getInstructions);
				}//else if
				else { //falls to here if the user input was a guess.
					if(computer.scoreMove(input)) { //score move returns true if win.
						gameInterface.showText(computer.getBoard());
						gameInterface.showText("PLACEHOLDER_WIN");
						player.updateStats(1, computer.getTurns(), computer.getDifficulty());
					}//if
					else {//goes to here if the guess is not a win.
						if(computer.getTurns() >= 10) { // Lose
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
