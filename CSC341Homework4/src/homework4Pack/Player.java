package homework4Pack;
import java.util.*;

public abstract class Player {
	protected Hand pHand;
	protected String playerName;
	
	public Player(String name){
		pHand = new Hand();
		playerName = name;
	}
	
	public String getName(){ return playerName; }
	public int numCards(){
		return pHand.getCardCount();
	}
	
	public void getCard(Card c){
		pHand.addCard(c);
	}
	
	public Card giveCard(){
		if(pHand.getCardCount() == 0) return null;
		Random rd = new Random();
		int i = rd.nextInt(pHand.getCardCount());
		Card toReturn = pHand.getCard(i);
		pHand.removeCard(i);
		return toReturn;
	}
	
	public Card giveCard(int position){
		int count = pHand.getCardCount(); 
		if( count == 0 || (position < 0 || position >= count) ) return null;
		Card toReturn = pHand.getCard(position);
		pHand.removeCard(position);
		return toReturn;
	}
	
	public boolean isHandEmpty(){
		return pHand.getCardCount() == 0;
	}
	
	public String handString(){
		String str = "";
		for(int i = 0; i < pHand.getCardCount(); i++){
			str += pHand.getCard(i).toString() + ", ";
		}
		return str;
	}
	
	public void removePairs(){
		pHand.removePairs();
	}
	
	public Card removeMatchingCard(Card c) {
		return pHand.removeMatchingCard(c);
	}
		
	
}

class CrazyPlayer extends Player{

	public CrazyPlayer(String name) {
		super(name);
		
	}
	
}
