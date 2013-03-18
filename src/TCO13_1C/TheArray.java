package TCO13_1C;

public class TheArray {

	public static int find(int n, int d, int first, int last) {
		int min = Math.min(first, last);
		int max = Math.max(first, last);
		int highest = min;
		int tmp = min;
		for (int i=1 ; i<n ; i++) {
			tmp += d;
			if(Math.abs(tmp - max) > Math.abs((n - 1 - i) * d)) {
				break;
			}
			highest = tmp;
		}
		
		int highest2 = max;
		int tmp2 = max;
		for (int i=1 ; i<n ; i++) {
			tmp2 += d;
			if(Math.abs(tmp2 - min) > Math.abs((n - 1 - i) * d)) {
				break;
			}
			highest2 = tmp2;
		}
		
		
		
		return Math.max(highest,highest2);
	}
	
	public static void main(String[] args) {
		System.out.println(find(99,3,-743,-619));
	}

}
