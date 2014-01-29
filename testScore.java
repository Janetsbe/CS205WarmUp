import java.util.ArrayList;

public class testScore {

	private static String[] abbrColors = {"R","O", "Y", "G", "B", "I", "V"};
	private static String[] trueColors = {"Red", "Orange","Yellow", "Green", "Blue", "Indigo", "Violet"};
	private static int difficulty;
	private static int turnsUsed;
	//private static String feedback = "";
	private static boolean hintUsed;
	private static StringBuffer gameboard;
	private static String[] currPegOrder;

	
	
	private static String pegOrder = "ROYG";
	
	public static void main(String[] args) {
		System.out.println(scoreGuess("GROG"));
	
	}
	
	public static String[] strToStrArray(String s){
		String[] temp = new String[s.length()];
		for(int i = 0; i < s.length(); i++){
			temp[i] = Character.toString(s.charAt(i));
		}
		return temp;
	}
	
	/*	
	public static boolean scoreGuess(String guess) {
		String answer = pegOrder;
		StringBuffer feedback = new StringBuffer("");
		
		boolean[] used = new boolean[answer.length()];
		
		for(int i = 0; i < used.length; i++) {
			used[i] = false;
		}
		for(int i = 0; i < answer.length(); i++){ //checks for exact matches
			if(answer.charAt(i) == guess.charAt(i)) {
				feedback.append("2");
				used[i] = true;
			}	
		}
		
		
		if(feedback.toString().equals("2222")) { //If it's all 2s, we're done.
			return true;
		}
		
		
		for(int i = 0; i < guess.length(); i++) {
			for(int j = 0; j < answer.length(); j++) {
				if(guess.charAt(i) == answer.charAt(i) && i != j && !used[i]) {
					feedback.append("1");
				}
			}
		}
		for(int i = answer.length() - feedback.length(); i > 0; i--) {
			feedback.append("0");
		}
		System.out.println(feedback);
	   return false;
	}*/
	
	public static boolean scoreGuess(String userGuess){
		boolean check = true;
		String zeros = "";
		ArrayList<String> rightPegs = new ArrayList<String>();
		ArrayList<String> wrongPegs = new ArrayList<String>();
		ArrayList<String> key = new ArrayList<String>();
		String feedback = "";
		
		String[] guessArray = strToStrArray(userGuess);
		String[] pegOrderArray = strToStrArray(pegOrder);
		
		for (int i = 0; i < pegOrder.length(); i++){ 
			if (!guessArray[i].equals(pegOrderArray[i])){
				check = false;
				wrongPegs.add(guessArray[i]);
				key.add(pegOrderArray[i]);
			}
			else {
				rightPegs.add(guessArray[i]);
			}
		}
		
		for (int i = 0; i < rightPegs.size(); i++){
			feedback = feedback + "2";
		}
		
		int numWrong = wrongPegs.size();
		for (int i = 0; i < numWrong; i++){
			if (key.contains(wrongPegs.get(0))){
				feedback = feedback + "1";
				key.remove(wrongPegs.get(0));
			}
			else {
				zeros += "0";
			}
			wrongPegs.remove(0);
		}
		
		feedback = feedback + zeros;

		
		currPegOrder = guessArray;
		turnsUsed++; // 3.
		System.out.println(feedback);
		//gameboard = GameText.setGameBoard(turnsUsed, userGuess, feedback, check, gameboard);
		return check; // 5.
		
	}

}