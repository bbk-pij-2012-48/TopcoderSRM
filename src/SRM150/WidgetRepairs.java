package SRM150;

public class WidgetRepairs {

	public static int days(int[] arrivals, int numPerDay) {
		int dayCount = 0;
		int remainder = 0;
		for(int i=0 ; i<arrivals.length ; i++) {
			if(arrivals[i] == 0 && remainder == 0) {
				// no work to do
			}else {
				if(arrivals[i] + remainder <= numPerDay) {
					remainder = 0;
					dayCount++;
				} else {
					remainder = arrivals[i] + remainder - numPerDay;
					dayCount++;
				}
			}
		}

		while(remainder>0) {
			remainder -= numPerDay;
			dayCount++;
		}

		return dayCount;
	}

	public static void main(String[] args) {
		System.out.println(days(new int[] {6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6}, 3));

	}

}
