package SRM168;

public class StairClimb {
	
	public static int stridesTaken(int[] flights, int stairsPerStride) {
		int total = 0;
		total += (flights.length - 1) * 2;
		for(int n : flights) {
			total += Math.ceil((double)n/stairsPerStride);
		}
		return total;
	}
}
