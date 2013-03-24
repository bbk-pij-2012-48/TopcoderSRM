package SRM166;

public class BinaryCardinality {

	public static int[] arrange(int[] numbers) {
		int[][] output = new int[numbers.length][2];
		for(int i=0 ; i<numbers.length ; i++) {
			output[i][0] = numbers[i];
			output[i][1] = cardinality(numbers[i]);
		}
		for(int i=0 ; i<numbers.length-1 ; i++) {
			for(int j=0 ; j<numbers.length-1-i ; j++) {
				if(output[j][1]>output[j+1][1]) {
					int[] tmp = new int[2];
					tmp[0] = output[j][0];
					tmp[1] = output[j][1];
					output[j][0] = output[j+1][0];
					output[j][1] = output[j+1][1];
					output[j+1][0] = tmp[0];
					output[j+1][1] = tmp[1];
				} else if(output[j][1]==output[j+1][1] && output[j][0]>output[j+1][0]) {
					int[] tmp = new int[2];
					tmp[0] = output[j][0];
					output[j][0] = output[j+1][0];
					output[j+1][0] = tmp[0];
				}
			}
		}
		int[] finalOut = new int[numbers.length];
		for(int i=0 ; i<numbers.length ; i++) {
			finalOut[i] = output[i][0];
		}
		return finalOut;
	}

	private static int cardinality(int number) {
		String tmp = Integer.toBinaryString(number);
		int count = 0;
		for(int i=0 ; i<tmp.length() ; i++) {
			if(tmp.charAt(i)=='1') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] tmp = arrange(new int[] {811385,340578,980086,545001,774872,855585,13848,863414,419523,190151,784903,127461});
		for(int number : tmp) {
			System.out.println(number);
		}
	}

}
