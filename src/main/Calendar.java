package main;

public class Calendar {

	int year;

	public Calendar(int year) {
		this.year = year;
	}

	public boolean isLeapYear(){
		if (year <= 0) 
			throw new ArrayIndexOutOfBoundsException("Year has to be a positive integer value");
		
		return (this.year > 0 && this.year % 4 == 0) && (this.year % 100 != 0 || this.year % 400 == 0);
	}
}
