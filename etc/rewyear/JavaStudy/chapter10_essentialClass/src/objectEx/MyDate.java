package objectEx;

public class MyDate {
	private int month;
	private int day;
	
	public MyDate(int month, int day)
	{
		this.month = month;
		this.day = day;
	}
	
	@Override
	public int hashCode() {
		return month + day;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyDate)
		{
			MyDate mydate = (MyDate)obj;
			if((this.month == mydate.month) && (this.day == mydate.day))
				return true;
			else
				return false;
		}
		return false;
	}
	@Override
	public String toString() {
		return this.month + "¿ù" + this.day + "ÀÏ";
	}
	
	
	

}
