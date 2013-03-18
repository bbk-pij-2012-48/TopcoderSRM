package SRM155;

public class BenfordsLaw {

	public static int questionableDigit(int[] transactions, int threshold) {
		double[] expected = new double[9];
		for(int i=0 ; i<9 ; i++) {
			expected[i] = transactions.length*Math.log10(1 + 1.0/(i + 1));
		}
		
		int[] frequency = new int[9];
		for(int i=0 ; i<transactions.length ; i++) {
			String tmp = Integer.toString(transactions[i]);
			int tmp2 = Integer.parseInt(tmp.substring(0,1));
			frequency[tmp2-1]++;
		}
		
		for(int i=0 ; i<9 ; i++) {
			if(frequency[i]>threshold*expected[i]) {
				return i+1;
			} else if (frequency[i]<(1.0/threshold)*expected[i]) {
				return i+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(questionableDigit(new int[] { 5236,7290,200,1907,3336,9182,17,4209,8746,7932,
				  6375,909,2189,3977,2389,2500,1239,3448,6380,4812 } , 2));
	}
}
