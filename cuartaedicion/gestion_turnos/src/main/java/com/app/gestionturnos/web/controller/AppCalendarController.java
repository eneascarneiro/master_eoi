/**
 * 
 */
package com.app.gestionturnos.web.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.gestionturnos.model.Event;
import com.app.gestionturnos.util.Date;
import com.app.gestionturnos.service.EventService;
import com.app.gestionturnos.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @author rutpatel
 *
 */
@Controller
public class AppCalendarController  extends  AbstractControllerMenu {
	private final EventService service;
	HashMap<String, ArrayList<Date>> calendar = new HashMap<>();

	// this map is used to store "JAN" -> 6 rows with 7 columns - empty spaces for
	// days not of this month
	HashMap<String, Date[][]> dateValues = new HashMap<>();
	List<Event> eventListPantalla = new ArrayList<>();
	List<Event> eventListDB = new ArrayList<>();
	HashMap<String, String> holidayDates = new HashMap<>();

	protected AppCalendarController(MenuService menuService, EventService service) {
		super(menuService);
		this.service = service;
	}

	@GetMapping("/calendario/cal")
	public ModelAndView doGet() {
		int year = LocalDate.now().getYear();
		return doPost(String.valueOf(year));
	}

	@PostMapping("/calendario/Calendar")
	public ModelAndView doPost(@RequestParam String year) {
		ModelAndView mv = null;

		int yr = Integer.parseInt(year);

		buildCalendar(yr); // Calendar hash map is built.

		// https://www.redcort.com/us-federal-bank-holidays/
		setAllHolidays(yr); // isHoliday field of date set to true if its a holiday

		formatDates();

		mv = new ModelAndView("calendario/calendar");

		mv.addAllObjects(dateValues);
		mv.addAllObjects(holidayDates);
		mv.addObject("year", year);
		mv.addObject("medicamentos", "Ibuprofeno");

		return mv;
	}

	@GetMapping("/calendario/calmes")
	public ModelAndView doGetMes() {
		int intmonth = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		return doPostMes(String.valueOf(intmonth),String.valueOf(year));
	}

	@PostMapping("/calendario/Calendarmes")
	public ModelAndView doPostMes(@RequestParam String month ,@RequestParam String year) {
		ModelAndView mv = null;
		calendar.clear();
		dateValues.clear();
		eventListDB.clear();
		eventListPantalla.clear();

		int yr = Integer.parseInt(year);
		int mo = Integer.parseInt(month);

		//Construimos el calendario
		buildCalendar(mo,yr); // Calendar hash map is built.
		//Generamos un
		String strdaymin =  	year + "-" +
				String.format("%02d" , mo) + "-01 00:00:00";
		String strdaymax =  	year + "-" +
				String.format("%02d" , mo+1) + "-01 00:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTimemin = LocalDateTime.parse(strdaymin, formatter);
		LocalDateTime dateTimemax = LocalDateTime.parse(strdaymax, formatter);
		//Buscamos en la lista
		eventListDB = service.getRepo().findEventByFechahoraBetween(dateTimemin,dateTimemax );
		//Volcamos datos al "dto"
		// https://www.redcort.com/us-federal-bank-holidays/
		//setAllHolidays(yr); // isHoliday field of date set to true if its a holiday
		formatDatesEvent(Date.MONTH[mo]);
		mv = new ModelAndView("calendario/calendarunmes");

		mv.addAllObjects(dateValues);
		mv.addObject("events", eventListPantalla);
		mv.addObject("year", year);
		mv.addObject("month", mo);

		return mv;
	}

	private void formatDates() {
		for (String mon : Date.MONTH) {
			if (mon.equals("EMPTY"))
				continue;
			System.out.println("formatDates Mes selecionado:" + mon );

			ArrayList<Date> month = calendar.get(mon);
			dateValues.put(mon, dateFormatter(month));
		}
	}

	private void formatDatesEvent(String monthin) {

		System.out.println("formatDates Mes selecionado:" + monthin );

		ArrayList<Date> month = calendar.get(monthin);
		dateValues.put(monthin, dateFormatterEvent(month));
	}

	private Date[][] dateFormatter(ArrayList<Date> month) {
		int dayPointer = 0;
		Date[][] days = new Date[6][7];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (dayPointer < month.size()) {
					if (month.get(dayPointer).getDow() == j) {
						days[i][j] = month.get(dayPointer);
						dayPointer++;
						continue;
					}
				}
				Date nullDate = null;
				days[i][j] = nullDate;
			}
		}
		return days;
	}

	private Date[][] dateFormatterEvent(ArrayList<Date> month) {
		int dayPointer = 0;
		Date[][] days = new Date[6][7];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (dayPointer < month.size()) {
					if (month.get(dayPointer).getDow() == j) {
						System.out.println("dateFormatterEvent dia mes:" + month.get(dayPointer) );
						days[i][j] = month.get(dayPointer);
						//Comnponemos los eventos para la pantalla
						for (Event event : eventListDB){
							if (event.getDiames().equals( month.get(dayPointer).getDay())){
								eventListPantalla.add(event);
							}
							//else {
							//	Event eventSoloDia = new Event();
							//	eventSoloDia.setDiames(month.get(dayPointer).getDay() );
							//	//eventSoloDia.setEspecializacion(String.valueOf(month.get(dayPointer).getDay()));
							//	eventListPantalla.add(eventSoloDia);
							//}
						}
						dayPointer++;
						continue;
					}
				}
				Date nullDate = null;
				days[i][j] = nullDate;
			}
		}
		return days;
	}


	private void setAllHolidays(int year) {
		// new years day
		calendar.get("JAN").get(0).setHoliday();
		holidayDates.put("NewYearsDay", "New Year's Day : " + calendar.get("JAN").get(0));

		// mlk junior day - 3rd monday in jan
		holidayDates.put("MLKDay", "MLK Jr. Day : " + setAsHoliday(calendar.get("JAN"), "MON", 3));

		// george washington day - 3rd monday in feb
		holidayDates.put("PresidentsDay", "President's Day : " + setAsHoliday(calendar.get("FEB"), "MON", 3));

		// // set easter
		// Date[] dates = setEaster(year);
		// if (dates[0] != null) {
		// holidayDates.put("EasterSunday", "Easter Sunday : " + dates[0]);
		// }
		// if (dates[1] != null) {
		// holidayDates.put("GoodFriday", "Good Friday : " + dates[1]);
		// }

		// memorial day - last monday in may
		holidayDates.put("MemorialDay", "Memorial Day : " + setLastDayOccurrance(calendar.get("MAY"), "MON"));

		// independence day
		calendar.get("JUL").get(3).setHoliday();
		holidayDates.put("IndependenceDay", "Independence Day : " + calendar.get("JUL").get(3));

		// labor day - 1st monday in sep
		holidayDates.put("LaborDay", "Labor Day : " + setAsHoliday(calendar.get("SEP"), "MON", 1));

		// columbus day - 2nd monday in oct
		holidayDates.put("ColumbusDay", "Columbus Day : " + setAsHoliday(calendar.get("OCT"), "MON", 2));

		// veterans day on nove 11. If its a sunday, move to nov 12.
		if (calendar.get("NOV").get(10).getDow() == 0) {
			calendar.get("NOV").get(11).setHoliday();
			holidayDates.put("VeteransDay", "Veterans Day : " + calendar.get("NOV").get(11));
		} else {
			calendar.get("NOV").get(10).setHoliday();
			holidayDates.put("VeteransDay", "Veterans Day : " + calendar.get("NOV").get(10));

		}

		// thanksgiving
		holidayDates.put("Thanksgiving", "Thanksgiving : " + setAsHoliday(calendar.get("NOV"), "THU", 4));

		// christmas day
		calendar.get("DEC").get(24).setHoliday();
		holidayDates.put("Christmas", "Christmas : " + calendar.get("DEC").get(24));
	}

	private Date[] setEaster(int year) {
		ArrayList<Date> apr = calendar.get("APR");
		ArrayList<Date> mar = calendar.get("MAR");
		Date[] dates = new Date[2];

		// full moon chart constraints
		if (2014 <= year && year <= 2031) {
			Date fullMoon = null;

			int rem = (year + 1) % 19;

			switch (rem) {
				case 1:
					fullMoon = apr.get(13);
					break;
				case 2:
					fullMoon = apr.get(2);
					break;
				case 3:
					fullMoon = mar.get(22);
					break;
				case 4:
					fullMoon = apr.get(10);
					break;
				case 5:
					fullMoon = mar.get(30);
					break;
				case 6:
					fullMoon = apr.get(17);
					break;
				case 7:
					fullMoon = apr.get(7);
					break;
				case 8:
					fullMoon = mar.get(27);
					break;
				case 9:
					fullMoon = apr.get(15);
					break;
				case 10:
					fullMoon = apr.get(4);
					break;
				case 11:
					fullMoon = mar.get(24);
					break;
				case 12:
					fullMoon = apr.get(12);
					break;
				case 13:
					fullMoon = apr.get(1);
					break;
				case 14:
					fullMoon = mar.get(21);
					break;
				case 15:
					fullMoon = apr.get(9);
					break;
				case 16:
					fullMoon = mar.get(29);
					break;
				case 17:
					fullMoon = apr.get(16);
					break;
				case 18:
					fullMoon = apr.get(6);
					break;
			}

			int temp = fullMoon.getDow();
			int daysToFriday = 0;
			int daysToSunday = 0;
			System.out.println("fullMoon.DOW: " + temp + ", fullMoon.day: " + fullMoon.getDay());

			if (Date.DAYOFWEEK[fullMoon.getDow() + 1].equals("FRI"))
				daysToFriday = -1;
			else {
				while (!Date.DAYOFWEEK[temp].equals("FRI")) {
					System.out.println("temp: " + temp + ", DOW: " + Date.DAYOFWEEK[temp]);
					temp = (temp == 0) ? 6 : (temp - 1) % 7;
					daysToFriday++;
				}
			}

			temp = fullMoon.getDow();
			while (!Date.DAYOFWEEK[temp].equals("SUN")) {
				temp = (temp + 1) % 7;
				daysToSunday++;
			}

			// Set easter sunday as holiday
			if (fullMoon.getDay() + daysToSunday > 31) {
				// Easter sunday falls in april
				// So set first sunday in april as holiday
				dates[0] = setAsHoliday(apr, "SUN", 1);
			} else {
				if (fullMoon.getMonth() == 3) {
					// use the index (1 less than actual date) and set it as holiday
					mar.get((fullMoon.getDay() + daysToSunday) - 1).setHoliday();
					dates[0] = mar.get((fullMoon.getDay() + daysToSunday) - 1);
				} else {
					apr.get((fullMoon.getDay() + daysToSunday) - 1).setHoliday();
					dates[0] = apr.get((fullMoon.getDay() + daysToSunday) - 1);
				}
			}

			// Set good friday as holiday
			if (fullMoon.getDay() - daysToFriday < 1) {
				// Good friday falls in march
				// So set last friday in march as holiday
				dates[1] = setLastDayOccurrance(mar, "FRI");
			} else {
				if (fullMoon.getMonth() == 3) {
					mar.get((fullMoon.getDay() - daysToFriday) - 1).setHoliday();
					dates[1] = mar.get((fullMoon.getDay() - daysToFriday) - 1);
				} else {
					apr.get((fullMoon.getDay() - daysToFriday) - 1).setHoliday();
					dates[1] = apr.get((fullMoon.getDay() - daysToFriday) - 1);
				}
			}
		} // end if (2014 <= year && year <= 2031)

		return dates;
	}

	/**
	 * Returns the date of nth occurrance of a day of the week in a month
	 *
	 * @param month
	 * @param dayOfWeek
	 * @param nthOccurrance
	 * @return
	 */
	private Date setAsHoliday(ArrayList<Date> month, String dayOfWeek, int nthOccurrance) {
		Date holiday = null;
		int occurrances = 0;
		for (int i = 0; i < month.size(); i++) {
			int dow = month.get(i).getDow();
			if (Date.DAYOFWEEK[dow].equals(dayOfWeek)) {
				occurrances++;
			}
			if (occurrances == nthOccurrance) {
				month.get(i).setHoliday();
				holiday = month.get(i);
				break;
			}
		}
		return holiday;
	}

	/**
	 * Sets last occurrance of specified day in a month as holiday
	 *
	 * @param month
	 * @param dayOfWeek
	 */
	private Date setLastDayOccurrance(ArrayList<Date> month, String dayOfWeek) {
		// loop will run backward from end of month
		// and will set as holiday the first occurrance of the specified day
		// This deals with months which may have 4 or 5 occurrances of a day
		// either of which may be the last occurrance.

		Date holiday = null;

		for (int i = month.size() - 1; i > 20; i--) {
			int dow = month.get(i).getDow();
			if (Date.DAYOFWEEK[dow].equals(dayOfWeek)) {
				month.get(i).setHoliday();
				holiday = month.get(i);
				break;
			}
		}
		return holiday;
	}

	private void buildCalendar(int year) {
		Date jan1st = new Date(1, 1, year);
		jan1st.setDow(Date.calculateDowForJan1st(year));

		Date feb1st = new Date(2, 1, year, jan1st, 31);
		int febDays = Date.isLeapYear(year) ? 29 : 28; // deal with leap day
		Date mar1st = new Date(3, 1, year, feb1st, febDays);
		Date apr1st = new Date(4, 1, year, mar1st, 31);
		Date may1st = new Date(5, 1, year, apr1st, 30);
		Date jun1st = new Date(6, 1, year, may1st, 31);
		Date jul1st = new Date(7, 1, year, jun1st, 30);
		Date aug1st = new Date(8, 1, year, jul1st, 31);
		Date sep1st = new Date(9, 1, year, aug1st, 31);
		Date oct1st = new Date(10, 1, year, sep1st, 30);
		Date nov1st = new Date(11, 1, year, oct1st, 31);
		Date dec1st = new Date(12, 1, year, nov1st, 30);

		buildMonth(jan1st, 31, 1);
		buildMonth(feb1st, febDays, 2);
		buildMonth(mar1st, 31, 3);
		buildMonth(apr1st, 30, 4);
		buildMonth(may1st, 31, 5);
		buildMonth(jun1st, 30, 6);
		buildMonth(jul1st, 31, 7);
		buildMonth(aug1st, 31, 8);
		buildMonth(sep1st, 30, 9);
		buildMonth(oct1st, 31, 10);
		buildMonth(nov1st, 30, 11);
		buildMonth(dec1st, 31, 12);
	}

	private void buildCalendar(int month ,int year) {
		//Obtener el dia de la semana del primes dia de cada nes del año
		System.out.println(
				"Entrada a buildCalendar:  mes:" + month + ", año:" + year
		);
		Date jan1st = new Date(1, 1, year);
		jan1st.setDow(Date.calculateDowForJan1st(year));

		Date feb1st = new Date(2, 1, year, jan1st, 31);
		int febDays = Date.isLeapYear(year) ? 29 : 28; // deal with leap day
		Date mar1st = new Date(3, 1, year, feb1st, febDays);
		Date apr1st = new Date(4, 1, year, mar1st, 31);
		Date may1st = new Date(5, 1, year, apr1st, 30);
		Date jun1st = new Date(6, 1, year, may1st, 31);
		Date jul1st = new Date(7, 1, year, jun1st, 30);
		Date aug1st = new Date(8, 1, year, jul1st, 31);
		Date sep1st = new Date(9, 1, year, aug1st, 31);
		Date oct1st = new Date(10, 1, year, sep1st, 30);
		Date nov1st = new Date(11, 1, year, oct1st, 31);
		Date dec1st = new Date(12, 1, year, nov1st, 30);


		switch(month) {
			case 1:
				// code block
				//construimos los datos del mes
				buildMonth(jan1st, 31, 1);
				break;
			case 2:
				// code block
				buildMonth(feb1st, febDays, 2);
				break;
			case 3:
				// code block
				buildMonth(mar1st, 31, 3);
				break;
			case 4:
				// code block
				buildMonth(apr1st, 30, 4);
				break;
			case 5:
				// code block
				buildMonth(may1st, 31, 5);
				break;
			case 6:
				// code block
				buildMonth(jun1st, 30, 6);
				break;
			case 7:
				// code block
				buildMonth(jul1st, 31, 7);
				break;
			case 8:
				// code block
				buildMonth(aug1st, 31, 8);
				break;
			case 9:
				// code block
				buildMonth(sep1st, 30, 9);
				break;
			case 10:
				// code block
				buildMonth(oct1st, 31, 10);
				break;
			case 11:
				// code block
				buildMonth(nov1st, 30, 11);
				break;
			case 12:
				// code block
				buildMonth(dec1st, 31, 12);
				break;
			default:
				// code block
				buildMonth(jan1st, 31, 1);
		}
	}

	/**
	 * Builds array list of date objects from parameters and adds it to the hashmap
	 * by month name string.
	 *
	 * @param day1st    Date representing 1st day of month
	 * @param monthDays Total number of days in month
	 * @param monthNum  Month value (1, 2... 12)
	 */
	private void buildMonth(Date day1st, int monthDays, int monthNum) {
		ArrayList<Date> month = new ArrayList<>();
		month.add(day1st);

		// i represents day
		for (int i = 2; i <= monthDays; i++) {
			Date date = new Date(monthNum, i, day1st.getYear());
			int dow = (day1st.getDow() + (i - 1)) % 7; // dow = (1st day + elapsed days) % 7
			date.setDow(dow);
			month.add(date);
		}
		calendar.put(Date.MONTH[monthNum], month);
	}

	public void printArray(ArrayList<Date> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("array[" + i + "] : " + list.get(i));
		}
	}
}
