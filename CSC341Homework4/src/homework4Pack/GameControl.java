package homework4Pack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class GameControl {
	
	protected Deck deck;
	protected List<Player> players;
	protected List<Card> discard;
	protected Player winner;
	
	public GameControl(){
		deck = new Deck();   
		deck.shuffle();	
		players = new ArrayList<Player>();
		//create a list for the used cards to go into
		discard = new ArrayList<Card>();
		winner=null;
		
		init();		
	}
	public void runGame(){
		
		startGame();
		endGame();
		
	}
	abstract void init();
	abstract void startGame();
	abstract void playRound();
	abstract void endGame();
	
	private String playersHands(){
		String hands = "";
		for(Player p : players){
			hands += "Player " + p.getName() + " hand size:" + p.numCards() + "\n" + p.handString() + "\n";
		}
		return hands;
	}
}




interface IGameView{
	void getResult(String prompt);
	void display(String message);
	<T> T getInput(String msg);
}
