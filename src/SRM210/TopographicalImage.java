package SRM210;

import java.util.ArrayList;
import java.util.List;

public class TopographicalImage {
	
	public static int[] calcPeakAreas(String[] topoData) {
		Landscape tmp = new TopographicalImage().new Landscape(topoData);
		int[] out = new int[tmp.peaks.size()];
		for(int i=0 ; i<tmp.peaks.size(); i++) {
			out[i] = tmp.peaks.get(i);
		}
		return out;
	}

	public class Landscape {
		public boolean[][] used;
		public List<Integer> peaks;
		public String[] topoData;
		public int counter=0;
		public int xSize, ySize;
		
		public Landscape(String[] topoData) {
			xSize = topoData[0].length();
			ySize = topoData.length;
			this.topoData = topoData;
			used = new boolean[topoData[0].length()][topoData.length];
			peaks = new ArrayList<Integer>();
			populatePeaks();
		}
		
		private void populatePeaks() {
			while(!finished()) {
				counter = 0;
				int[] peak = nextHighest();
				populate(peak[0],peak[1]);
				peaks.add(counter);
			}
		}
		
		private void populate(int x, int y) {
			if(used[x][y]) {
				return;
			}
			used[x][y] = true;
			counter++;
			if(inRange(x-1,y-1) && topoData[y].charAt(x)>=topoData[y-1].charAt(x-1))
				populate(x-1,y-1);
			if(inRange(x-1,y) && topoData[y].charAt(x)>=topoData[y].charAt(x-1))
				populate(x-1,y);
			if(inRange(x-1,y+1) && topoData[y].charAt(x)>=topoData[y+1].charAt(x-1))
				populate(x-1,y+1);
			if(inRange(x,y-1) && topoData[y].charAt(x)>=topoData[y-1].charAt(x))
				populate(x,y-1);
			if(inRange(x,y+1) && topoData[y].charAt(x)>=topoData[y+1].charAt(x))
				populate(x,y+1);
			if(inRange(x+1,y-1) && topoData[y].charAt(x)>=topoData[y-1].charAt(x+1))
				populate(x+1,y-1);
			if(inRange(x+1,y) && topoData[y].charAt(x)>=topoData[y].charAt(x+1))
				populate(x+1,y);
			if(inRange(x+1,y+1) && topoData[y].charAt(x)>=topoData[y+1].charAt(x+1))
				populate(x+1,y+ 1);
		}
		
		private boolean inRange(int x, int y) {
			if(x<0 || x>=xSize || y<0 || y>=ySize) {
				return false;
			}
			return true;
		}
		
		private int[] nextHighest() {
			int best = 0;
			int[] out = new int[2];
			for(int j=0 ; j<used[0].length ; j++) {
				for(int i=0 ; i<used.length ; i++) {
					if(used[i][j]==false && topoData[j].charAt(i)>best) {
						out[0] = i;
						out[1] = j;
						best = topoData[j].charAt(i);
					}
				}
			}
			return out;
		}
		
		private boolean finished() {
			for(int j=0 ; j<used[0].length ; j++) {
				for(int i=0 ; i<used.length ; i++) {
					if(used[i][j]==false) {
						return false;
					}
				}
			}
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		int[] tmp = calcPeakAreas(new String[] {

				"AAAAAAABBBBCCCDEFGHHIIJIIHGFEDDCCCBBBBBBBBBBAAAAAA",
				"AAAAABBBBBCCDDEEFGHIJJJJIIHGFEDDCCCCCCCCCBBBBBAAAA",
				"AAAABBBBCCCDDEEFGHIIJJJJJIHGFEDDDDDDDDDCCCCBBBBAAA",
				"AAABBBBCCDDEEFFGHHIJJJJJJIHGFEEDDDDDEEDDDDCCBBBBAA",
				"AABBBCCDDEEFFGGHHIIJJJJJIHHGFEEEEEEEFFFEEDDCCBBBAA",
				"BBBBCCDDEFFGHHHIIIIJJJIIIHGFFEEEEFFGGGGGFEEDCCBBBA",
				"BBBCCDEEFGHIIIJJJJIIIIIHHGGFFEEFFGGHHHHHGGFEDCCBBB",
				"BBCCDEEGHIJJKKKKJJJIIHHGGFFEEEEFGGHIIJJIIHGFEDCCBB",
				"CCCDEEFHIJKLMMMLKKJIHHGGFFEEEEFFGHIJJKKJJIHGFEDCBB",
				"CDDEEFHIJLMNNNNMLKJIHGFFEEEDEEFFGIJKKLLLKJIHFEDCCB",
				"DDEFFGIJLMNOPPONMLJIHGFEEDDDDEFGHIJKLMMMLKJIGFEDCB",
				"EEFFGHIKMNOQQQPONLKIHFEEDDDDDEFGHIKLMMNMMLKIHGEDCC",
				"FFGGHIJLMOPQRRQPNMKIGFEDDCCDDEFGHIKLMNNNNMLJIGFEDC",
				"GHHHIJKLNOQRRRQPOMKIGFEDDCCDDEFGHIKLMNNNNMLKIHFEDC",
				"HIIIJJKLNOPQRRQPNLKIGFEDDCCDDEFGHJKLMNOONNMKJHGFDC",
				"IJJJJJKLMOPQQQPONLJHGFEDDDDDEEFGIJKLMNOONNMLJIGFED",
				"JJJJJKKLMNOOPPONMKJHGFEDDDDEEFGHIJKLMNNONNMLJIGFED",
				"JKKJJJKKLMMNNNNMLJIHFFEEEEEFGGHIJKLMMNNNNMMKJIGFED",
				"KKKJJJJJKKLLMLLKJIHGFFEEEFFGHIJKKLMMNNNNNMLKJHGFED",
				"JJJJIIIIIJJJKKJJIIHGFFFFFGHIJKLMMNNNNNNMMLKJIHGEDC",
				"JJJIIHHHHHHIIIIIHHGGGGGGHIJKLMNOOOOONNMMLKJIHGFEDC",
				"IIIHHGGGGGGGGHHHGGGGGGHIIJLMNOPQQQQPONMLKJIHGFEDDC",
				"HHHGGFFFFFFFFFGGGGGGHHIJKMNOQRSSSSRQPNMLKIHGFFEDCC",
				"GGGFFEEEEEEEEFFFGGGHIJKLMOPRSTUUUTSRPNMKJHGFFEDCCB",
				"FFFEEEEDDDDEEEEFGGHIJKLNOQRTUVWWWVTRPNLJIHFEEDCCBB",
				"EEEEDDDDDDDDEEEFGHIJKLNOQRTVWXYYXWUSPNLJHGFEDCCBBB",
				"DDDDDDDDDDDEEEFFGHIKLNOQRTVWXYZYYWURPMKIGFEDCCBBBB",
				"CDDDDDDEEEEEEFFGHIJKMOPRSUWXYZZZXWTROMJHGEDCCBBBBA",
				"CCDDDEEEFFFFFGGHHJKLNOQRTVWXYZZYXVTQNLIGFEDCBBBAAA",
				"CCDDEFFGGGGHHHHIIJKMNPQSTVWXYYYXVURPMKIGEDCBBBAAAA",
				"CDDEFGGHIIIIIIIJJKLMOPQSTUVWWXWVUSQNLJHFECCBBBAAAA",
				"CDEFGHIJKKKKKKKKKLMNOPQRSTUVVVUTSQOMJHGEDCBBBAAAAA",
				"CDEGHIKLMMMMMMLLLMMNOPQRSSTTTTSRQOMKIGFDCCBBAAAAAA",
				"DEFGIKLMNOOOONNMMMNNOPQQRRRRRRQPNMKIHFEDCBBBAAAAAA",
				"DEGHJLMOPQQQPPOONNNOOPPPQQQPPONMLKIHFEDCBBBAAAAAAA",
				"DEGIKMNPQRRRRQPOOOOOOOPPPOOONMLKJIHFEDCCBBAAAAAAAA",
				"DFGIKMOQRSSSRRQPOOOOOOOOONMMLKJIHGFEDCCBBBAAAAAAAA",
				"DFGIKMOQRSSSRRQPOOOOONNNMMLKJIIHGFEDCCBBBAAAAAAAAA",
				"DEGIJLNPQRRRRQPOONNNNNMMLLKJIHGFEEDCCBBBAAAAAAAAAA",
				"DEFHJKMOPQQQQPOONNMMMMLLKJIHGGFEDDCCBBBAAAAAAAAAAA",
				"CDFGIJLMNOOOONNMMLLLLLKKJIHGFEEDCCCBBBAAAAAAAAAAAA",
				"CDEFGIJKLMMMMMLLKKKKKJJIIHGFEDDCCBBBBAAAAAAAAAAAAA",
				"CCDEFGHIJKKKKKJJJIIIIIHHGGFEDDCCBBBBAAAAAAAAAAAAAA",
				"BCCDEFGHHIIIIIHHHHHHHGGGFFEDDCCBBBAAAAAAAAAAAAAAAA",
				"BBCCDEEFFGGGGGGFFFFFFFFEEDDCCCBBBAAAAAAAAAAAAAAAAA",
				"BBBCCDDEEEEEEEEEEEEEEEEDDDCCBBBBAAAAAAAAAAAAAAAAAA",
				"ABBBCCCCDDDDDDDDDDDDDDDCCCCBBBBAAAAAAAAAAAAAAAAAAA",
				"AABBBBBCCCCCCCCCCCCCCCCCCBBBBBAAAAAAAAAAAAAAAAAAAA",
				"AAABBBBBBBBBBBBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAA",
				"AAAAAABBBBBBBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAAAA"
				
				});
		for(int i : tmp) {
			System.out.println(i);
		}
	}
}
