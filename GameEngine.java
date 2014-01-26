/******************************************************************************************
* Project: Mastermind
* File:    GameEngine.java
* Author:  Joey Anetsberger
* 
* Description:
* 		This class contains main(). It performs game logic
*		functions, handles flow of execution, and connects
*		all game play elements/classes.
*
*/



public class GameEngine {


	public static void main(String[] args) {
		
		Interface gameInterface = new Interface();
		
		gameInterface.showText("PLACEHOLDER_WELCOME");
		Player player = new Player(gameInterface.promptUserName()); /*construct player, 	
																		takes a string argument, which 
																		is returned from promptUserName */
		boolean wantsToPlay = true;
			
		/* Main game loop. Branches out to playGame, or to Interface methods.
			Executes until boolean value wantsToPlay is set to false */
		while(wantsToPlay) {
			//gameInterface.showMainMenu();
			
			int playerSelection = gameInterface.promptMainMenu();
			
			if(playerSelection == 1){//player wants to start
				playGame(player, gameInterface);
			}
			else if(playerSelection == 2) { //player wants to see instructions
				gameInterface.showText("PLACEHOLDER_INSTRUCTIONS");
			}
			else if(playerSelection == 3) { //player wants to see gameplay stats
				gameInterface.showText("PLACEHOLDER_STATS");
			}
			else if(playerSelection == 4) { //player wants to see the about text
				gameInterface.showText("PLACEHOLDER_ABOUT");
			}
			else if(playerSelection == 5) { //Player wants to reset name/profile
				if(gameInterface.promptRename())
					player = new Player(gameInterface.promptUserName());
			}
			else if(playerSelection == 0) { //Selected 0, prompt to quit first
				wantsToPlay = !gameInterface.promptWantsToQuit();
			}
			else //Invalid selection is made
				System.out.println("Invalid selection. Please select"
										+ "\na valid option from the main menu.");
		}	
	gameInterface.showText("BYE_PLACEHOLDER");
	}
	
	
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
				String[] testArray = {"red", "orange", "yellow", "green", "blue", "indigo"};
				String playerInput = gameInterface.promptPlayerMove(testArray);
				
				if(playerInput.equalsIgnoreCase("hint")) {
					//gameInterface.showHint(computer.getHint());
					gameInterface.showText("PLACEHOLDER_HINT");
				}
				else if(playerInput.equalsIgnoreCase("give up")) {
					if(gameInterface.promptGiveUp()) {
						//gameInterface.showLose();
						isGameDone = true;
						gameInterface.showText("PLACEHOLDER_LOSE");
						if(!gameInterface.promptPlayAgain()) {
							isPlaying = false;
						}
						
						
					}
				}
				else if(playerInput.equalsIgnoreCase("instructions")) {
					gameInterface.showText("PLACEHOLDER_INSTRUCTIONS");
				}
				else {
					//if(computer.scoreMove(input)) {
						//gameInterface("PLACEHOLDER_WIN");
					}
				}
				
				/*if(computer.getTurnsLeft() <= 0) {
					gameInterface.showText("PLACEHOLDER_LOSE");
					isGameDone = true;
				}*/
		}
		
	}

}