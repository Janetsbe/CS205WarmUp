import java.util.Scanner;

public class Interface {

	private Scanner keyboard; //Used for user input
	
	
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
	public int promptMainMenu(String mainMenu) {
		System.out.println(mainMenu);
		String input = userInput();

		while(!isNumerical(input)) {
			showText("Please select a valid option from the menu.");
			System.out.println(mainMenu);
			input = userInput();
		}
		return Integer.parseInt(input);
	}
	
	/************************************************************************************ 
	* Checks if a String consists of only numerical characters.
	* In: a String consisting of any type of character.
	* Out/post: Returns a boolean representing whether the input String is numerical
	************************************************************************************/
	public boolean isNumerical(String string) {
		if(string.equals("")) { //checks for an empty string
			return false;
		}
		for(int i = 0; i < string.length(); i++) {
			if(!(Character.isDigit(string.charAt(i)))) { /*checks if the character at i is
																		  not a digit.*/
				return false; /*a non-numerical character was found, the whole String is
									 considered non-numerical*/
			}
		}
		return true; //no non-numerical digits were found, the String is numerical
	}


	/************************************************************************************ 
	* This method is used to display text to the user when user input is not required.
	* E.g. welcome text, instructions, etc.
	* In: None
	* Out/post: Text is output to the console, and the user must press enter to continue
	************************************************************************************/
	public void showText(String text) {
		System.out.println(text + "\nPress enter to continue.");
		userInput();
	}
		
	/************************************************************************************ 
	* Prompts the user for a name and returns a String to represent the user's name. Name
	* length is limited in order to avoid Strings whose length might cause problems
	* for other text to display correctly.
	* In: None
	* Out/post: Console displays to user what is required.
					Returns a String of length 2-10.
	************************************************************************************/
	public String promptUserName(String naming) {
		System.out.println(naming);
		String name = userInput();
		while(name.length() < 2 || name.length() > 10){
			showText("INVALID NAME!\n"
                 + "A valid name must be between 2 and 10 characters long.");
			System.out.println(naming);
			name = userInput(); 
		}
		return name;
	}

	
	/************************************************************************************ 
	* Prompts the user to confirm a choice. User must enter "y" for yes, or "n" for no,
   * as is indicated by console output.
	* In: String representing the question needing confirmation.
	* Out/post: User is asked if they are sure and is given the valid responses. 
	* `			Returns a boolean, true if user says yes, false if no.
	************************************************************************************/
	public boolean isSure(String string) {
		String input;
		do {
			System.out.println(string + " (y)es/(n)o");
			input = userInput().toLowerCase();
		}while(!(input.equals("y") || input.equals("n")));
		return input.equals("y");
	}
	
	public boolean confirmRename() {
		return isSure("New player?\n"
							+ "WARNING: This will reset your stats!");
	}
	
	public boolean promptGiveUp() {
		return isSure("Do you wish to forfeit the game?");
	}
	
	
	public boolean promptPlayAgain() {
		return isSure("Do you wish you play again?");
	}
	
	/************************************************************************************ 
	* Asks the user if they would like to quit.
	* In: None
	* Out/post: User is asked if they want to exit.
					Returns a boolean equal to return from isSure().
	************************************************************************************/
	public boolean promptWantsToQuit() {
		return isSure("Exit the game?");
	}
	

	/************************************************************************************ 
	* Asks the user what difficulty they would like to play the next game at.
	* 1 for normal, 2 for challenge mode. Tells the user information about the difficulties.
	* In: none
	* Out/post: Return a value that corresponds to the enumerated difficulty, 0 for 
					normal, 1 for hard (i.e. the user's input minus one).
	************************************************************************************/	
	public int promptDifficulty(String difficultyText) {
		System.out.println(difficultyText);
		String input = userInput();
		while(!(input.equals("1") || input.equals("2"))) {
			showText("Invalid selection. Please select from one of the following options.");
			System.out.println("PLACEHOLDER_DIFFICULTY_1_2");
			input = userInput();
		}
		return Integer.parseInt(input) - 1;
	}
	

	
	
	public String promptPlayerMove(String[] colors, String moveOptions, String board) {
	/************************************************************************************ 
	* Prompt the user for a move during gameplay. Valid responses by the user are:
			i:   A sequence of 4-5 characters corresponding to the 6-7 valid colors.
			     e.g. "rygb", or "yygr" (red yellow green blue, or yellow yellow green red).
			ii:  "instructions"
			iii: "hint"
			iv:  "give up"
	  Validity of input is checked here (within isMoveValid()), array of valid colors
	  is passed in.
	* In: an array of strings representing which colors are valid for the difficulty
			of the current game.
	* Out/post: Returns a string which represents the player's move for their current turn.
	************************************************************************************/
		System.out.println(board + " " + moveOptions);
		String input = userInput().toUpperCase();
		while(!(isMoveValid(input, colors))) {
			showText("Invalid move!");
			System.out.println(moveOptions);
			input = userInput().toUpperCase();		
		}
		return input;
	}
	
	/************************************************************************************ 
	* Verifies that a player's move is valid. That is, it must be either a valid string
	* of 4-5 characters from roygbi(v), or one of "hint", "instructions", "give up".
	* In: A string representing the player's move, an array of strings representing
	*		the valid colors being used in the current game.
	* Out/post: Returns a boolean, true if the output is valid, false if it is not.
	************************************************************************************/
	public boolean isMoveValid(String move, String[] colors) {
		
		//Get the first character of each valid color into a string.
		StringBuffer colorsFirstChars = new StringBuffer(colors.length);
		for(int i = 0; i < colors.length; i++) {
			colorsFirstChars.append(colors[i].charAt(0)); /*append first char of color name
																			to the stringBuffer */
		}
		String validColors = colorsFirstChars.toString();
		
		//Checks for the three non-guess options.
		if(move.equals("GIVE UP") || move.equals("HINT") 
											 || move.equals("INSTRUCTIONS")) {
			return true;
		}
		
		//Checks for validity of potential guess input.
		if(move.length() != colors.length - 2) //6 colors => 4 pegs, 7 => 5
			return false; //String is incorrect length to be a guess.
			
		for(int i = 0; i < move.length(); i++) {
		 	if(validColors.indexOf(move.charAt(i)) == -1) /*Checks if all chars in 
																move are contained in validColors */
				return false; //a char was found which doesn't correspond to a valid color.
		}
		
		return true; //falls to here if input is a valid guess.
			
	}


	public void showInstructions(String[] instructions) {
		for(int i = 0; i < instructions.length; i++) {
			showText(instructions[i]);
		}	
	}
	
	
	public void pushUp() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n" 
							+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
							+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
							+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
		
	public String userInput() {
		System.out.print(" >");
		return keyboard.nextLine();
	}
	
}
	/************************************************************************************ 
	*
	* In: 
	* Out/post: -
	************************************************************************************/
	