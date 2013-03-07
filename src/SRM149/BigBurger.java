package SRM149;

public class BigBurger {
	
	public static int maxWait(int[] arrival, int[] service) {
		int[] serviceTime = new int[arrival.length];
		serviceTime[0] = arrival[0];
		for(int i=1 ; i<serviceTime.length ; i++) {
			if(serviceTime[i-1] + service[i-1] < arrival[i]) {
				serviceTime[i] = arrival[i];
			} else {
				serviceTime[i] = serviceTime[i-1] + service[i-1];
			}
		}
		
		int[] wait = new int[arrival.length];
		for(int i=0 ; i<wait.length ; i++) {
			wait[i] = serviceTime[i] - arrival[i];
		}
		
		int max = 0;
		for(int i=0 ; i<wait.length ; i++) {
			if(wait[i]>max) {
				max = wait[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arrival = {2,10,12};
		int[] service = {15,1,15};
		System.out.println(maxWait(arrival,service));
		
	}

}
