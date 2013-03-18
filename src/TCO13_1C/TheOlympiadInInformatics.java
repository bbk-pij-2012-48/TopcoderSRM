package TCO13_1C;

public class TheOlympiadInInformatics {

	public static int find(int[] sums, int k) {
		int max = -1;
		for(int i=0 ; i<sums.length ; i++) {
			max = Math.max(max, sums[i]);
		}
		
		for(int i=max ; i>0 ; i--) {
			int total = 0;
			for(int j=0 ; j<sums.length ; j++) {
				total += sums[j] / i;
			}
			if(total>k) {
				return i;
			} 
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(find(new int[] {95, 23, 87, 23, 82, 78, 59, 44, 12}, 70 ));
	}

}
