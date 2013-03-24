package SRM165;

public class ParallelSpeedup {

	public static int numProcessors(int k, int overhead) {
		long best = k;
		long tmp;

		for(int i=2 ; i<k+1 ; i++) {
			if(k%i==0) {
				tmp = overhead*communications(i) + (k/i);
			} else{
				tmp = overhead*communications(i) + (k/i) + 1;
			}
			System.out.println(i + "   " + tmp);
			if(tmp >= best) {
				return i-1;
			}
			best = tmp;
		}
		return k;

	}

	public static int communications(int num) {
		if(num == 1) {
			return 0;
		}
		return num-1 + communications(num-1);
	}
	
	public static void main(String[] args) {
		System.out.println(numProcessors(1000000,4));
	}

}
