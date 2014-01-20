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
	
}