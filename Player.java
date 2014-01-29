class Player {
	private String playerName;
	private int[] gamesPlayed;
	private int[] totalWins;
	private int[] totalTurns;
	private int[] totalWinTurns;
	
	//basic constructor
	public Player(String name) {
		playerName = name;
		gamesPlayed = new int[2];
		totalWins = new int[2];
		totalTurns = new int[2];
		totalWinTurns = new int[2];
	}
	
	//all set functions
	public void updateStats(int win, int turns, int d){
		gamesPlayed[d]++;
		totalWins[d] += win;
		totalTurns[d] += turns;
		totalWinTurns[d] += win*turns;
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
		totalLosses[0] = totalTurns[0] - totalWins[0];
		totalLosses[1] = totalTurns[1] - totalWins[1];
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
		turnsWinsRatio[0] = (int) (((double) totalWins[0] / totalTurns[0]) * 100);
		turnsWinsRatio[1] = (int) (((double) totalWins[1] / totalTurns[1]) * 100);
		return turnsWinsRatio;
	}
	
	public int[] getAvgTurns(){
		int [] avgTurns = new int[2];
		avgTurns[0] = totalTurns[0] / gamesPlayed[0];
		avgTurns[1] = totalTurns[1] / gamesPlayed[1];
		return avgTurns;
	}

	public int[] getAvgWinTurns(){
		int [] avgWinTurns = new int[2];
		avgWinTurns[0] = totalWinTurns[0] / totalWins[0];
		avgWinTurns[1] = totalWinTurns[1] / totalWins[1];
		return avgWinTurns;
	}
}