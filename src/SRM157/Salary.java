package SRM157;

public class Salary {

	public static int howMuch(String[] arrival, String[] departure, int wage) {
		int[] arrivalS = new int[arrival.length];
		int[] departureS = new int[departure.length];
		double total = 0;
		for(int i=0 ; i<arrival.length ; i++) {
			arrivalS[i] += Integer.parseInt(arrival[i].substring(6,8)) + 
			60*Integer.parseInt(arrival[i].substring(3,5)) +
			60*60*Integer.parseInt(arrival[i].substring(0,2));

			departureS[i] += Integer.parseInt(departure[i].substring(6,8)) + 
			60*Integer.parseInt(departure[i].substring(3,5)) +
			60*60*Integer.parseInt(departure[i].substring(0,2));

			if(early(arrivalS[i])){
				if(early(departureS[i])){
					//both early
					total+= 1.5 * (departureS[i] - arrivalS[i]);
				} else if (late(departureS[i])){
					//big overlap
					total += 1.5 * (60*60*6 - arrivalS[i]) + 60*60*18 - 1 - 60*60*6 + 1.5 * (departureS[i] - 60*60*18);
				} else {
					// early/mid overlap
					total += 1.5 * (60*60*6 - arrivalS[i]) + departureS[i] - 60*60*6;
				}
			} else if(late(arrivalS[i])) {
				// both late
				total+= 1.5 * (departureS[i] - arrivalS[i]);
			} else {
				if(late(departureS[i])){
					// evening overlap
					total += 60*60*18 - 1 - arrivalS[i] + 1.5 * (departureS[i] - 60*60*18);
				} else {
					// both normal
					total+= (departureS[i] - arrivalS[i]);
				}
			}
		}
		return (int) ((total / (60*60)) * wage);
	}


	private static boolean early(int a) {
		if(a<60*60*6){
			return true;
		}
		return false;
	}

	private static boolean late(int a) {
		if(a>=60*60*18) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(howMuch(new String[] {"08:00:00","13:00:00","19:27:32"}, new String[] {"12:00:00","17:00:00","20:48:10"}, 1000));
		System.out.println(howMuch(new String[] {"01:05:47","16:48:12"}, new String[] {"09:27:30","21:17:59"}, 2000));
		System.out.println(howMuch(new String[] {"00:00:00"}, new String[] {"23:59:59"}, 10000));
		System.out.println(howMuch(new String[] {"10:00:00"}, new String[] {"18:00:00"}, 10000));
		System.out.println(howMuch(new String[] {"08:00:00","13:00:00","19:27:32"}, new String[] {"12:00:00","17:00:00","20:48:10"}, 1000));

	}
	

}
