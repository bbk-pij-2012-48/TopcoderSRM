package SRM163;

public class CalendarRecycle {

	public static int useAgain(int year) {
		if(leap(year)) {
			return year + 28;
		}
		int track = 0;
		for(int i=0 ; i>=0 ; i++) {
			year++;
			if(leap(year)) {
				track += 2;
			} else {
				track++;
			}
			if(track % 7 == 0) {
				if(!leap(year)) {
					return year;
				}
			}
		}
		return 0;	
	}

	private static boolean leap(int year) {
		if((year-2000) % 4 == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(useAgain(2013));
		System.out.println(useAgain(2008));
		System.out.println(useAgain(9999));
		System.out.println(useAgain(2525));

	}

}
