package Laboratory5;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public static boolean isLeapYear(int year) {
		if(year % 4 != 0) {
			return false;
		} else if(year % 400 == 0) {
			return true;
		} else if(year % 100 == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isValid(int year, int month, int day) {
		if (year <= 1000 || year >= 9999) {
			return false;
		}
		if(month < 1 || month > 12) {
			return false;
		}
		if(day < 1 || day > 31) {
			return false;
		}
		switch(month) {
			case 1: return true;
			case 2: if((year % 4  != 0) || (year % 100 == 0)) return day < 29;
					else return day < 30;
			case 3: return true;
			case 4: return day < 31;
			case 5: return true;
			case 6: return day < 31;
			case 7: return true;
			case 8: return true;
			case 9: return day < 31;
			case 10: return true;
			case 11: return day < 31;
			default: return true;
		}
	}
	
	public Date(int year, int month, int day) throws IllegalArgumentException{
		if(!isValid(year, month, day)) {
			throw new IllegalArgumentException();
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}
		
}
