package homework4Pack;

public class CrazyController extends GameControl {

	@Override
	void init() {
		for(int i = 1; i<=4;i++) {
			players.add(new CrazyPlayer("PLAYER "+i));
		}
		
		
	}

	@Override
	void startGame() {
		dealCards();
		discard.add(deck.dealCard());
		while(winner==null) {
			playRound();
		}
		
		
		
	}

	@Override
	void playRound() {
		for(Player p: players) {
			
			Card toAdd = null;
			if(p.isHandEmpty()) {
				//this means someone won!
				winner = p;
				return;
			}
			while(toAdd==null) {
				
				toAdd = p.removeMatchingCard(discard.get(discard.size()-1));
				if(toAdd==null) {
					
					p.getCard(deck.dealCard());
				}
				
				
				if(deck.cardsLeft()==0) {
					System.out.println("Discard pile being shuffled!");
					Card[] newDeck = discard.toArray(new Card[discard.size()]);
					deck=new Deck(newDeck);
					deck.shuffle();
					discard.removeAll(discard);
					discard.add(deck.dealCard());
				}
				
				
			}
			
			discard.add(toAdd);
			
		}
		
	}

	@Override
	void endGame() {
		//at the end of game, display the winner
		System.out.println("WINNER: "+winner.getName());
		}
		
	
	private void dealCards(){
		   for(Player p : players){
			   for(int i = 0; i < 7; i++) {
				   p.getCard(deck.dealCard()); 
				   
			   }
		    	
		    	
		   }	    		
		
	 }

}
