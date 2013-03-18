package SRM158;

public class Gems {
	public static int numMoves(String[] board) {
		int count = 0;
		for(int i=0 ; i<board[0].length() ; i++) {
			for(int j=0 ; j<board.length; j++) {
				if(right(i,j,board)) {
					count++;
				}
				if(down(i,j,board)) {
					count++;
				}
			}
		}
		return count;
	}
	
	private static boolean right(int i, int j, String[] board) {
		if(i>=board[0].length()-1){
			return false;
		}
		//horizontal
		if(get(i+2,j,board) == get(i,j,board) 
				&& get(i+3,j,board) == get(i,j,board)) {
			return true;
		}
		if(get(i-1,j,board) == get(i+1,j,board)
				&& get(i-2,j,board) == get(i+1,j,board)) {
			return true;
		}
		//vertical
		if(get(i,j,board) == get(i+1,j-1,board) && get(i,j,board) == get(i+1,j-2,board) ||
				get(i,j,board) == get(i+1,j+1,board) && get(i,j,board) == get(i+1,j+2,board) ||
					get(i,j,board) == get(i+1,j-1,board) && get(i,j,board) == get(i+1,j+1,board)){
			return true;
		}
		if(get(i+1,j,board) == get(i,j-1,board) && get(i+1,j,board) == get(i,j-2,board) ||
				get(i+1,j,board) == get(i,j+1,board) && get(i+1,j,board) == get(i,j+2,board) ||
					get(i+1,j,board) == get(i,j-1,board) && get(i+1,j,board) == get(i,j+1,board)){
			return true;
		}
		return false;
	}
	
	private static boolean down(int i, int j, String[] board) {
		if(j>=board.length-1) {
			return false;
		}
		//vertical
		if(get(i,j,board) == get(i,j+2,board) && get(i,j,board) == get(i,j+3,board)) {
			return true;
		}
		if(get(i,j+1,board) == get(i,j-1,board) && get(i,j+1,board) == get(i,j-2,board)) {
			return true;
		}
		//horizontal
		if(get(i,j,board) == get(i-1,j+1,board) && get(i,j,board) == get(i-2,j+1,board) ||
				get(i,j,board) == get(i+1,j+1,board) && get(i,j,board) == get(i+2,j+1,board) ||
					get(i,j,board) == get(i-1,j+1,board) && get(i,j,board) == get(i+1,j+1,board)) {
			return true;
		}
		if(get(i,j+1,board) == get(i-1,j,board) && get(i,j+1,board) == get(i-2,j,board) ||
				get(i,j+1,board) == get(i+1,j,board) && get(i,j+1,board) == get(i+2,j,board) ||
					get(i,j+1,board) == get(i-1,j,board) && get(i,j+1,board) == get(i+1,j,board)) {
			return true;
		}
		return false;
	}
	
	private static char get(int i, int j, String[] board) {
		if(i>board[0].length()-1 || j>board.length-1
				|| i<0 || j<0) {
			return '!';
		}
		return board[j].charAt(i);
	}
}
