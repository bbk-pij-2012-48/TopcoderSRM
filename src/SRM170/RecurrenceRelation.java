package SRM170;

public class RecurrenceRelation {
	
	public static int moduloTen(int[] coefficients, int[] initial, int N) {
		int k=initial.length-1;
		if(N<=k)
			return mod(initial[N]);
		for(int i=0 ; i<N-k ; i++) {
			int tmp = 0;
			for(int j=0 ; j<initial.length ; j++) {
				tmp += coefficients[j]*initial[j];
			}
			initial = next(initial,mod(tmp));
		}
		return initial[initial.length-1];
		
	}
	
	private static int mod(int n) {
		int out = n%10;
		if(out>=0) {
			return out;
		}
		return out+10;
	}
	
	private static int[] next(int[] current, int n) {
		for(int i=0 ; i<current.length-1 ; i++) {
			current[i] = current[i+1];
		}
		current[current.length-1] = n;
		return current;
	}
	
	public static void main(String[] args) {
		System.out.println(mod(-39));
	}

}
