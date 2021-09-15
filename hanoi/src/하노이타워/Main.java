package 하노이타워;

import java.util.Scanner;

public class Main {

	 public static void main(String[] args) {
		 // the start height of HanoiTower.
		 System.out.println("Input a number below and press 'Enter'");
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 
		 Hanoi h = new Hanoi(n);
		 h.initHanoiTower();
		 sc.close();
	 }
}
