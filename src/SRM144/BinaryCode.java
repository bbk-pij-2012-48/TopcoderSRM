package SRM144;

public class BinaryCode {
	
	public static String[] decode(String message){
		
		String[] resultArray = new String[2];
		int length = message.length();
		int[] P = new int[length];
		int[] Q = new int[length];
		
		for(int i=0 ; i<length ; i++) {
			Q[i] = (int)message.charAt(i) - 48;
		}
		
		P[0] = 0;
		
		if(length == 1) {
			if(message.charAt(0) == '0') {
				resultArray[0] = "0";
			} else {
				resultArray[0] = "NONE";
			}
		} else {
				P[1] = Q[0] - P[0];
				System.out.println(P[1]);
				if(length == 2) {
					if(invalid(P)){
						System.out.print("Invalid");
						resultArray[0] = "NONE";
					} else if (checkEndCorrect(P,Q)){
						resultArray[0] = toString(P);
					} else {
						System.out.print("End incorrect");

						resultArray[0] = "NONE";
					}
				}
				for (int i=2 ; i<length ; i++) {
					P[i] = Q[i-1] - P[i-1] - P[i-2];
				}
				
				for(int i=0 ; i<length ; i++) {
					System.out.print(P[i]);
				}
				
				if(invalid(P)){
					System.out.print("Invalid1");

					resultArray[0] = "NONE";
				} else if (checkEndCorrect(P,Q)){
					resultArray[0] = toString(P);
				} else {
					System.out.print("End incorrect");

					resultArray[0] = "NONE";
				}
		}
		
		P = new int[length];
		
		P[0] = 1;
		
		if(length == 1) {
			if(message.charAt(0) == '1') {
				resultArray[1] = "1";
			} else {
				resultArray[1] = "NONE";
			}
		} else {
				P[1] = Q[0] - P[0];
				if(length == 2) {
					if(invalid(P)){
						resultArray[1] = "NONE";
					} else if (checkEndCorrect(P,Q)){
						resultArray[1] = toString(P);
					} else {
						resultArray[1] = "NONE";
					}
				}
				for (int i=2 ; i<length ; i++) {
					P[i] = Q[i-1] - P[i-1] - P[i-2];
				}
				if(invalid(P)){
					resultArray[1] = "NONE";
				} else if (checkEndCorrect(P,Q)){
					resultArray[1] = toString(P);
				} else {
					resultArray[1] = "NONE";
				}
		}
		return resultArray;
	}
	
	private static boolean invalid(int[] src) {
		for(int i=0 ; i<src.length ; i++) {
			if(src[i]!=0 && src[i]!=1) {
				return true;
			}
		}
		return false;
	}
	
	private static Boolean checkEndCorrect(int[] P, int[] Q) {
		if(Q[Q.length -1] == (P[P.length - 1] + P[P.length - 2])) {
			return true;
		}
		return false;
	}
	
	private static String toString(int[] P) {
		char[] tmp = new char[P.length];
		for (int i=0 ; i<P.length ; i++) {
			tmp[i] = (char)(P[i]+48);
		}
		return new String(tmp);
	}
	
	public static void main(String[] args) {
		String[] tmp = decode("0");
		System.out.println(tmp[0]);
		System.out.println(tmp[1]);

	}
}
