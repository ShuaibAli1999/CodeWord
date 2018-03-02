package code;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import code.Location;
import code.CodenamesList;
import code.PersonAssignments;

public class assign {
	private ArrayList<String>codenames=new ArrayList<String>();
	private ArrayList<String>person=new ArrayList<String>();
	private HashMap<String,String>assginedCodeName;
	private HashMap<String,Boolean> Reveal;
	private int turns=1;//1 is red team's turn, -1 is blue team's turn.
	private int turnCount = 1;
	private int count2red=0;
	private int count2blue=0;
	private int redTotal;
	private int blueTotal;
	private Location[][] board=new Location[5][5];
	public assign() {
		redTotal = 9;
		blueTotal = 8;
	}
	
	public void setCodenames(ArrayList<String>codename){
		this.codenames=codename;
	}
	public void setPerson(ArrayList<String>person) {
		this.person=person;
	}
	public ArrayList<String> getcodename(){
		return codenames;
	}
	public ArrayList<String> getperson(){
		return person;
	}
	
	public void gameStarted(CodenamesList cod,PersonAssignments per) throws FileNotFoundException, IOException{//set up for the game.
		turns=1;//red team's turn
		assginedCodeName=new HashMap<String,String>();
		Reveal=new HashMap<String,Boolean>();// boolean with be true if is revealed, false will be not reveals
		setCodenames(cod.getList());
		setPerson(per.getList());
		assignCodeName(codenames,person);
		board=namesOnBoard(codenames);
	}
	
	public void  assignCodeName(ArrayList<String>codename,ArrayList<String>agents){//map each codenames to the person.
		HashMap<String, String> assgin=new HashMap<String,String>();
		for(int i=0;i<codename.size();i++) {
			assgin.put(codename.get(i),agents.get(i));
		}
		assginedCodeName=assgin;
		
		for(String y:codename) {
			Reveal.put(y, false); //false means that the codenames is not reveal.
		}	
	}
	
	public void selected(Location theLocationThatSelected) {
		if(turns==1) {//make sure each time is turn for different turn.
		turns=-1;
		}
		else if(turns==-1){
		turns=1;
		}
		Reveal.put(theLocationThatSelected.getName(), true); //make the boolean to true which means that the codename is revealed.
	}
	public boolean updateLocation(Location theLocation) {
		Reveal.put(theLocation.getName(), true); //set the code name related to the location to revealed
		if(turnCount%2!= 0) {//if it is reds turn
		if(assginedCodeName.get(theLocation.getName())=="red agent") {
			redTotal--;//decrement total red agents
			return true;
		}
		else if(assginedCodeName.get(theLocation.getName())=="blue agent") {
			blueTotal--;//decrement total blue agents
			return false;
		}
		}
		if(turnCount%2== 0) {
			if(assginedCodeName.get(theLocation.getName())=="blue agent") {
				redTotal--;
				return true;
			}
			else if(assginedCodeName.get(theLocation.getName())=="red agent") {
				blueTotal--;
				return false;
			}
		}
		return false;
		
	}
	public Location[][] namesOnBoard(ArrayList<String>codename){
		
		Location[][] l=new Location[5][5];
		int indexInCode=0;//index in the arraylist of the hashmap keset which are the unreveal codenames.
		for(int i=0;i<l.length;i++) {//loop and get the codename to show on the board.
			for(int j=0;j<l[0].length;j++) {
				if(indexInCode<25) {
					l[i][j]=new Location(codename.get(indexInCode));
					indexInCode=indexInCode+1;
				}
			}
		}
		return l; //return the board with string on each index
	}
	
	public int turn() {//showing who's turn
		int num=turns;
		return num;
	}
	
	public boolean clue(String aClue) {
		String[] x= aClue.split("[ \t\n��-]");//try to separate the sentence into words.
		boolean legal=true;
		for(String s:x) {
			for(String c:Reveal.keySet()) {
				if(s.equals(c)&&Reveal.get(c)) {//if the clue has words that same as the code name that is revealed then is fine.
					legal=true;
				}
				if(s.equals(c)&&Reveal.get(c)==false) {//if clue has words same as codename that is not revealed if illegal.
					if(turns==1) {//if clue is illegal then the team's turn is forfeit
						turns=-1;
						}
					else if(turns==-1){//should remember to call to update the frame and call observer()
						turns=1;
						}
					return false;
				}
				if(s.equals(c)==false) {//if clue doesn't have words same as codename, then it is legal.
					legal=true;
				}
			}
		}
		return legal;
	}
	
	public Location[][] getBoard(){
		return board;
	}
	
	public HashMap<String,String> getAssignedCodeNameandValues(){
	return assginedCodeName;
	}
	
	public HashMap<String,Boolean> getReveal(){
		return Reveal;
	}
	public int getRedTotal() {
		return redTotal;
	}
	public int getBlueTotal() {
		return blueTotal;
	}
	public int winningState() {
		int playerTurn = turnCount%2;// if player turn equals 1 it is red's turn. if player turn equals 0 it is blue's turn
		int count1blue = 0;
		
		int count1red = 0;
		
		
		for(String code: Reveal.keySet()) {
			if(Reveal.get(code)) {//iteration through hashmap to see which code names are associated with a true value
				if(assginedCodeName.get(code)=="assassin") { // iteration through hashmap to see which role is associated with revealed code name 
					return 0; //return 0 means turn needs to be checked to find winner
				}
				if(assginedCodeName.get(code)=="blue agent") {
					count1blue++;
					if(count1blue==8) {
						return 1;//return 1 means game is in winning state and blue wins
					}
				}
				if(assginedCodeName.get(code)=="red agent") {
					count1red++;
					if(count1red==9) {
						return -1;// return -1 means game is in winning state and red wins
					}
				}
			}
			
			
		}
		if(playerTurn!=0 && count1red==count2red) {//checks if when it is red teams turn if 1 more red agent was revealed. If so the turn count is not changed
				turnCount++;
			}
			if(playerTurn==0 && count1blue==count2blue) {// checks if when it is blue teams turn if 1 more blue agent was revealed. If so the turn count is not changed
				turnCount++;
			}
			count2red = count1red;
			count2blue = count1blue;
		return 10;//means board not in game winning state
	}
	
	}
	
