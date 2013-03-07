package SRM151;

import java.util.ArrayList;
import java.util.List;

public class Birthday {

	public static String getNext(String date, String[] birthdays) {
		// check for same month
		List<String> tmp = new ArrayList<String>();
		for(int i=0 ; i<birthdays.length ; i++) {
			if(month(birthdays[i])==month(date) && day(birthdays[i])>=day(date)) {
				tmp.add(birthdays[i]);
			}
		}
		if(!tmp.isEmpty()){
			int best = 0;
			for(int i=1 ; i<tmp.size() ; i++) {
				if(day(tmp.get(i))<day(tmp.get(best))) {
					best = i;
				}
			}
			return tmp.get(best).substring(0,5);
		}

		// check for later month same year
		for(int i=0 ; i<birthdays.length ; i++) {
			if(month(birthdays[i])>month(date)) {
				tmp.add(birthdays[i]);
			}
		}
		if(!tmp.isEmpty()){
			int best = 0;
			for(int i=1 ; i<tmp.size() ; i++) {
				if(month(tmp.get(i))<month(tmp.get(best))) {
					best = i;
				} else if (month(tmp.get(i))==month(tmp.get(best)) && day(tmp.get(i))<day(tmp.get(best))) {
					best = i;
				}
			}
			return tmp.get(best).substring(0,5);
		}

		// pick smallest date
		int best = 0;
		for(int i=1 ; i<tmp.size() ; i++) {
			if(month(tmp.get(i))<month(tmp.get(best))) {
				best = i;
			} else if (month(tmp.get(i))==month(tmp.get(best)) && day(tmp.get(i))<day(tmp.get(best))) {
				best = i;
			}
		}
		return tmp.get(best).substring(0,5);
	}

	private static int month(String date) {
		char a = date.charAt(0);
		char b = date.charAt(1);
		int c = a - 48;
		int d = b - 48;
		return 10*c + d;
	}

	private static int day(String date) {
		char a = date.charAt(3);
		char b = date.charAt(4);
		int c = a - 48;
		int d = b - 48;
		return 10*c + d;
	}

	public static void main(String[] args) {
		System.out.println(getNext("01/02", new String[]{"02/17 Wernie",
				 "10/12 Stefan",
				 "02/17 MichaelJordan",
				 "10/12 LucianoPavarotti",
				 "05/18 WilhelmSteinitz"}));

	}

}
