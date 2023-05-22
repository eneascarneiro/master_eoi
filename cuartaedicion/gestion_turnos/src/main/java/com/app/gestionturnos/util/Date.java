package com.app.gestionturnos.util;

/**
 * 
 * @author rutpatel
 *
 */

public class Date {

	// DAYOFWEEK[1] gives MON, DAYOFWEEK[7] gives SUN...
	public static final String[] DAYOFWEEK = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

	// MONTH[12] gives DEC, MONTH[1] gives JAN...
	public static final String[] MONTH = { "EMPTY", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP",
			"OCT", "NOV", "DEC" };

	private final static int REFYEAR = 1990;

	private int day;
	private int month;
	private int year;
	private int dow;
	private boolean isHoliday;

	public Date(int month, int day, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.isHoliday = false;
	}

	public Date(int month, int day, int year, Date prev1st, int prevMonthDays) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.dow = (prev1st.getDow() + prevMonthDays) % 7;
		this.isHoliday = false;
	}

	public static boolean isLeapYear(int year) {
		boolean value = false;
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			value = true;
		}
		return value;
	}

	public static int calculateDowForJan1st(int year) {
		int numDays = 1;

		// add one day to the year after leap year
		for (int i = REFYEAR + 1; i <= year; i++) {
			if (isLeapYear(i - 1))
				numDays++;
			numDays++;
			// System.out.println(i + " : " + DAYOFWEEK[numDays % 7]);
		}

		return numDays % 7;
	}

	public boolean getIsHoliday() {
		return isHoliday;
	}

	public void setHoliday() {
		isHoliday = true;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the dow
	 */
	public int getDow() {
		return dow;
	}

	public void setDow(int dow) {
		this.dow = dow;
	}

	@Override
	public String toString() {
		String retval = month + "/" + day + "/" + year + " " + Date.DAYOFWEEK[dow];
		return retval;
	}

}
