package SRM145;

public class ExerciseMachine {

	public static int getPercentages(String time) {
		int count = 0;
		int hours, minutes, seconds;
		long total;
		char tmp1, tmp2;
		tmp1 = time.charAt(0);
		tmp2 = time.charAt(1);
		hours = (int)(tmp2 - 48) + ((int)(tmp1 - 48))*10;
		System.out.println(hours);
		tmp1 = time.charAt(3);
		tmp2 = time.charAt(4);
		minutes = (int)(tmp2 - 48) + ((int)(tmp1 - 48))*10;
		System.out.println(minutes);
		tmp1 = time.charAt(6);
		tmp2 = time.charAt(7);
		seconds = (int)(tmp2 - 48) + ((int)(tmp1 - 48))*10;
		System.out.println(seconds);
		total = seconds + 60*minutes + 60*60*hours;
		System.out.println(total);

		
		for(int i=1 ; i<100 ; i++) {
			if(i*total % 100 == 0) {
				count++;
			}
		}

		return count;
	}
	
}
