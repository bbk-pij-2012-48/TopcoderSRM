package SRM1;

public class Time {
	public static String whatTime(int seconds) {
		int h,m,s;
		s = seconds % 60;
		seconds -= s;
		m = (seconds % (60 * 60)) / 60;
		seconds = seconds - m;
		h = seconds / (60*60);
		
		String result = "";
		result += h + ":" + m + ":" + s;
		return result;
	}
}
