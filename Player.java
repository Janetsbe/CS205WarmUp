class Player {
	private String playerName;
	private int[] gamesPlayed;
	private int[] totalWins;
	private int[] totalTurns;
	
	//basic constructor
	public Player(String name) {
		playerName = name;
		gamesPlayed = new int[2];
		totalWins = new int[2];
		totalTurns = new int[2];
	}
	
	//all set functions
	public void updateStats(int win, int turns, int d){
		gamesPlayed[d]++;
		totalWins[d] += win;
		totalTurns[d] += turns;
	}

	
	//all basic get functions
	public String getPlayerName(){
		return playerName;
	}
	public int[] getGamesPlayed(){
		return gamesPlayed;
	}
	public int[] getTotalWins(){
		return totalWins;
	}
	public int[] getTotalTurns(){
		return totalTurns;
	}
	
	
	//all calculated get functions
	public int[] getTotalLosses(){
		int[] totalLosses = new int[2];
		totalLosses[0] = gamesPlayed[0] - totalWins[0];
		totalLosses[1] = gamesPlayed[1] - totalWins[1];
		return totalLosses;
	}
	public String[] getWinLoseRatio(){
		String[] winLoseRatio = new String[2];
		winLoseRatio[0] = totalWins[0] + ":" + getTotalLosses()[0];
		winLoseRatio[1] = totalWins[1] + ":" + getTotalLosses()[1];
		return winLoseRatio;
	}
	public int[] getTurnsWinsRatio(){
		int[] turnsWinsRatio = new int[2];
		if(totalWins[0] == 0){
			turnsWinsRatio[0] = 0;
		}
		else{
			turnsWinsRatio[0] = (int) ((((double) totalTurns[0]) / totalWins[0]));
		}
		if(totalWins[1] == 0){
			turnsWinsRatio[1] = 0;
		}
		else{
			turnsWinsRatio[1] = (int) ((((double) totalTurns[1]) / totalWins[1]));
		}
		
		return turnsWinsRatio;
	}
	
	public int[] getAvgTurns(){
		int [] avgTurns = new int[2];
		if(gamesPlayed[0] == 0 || gamesPlayed[1] == 0){
			avgTurns[0] = 0;
			avgTurns[1] = 0;		
		}
		else{
			avgTurns[0] = totalTurns[0] / gamesPlayed[0];
			avgTurns[1] = totalTurns[1] / gamesPlayed[1];
		}
		return avgTurns;
	}

}