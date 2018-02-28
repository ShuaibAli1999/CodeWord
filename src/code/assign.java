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
	private Location[][] board=new Location[5][5];
	
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
	
	//public void selected() {
	//	turns=-1;
	//}
	
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
		String[] x= aClue.split("[ \t\n¡ª-]");//try to separate the sentence into words.
		boolean legal=true;
		for(String s:x) {
			for(String c:Reveal.keySet()) {
				if(s.equals(c)&&Reveal.get(c)) {//if the clue has words that same as the code name that is revealed then is fine.
					legal=true;
				}
				if(s.equals(c)&&Reveal.get(c)==false) {//if clue has words same as codename that is not revealed if illegal.
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
		
	}
	
