package TCO13_1C;

public class TheKnights {

	public static double find(int n, int a, int b) {
		
		int[][][] reachable = new int[n*n][5][2];
		for(int i=0 ; i < n*n ; i++) {
			for(int j=0 ; j < 5 ; j++) {
				reachable[i][j][0] = -1;
			}
		}
		int count = 0;
		int count2 = 0;
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				count = 0;
				reachable[count2][count][0] = i;
				reachable[count2][count][1] = j;
				count++;

				if(i+a >=0 && i+a<n) {
					if(j+b >=0 && j+b<n) {
						reachable[count2][count][0] = i+a;
						reachable[count2][count][1] = j+b;
						count++;
					}
					if(j-b >=0 && j-b<n) {
						reachable[count2][count][0] = i+a;
						reachable[count2][count][1] = j-b;
						count++;
					}
				}
				if(i-a >=0 && i-a<n) {
					if(j+b >=0 && j+b<n) {
						reachable[count2][count][0] = i-a;
						reachable[count2][count][1] = j+b;
						count++;
					}
					if(j-b >=0 && j-b<n) {
						reachable[count2][count][0] = i-a;
						reachable[count2][count][1] = j-b;
						count++;
					}
				}
				if(a!=b){
				if(i+b >=0 && i+b<n) {
					if(j+a >=0 && j+a<n) {
						reachable[count2][count][0] = i+b;
						reachable[count2][count][1] = j+a;
						count++;
					}
					if(j-a >=0 && j-a<n) {
						reachable[count2][count][0] = i+b;
						reachable[count2][count][1] = j-a;
						count++;
					}
				}
				if(i-b >=0 && i-b<n) {
					if(j+a >=0 && j+a<n) {
						reachable[count2][count][0] = i-b;
						reachable[count2][count][1] = j+a;
						count++;
					}
					if(j-a >=0 && j-a<n) {
						reachable[count2][count][0] = i-b;
						reachable[count2][count][1] = j-a;
						count++;
					}
				}
				}
				count2++;
			}
		}
		
		for(int i=0 ; i<reachable.length ; i++) {
			for(int j=0 ; j< reachable[i].length ; j++) {
				System.out.print(reachable[i][j][0] + "  " + reachable[i][j][1]);
				System.out.println();
			}
			System.out.println();
		}
		
		double output = 0;
		
		for(int i=0 ; i<reachable.length ; i++) {
			int iCounter = 5;
			for(int j=i+1 ; j<reachable.length ; j++) {
				int jCounter = 5 ;
				int doubles = 0;
				for(int k=0 ; k<reachable[i].length ; k++) {
					if(reachable[i][k][0] == -1){
						iCounter = k;
						break;
					}
					for(int l=0 ; l<reachable[j].length ; l++) {
						if(reachable[j][l][0] == -1) {
							jCounter = l;
							break;
						}
						if(reachable[i][k][0] == reachable[j][l][0] && reachable[i][k][1] == reachable[j][l][1]) {
							doubles++;
						}
					}
				}
				output += (double)(iCounter + jCounter - doubles) / ((double)(n*n*(n*n - 1))/(double)2);
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(find(10,1,6 ));
	}

}
