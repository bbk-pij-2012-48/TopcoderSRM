package SRM574;

public class PolygonTraversal2 {

	public static int count(int N, int[] points) {
		int[] points2 = new int[N+1];
		for(int i=0 ; i<points.length ; i++) {
			points2[i] = points[i];
		}
		points2[points2.length-1] = points[0];
		int[] left = new int[N-points.length];
		int count =0;
		for(int i=1 ; i<=N ; i++) {
			boolean found = false;
			for(int j=0 ; j<points.length ; j++) {
				if(points[j]==i){
					found = true;
					break;
				}
			}
			if(!found){
				left[count]=i;
				count++;
			}
		}
		
		return check(points2,points.length,left);


	}

	private static boolean intersect(int[] points2, int num, int next) {
		int current = Math.min(points2[num-1],next);
		next = Math.max(points2[num-1],next);

		for(int i=0 ; i<points2[num-2] ; i++) {
			if(points2[i]<next && points2[i]>current) {
				if(!(points2[i+1]<=next && points2[i+1]>=current)) {
					return true;
				}
			}
			if(points2[i+1]<next && points2[i+1]>current) {
				if(!(points2[i]<=next && points2[i]>=current)) {
					return true;
				}
			}
		}
		return false;
	}

	private static int check(int[] points2, int num, int[] left) {
		int count = 0;
		if(num==points2.length-1){
			int a = points2[points2.length-1];
			int b = points2[points2.length-2];
			if(Math.abs((a-b)%points2.length-1)!=1 && Math.abs((a-b)%points2.length-1)!= points2.length-2) {
				return 1;
			} else {
				return 0;
			}
		}
		for(int i=0 ; i<left.length ; i++) {
			if(intersect(points2, num, left[i])){
				int[] tmp = new int[points2.length];
				for(int k=0 ; k<tmp.length ; k++) {
					tmp[k] = points2[k];
				}
				tmp[num] = left[i];
				int[] tmp2 = new int[left.length-1];
				for(int k=0 ; k<tmp2.length ; k++) {
					if(k<i) {
						tmp2[k]=left[k];
					}else if(k>i) {
						tmp2[k-1] = left[k];
					}
				}
				int amount = check(tmp,num+1,tmp2);
				count+=amount;
			}
		}
		return count;
	}
}
