package 하노이타워;

public class Hanoi {
	private int x = 3; // fixed. A number of pillar.
	private int y = -1; // height
	private int[][] hanoiField;
	private int[] cntLine = new int[x];
	private int lastFoundLine = -1;
	private int lastMovedLine = 1; // choose the place to move. (1 or 2)
	private int moveCNT = -1; // moved times count

	public Hanoi(int num) {
		this.y = num;
		this.hanoiField = new int[num][x];
	}
	
	public void initHanoiTower() {
		 System.out.println("Start!");
		 System.out.println("==========" + "\n");
		
		 // make HanoiTower
		 for (int i = y; i > 0; i--) {
			 hanoiField[i - 1][0] = i;
		 }
	
		 moveTower(y);
		
		 System.out.println("==========");
		 System.out.println("Done!");
		 System.out.println("Total moved count : " + moveCNT);
	}
	
	public void showTower() {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				String s = String.valueOf(hanoiField[i][j]);
				if (s.length() == 1 || s.equals("0")) {
					System.out.print("| " + s.replace("0", " ")
					+ blank(s.length()));
				} else {
					System.out.print("| " + s + blank(s.length()));
				}
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("----------------" + "\n");
		moveCNT++;
	}
	
	public int countLine(int num) {
		for (int i = 0; i < x; i++) {
			int cnt = 0;
			for (int j = 0; j < y; j++) {
				if (hanoiField[j][i] != 0) {
					cnt = cnt + 1;
				}
			}
			cntLine[i] = cnt;
		}
		return cntLine[num];
	}
	
	public int[] findNumPlace(int num) {
		int[] coordinate = new int[2];
		coordinate[0] = -1;
		coordinate[1] = -1;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (hanoiField[i][j] == num) {
					lastFoundLine = j;
					coordinate[0] = j;
					coordinate[1] = i;
				}
			}
		}
		return coordinate;
	}
	
	public void moveTower(int num) {
		int to = -1;
		if (num <= 2) {
			showTower();
			 
			// move 1, 2
			for (int i = 1; i <= 2; i++) {
				hanoiField[findNumPlace(i)[1]][findNumPlace(i)[0]] = 0;
				to = x - (lastFoundLine + lastMovedLine);
				hanoiField[(y - 1) - countLine(to)][to] = i;
				lastMovedLine = to;
				showTower();
			}
	
			// move 1 again
			hanoiField[findNumPlace(1)[1]][findNumPlace(1)[0]] = 0;
			hanoiField[(y - 1) - countLine(to)][to] = 1;
			showTower();
	
		} else {
			// reflexive
			moveTower(num - 1);
	
			// move the tower's number bigger than 2
			hanoiField[findNumPlace(num)[1]][findNumPlace(num)[0]] = 0;
			to = x - (lastFoundLine + lastMovedLine);
			hanoiField[(y - 1) - countLine(to)][to] = num;
			lastMovedLine = to;
	
			// shift place when the tower's number is even.
			if (num % 2 == 0) {
				// System.out.println("!!!!!");
				lastMovedLine = lastFoundLine;
			}
	
			// move 1, 2 again
			moveTower(num - 1);
		 }
	 }
	
	 public String blank(int num) {
		 String s = String.valueOf(this.y);
		 int l = s.length();
		 String o = " ";
		 for (int i = l - num; i > 0; i--) {
			 o = o + " ";
		 }
		 return o;
	 }
}
