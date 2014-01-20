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
		gameInterface.showWelcomeScreen();
		
		Player player = new Player(gameInterface.promptUserName()); /*construct player, 	
																		takes a string argument, which 
																		is returned from promptUserName */
		boolean wantsToPlay = true;
			
		/* Main game loop. Branches out to playGame, or to interface */
		do {
			gameInterface.showMainMenu();
			int playerSelection = gameInterface.promptMainMenu();
			
			if(playerSelection == 1){//player wants to play the game
				playGame(player);
			}
			else if(playerSelection == 2) { //player wants to see instructions
				gameInterface.showInstructions();
			}
			else if(playerSelection == 3) { //player wants to see gameplay stats
				gameInterface.showPlayerStats(player.getStats());
			}
			else if(playerSelection == 4) { //player wants to see the about text
				gameInterface.showAbout();
			}
			else if(playerSelection == 5) { //Player wants to reset name/profile
				if(gameInterface.promptIsSure())
					player = new Player(gameInterface.promptUserName());
			}
			else if(playerSelection == 0) { //Selected 0, prompt to quit first
				wantsToPlay = !gameInterface.promptWantsToQuit();
			}
			else //Invalid selection is made
				System.out.println("Invalid selection. Please select"
										+ " a valid option from the main menu.");
		}while(wantsToPlay == true);	
	}
	
	public static void playGame(Player player) {
		
	}

}