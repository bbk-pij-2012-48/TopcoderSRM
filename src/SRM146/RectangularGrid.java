package SRM146;

public class RectangularGrid {

	public static long countRectangles(int width, int height) {
		
		long count = 0;
		
		//width
		for(int i=0 ; i<width ; i++) {
			//height
			for(int j=0 ; j<height ; j++) {
				if(i!=j) {
					count += (height - j) * (width - i);
				}
			}
		}
		return count;		
	}

	public static void main(String[] args) {
		System.out.println(countRectangles(3,3)); 
		System.out.println(countRectangles(5,2)); 
		System.out.println(countRectangles(10,10)); 
		System.out.println(countRectangles(592,964)); 

	}

}
