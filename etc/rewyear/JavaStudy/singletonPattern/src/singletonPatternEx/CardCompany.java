package singletonPatternEx;

public class CardCompany {
	private CardCompany() {}
	
	private static CardCompany instance = new CardCompany();
	private static int serialNum = 10000;
	
	public static CardCompany getInstance()
	{
		if(instance == null)
			instance = new CardCompany();
		
		return instance;
	}
	
	public static Card createCard()
	{
		serialNum += 1;
		return new Card(serialNum);
	}
	

}
