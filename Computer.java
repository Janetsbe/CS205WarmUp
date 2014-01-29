import java.util.ArrayList;
import java.util.Arrays;

class Computer {
	private String pegOrder;
	private String[] abbrColors = {"R","O", "Y", "G", "B", "I", "V"};
	private String[] trueColors = {"Red", "Orange","Yellow", "Green", "Blue", "Indigo", "Violet"};
	private int difficulty;
	private int turnsUsed;
	private String feedback;
	private boolean hintUsed;
	private StringBuffer gameboard;
	private String[] currPegOrder;
	
	public Computer(int d){
		difficulty = d;
		pegOrder = calcPegOrder();
		feedback = "";
		pegOrder = "";	
	}
	
	//Generates the answer to the game
	public String calcPegOrder(){
		int num = 4 + difficulty;
		
		for (int i = 0; i < num; i++){
			int randNum = (int)(Math.random()*(num+2));
			pegOrder += abbrColors[randNum];
		}
		
		return pegOrder;	
	}

	public void setTurnsUsed(int t){
		turnsUsed = t;
	}
	public void setHintUsed(){
		hintUsed = true;
	}
	public boolean getHintUsed(){
		return hintUsed;
	}
	
	//All get functions
	public String getPegOrder(){
		return pegOrder;		
	}
	public int getDifficulty(){
		return difficulty;
	}	
	public int getTurnsUsed(){
		return turnsUsed;
	}	
	public StringBuffer getMiddleGameboard(){
		return gameboard;
	}
	
	public String[] strToStrArray(String s){
		String[] temp = new String[s.length()];
		for(int i = 0; i < s.length(); i++){
			temp[i] = Character.toString(s.charAt(i));
		}
		return temp;
	}
	
	public boolean scoreGuess(String userGuess){
		boolean check = true;
		String zeros = "";
		ArrayList<String> rightPegs = new ArrayList<String>();
		ArrayList<String> wrongPegs = new ArrayList<String>();
		ArrayList<String> key = new ArrayList<String>();
		
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
		gameboard = GameText.setGameBoard(turnsUsed, userGuess, feedback, check, gameboard);
		return check; // 5.
		
	}
	

	public String giveHint(){
		ArrayList<String> hints = new ArrayList<String>();
		String strColor;
		for (int i = 0; i < pegOrder.length(); i++){
			if (!currPegOrder[i].equals(strToStrArray(pegOrder)[i])){
				hints.add(strToStrArray(pegOrder)[i]);
			}
		}
		
		if (hints.size() == 1){
			strColor = hints.get(0);
		}
		else{
			int randHint = (int)(Math.random()*(hints.size()-1));
			strColor =  hints.get(randHint);
		}
		setHintUsed();
		return trueColors[Arrays.asList(abbrColors).indexOf(strColor)]; 
	}
	
	public String[] getTrueValidColors() {
		if (difficulty == 1){
			return trueColors;
		}
		else{
			return Arrays.copyOfRange(trueColors, 0, trueColors.length-1);
		}
	}
	
	
	public String[] getAbbrValidColors() {
		if (difficulty == 1){
			return abbrColors;
		}
		else{
			return Arrays.copyOfRange(abbrColors, 0, abbrColors.length-1);
		}
	}
	
	public String getFeedback(){
		return feedback;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}