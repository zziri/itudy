package singletonPatternEx;

public class Card {
	private int cardNumber;
	
	public Card(int serialNum)
	{
		cardNumber = serialNum;
	}
	
	public int getCardNumber()
	{
		return cardNumber;
	}
}
