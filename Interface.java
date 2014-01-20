public class Interface {

	
	
	public void showMainMenu() {
	
		System.out.println("Main menu goes here");
	}


	public void showWelcomeScreen() {
		System.out.println("Welcome screen goes here");
	}
	
	public void showInstructions() {
		System.out.println("Instructions go here");
	}
	
	public void showPlayerStats(int[] stats) {
		System.out.println("Stats go here");
	}
	
	public String promptUserName() {
		return "";
	}
	
	public void showAbout() {
		System.out.println("About info goes here");
	}
	
	public int promptMainMenu() {
	 	return Integer.parseInt("0");
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
				if(validColors.substring(0, 6 + difficulty).indexOf(input.charAt(1)) != -1);
		}
		return input.toLowerCase();
	}
}