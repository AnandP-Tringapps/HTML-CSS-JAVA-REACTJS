package cardgame;

import java.util.List;

public class Player3 implements PlayerStrategy{
	int playerId;
	List<Integer> opponentIds;
	List<Card> myCards;
	Card topPileCard;
	Card.Suit changedSuit;
    //assigning five cards to the player
	public void receiveInitialCards(List<Card> cards)
	{
		this.myCards=cards;
	}
	
	//checking the topcard present in the players deck
	public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit) {
		this.topPileCard=topPileCard;
		this.changedSuit=changedSuit;
		if(changedSuit==null) 
		{
			for(int i=0;i<myCards.size();i++)
			{
				if(myCards.get(i).getSuit().equals(topPileCard.getSuit())||myCards.get(i).getRank().equals(topPileCard.getRank()))
				{
					return false;
				}
			}
		}
		else 
		{
			for(int i=0;i<myCards.size();i++)
			{
				if(myCards.get(i).getSuit().equals(changedSuit)) 
				{
					return false;
				}
			}
		}
		return true;
		
	}
	//taking top card from deck
	public void receiveCard(Card drawnCard) 
	{
		System.out.println("Player - 3 recieved :"+drawnCard.getRank()+" "+drawnCard.getSuit());
		myCards.add(drawnCard);
	}

	//applying the logic whether the player has put which card
	public Card playCard() {
        int temp=0;
		Card dropCard=null;
		if(changedSuit==null) 
        {
			for(int i=0;i<myCards.size();i++) 
			{
				if(myCards.get(i).getRank().equals(topPileCard.getRank()))
				{
					System.out.println("Player - 3 played : "+myCards.get(i).getRank()+" "+myCards.get(i).getSuit());
					dropCard=myCards.get(i);
					myCards.remove(i);
					temp++;
				}
			}
            if(temp==0)
            {
                for(int i=0;i<myCards.size();i++) 
			    {
                    if(myCards.get(i).getSuit().equals(topPileCard.getSuit()))
				{
					System.out.println("Player - 3 played : "+myCards.get(i).getRank()+" "+myCards.get(i).getSuit());
					dropCard=myCards.get(i);
					myCards.remove(i);
					
				}
                }
            }
		}
		else 
        {
			for(int i=0;i<myCards.size();i++) 
            {
				if(myCards.get(i).getSuit().equals(changedSuit)) 
                {
					System.out.println("Player - 3 played : "+myCards.get(i).getRank()+" "+myCards.get(i).getSuit());
					dropCard=myCards.get(i);
					myCards.remove(i);
					break;
				}
			}
		}
		return dropCard;
		
	}
	
	
	
	//choosing suit by checking which suit has player hold many
	public Card.Suit declareSuit(){
		Card declaredSuit=myCards.get(0);
		int max=0,count=0;
		for(int i=0;i<myCards.size();i++) 
		{
			count=0;
			for(int j=0;j<myCards.size();j++) 
			{
				if(myCards.get(i)==myCards.get(j))
					count++;
			}
			if(count>max)
			{
				max=count;
				declaredSuit=myCards.get(i);
			}
		}
		System.out.println("\n Delcare suit : "+declaredSuit.getSuit());
		return declaredSuit.getSuit();
		
	}
	public void processOpponentActions(List<PlayerTurn> opponentActions) {
		
	}
	 public void reset() {
		 
	 }
	@Override
	public int getScore() {
		int point=0;
		for(int i=0;i<myCards.size();i++) {
			point+=myCards.get(i).getPointValue();
		}
		return point;
	}
}
