import java.util.Scanner;

public class Interface {


	private Scanner keyboard;
	
	/************************************************************************************ 
	* Constructor for interface Object.
	* In: None
	* Out/post: Scanner keyboard is initialized.
	************************************************************************************/
	public Interface() {
		keyboard = new Scanner(System.in);
	}
	
	/************************************************************************************ 
	* Prompt the user for input to make a selection from the main menu.
	* In: None
	* Out/post: Returns a valid input for main menu. Error checking is performed to ensure
					input is an integer. Will prompt until an integer value is entered.
	************************************************************************************/
	public String promptMainMenu() {
		System.out.println("Main menu goes here");
		String input = keyboard.nextLine();
		return input;
	}

	/************************************************************************************ 
	* Outputs the welcome screen to the user. 
	* In: None
	* Out/post: The welcome "screen" will have been output to the console.
	************************************************************************************/
	public void showWelcomeScreen() {
		System.out.println("Welcome screen goes here");
		keyboard.nextLine();
	}
	
	/************************************************************************************ 
	* Displays a dialog box containing gameplay instructions. Dialog box is used in order
	* to avoid disrupting gameplay if player wishes to see instructions while playing.
	* In: None
	* Out/post: A dialog box showing instructions will have been presented to the user.
	************************************************************************************/
	public void showInstructions() {
		System.out.println("Instructions go here");
		keyboard.nextLine();
	}
	
	
	/************************************************************************************ 
	* Shows the player their stats. 
	* In: None
	* Out/post: The player will have had their game session stats output to the console.
	************************************************************************************/
	public void showPlayerStats(String stats) {
		System.out.println("Stats go here");
		keyboard.nextLine();
	}
	
	public String promptUserName() {
		System.out.println("Please enter your name");
		String name = keyboard.nextLine();
		return name;
	}
	
	public void showAbout() {
		System.out.println("About info goes here");
	}
	
	public boolean promptIsSure() {
		return true;
	}
	
	public boolean promptWantsToQuit() {
		return true;
	}
	
	public int promptDifficulty() {
		return 1;
	}
	
	public String promptPlayerMove(Computer computer) {
		int difficulty = computer.getDifficulty();
		String validColors = "roygbiv";
		String input = "rygbo";
		if(input.length() == 4 || input.length() == 5) {
			boolean validInput = true;
			for(int i = 0; i < input.length() && validInput == true; i++)
				
				/* A bit messy, this checks if every char in the input string belongs to the 
				   String validColors, up to the appropriate character based on difficulty */	
				if(validColors.substring(0, 6 + difficulty).indexOf(input.charAt(1)) != -1)
					validInput = false;
					
		}
		return input.toLowerCase();
	}
}

	/************************************************************************************ 
	*
	* In: 
	* Out/post: -
	************************************************************************************/