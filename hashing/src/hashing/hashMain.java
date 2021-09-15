package hashing;

public class hashMain {

	public static void main(String[] args) {
		int n = 7;
		hashOpenAddrLinear h = new hashOpenAddrLinear(n);
//		hashChaining h = new hashChaining(n);
		
		System.out.println(h.hashInsert("AA"));
		System.out.println(h.hashInsert("AB"));
		System.out.println(h.hashInsert("ZX"));
		System.out.println(h.hashInsert("RRR"));
		System.out.println(h.hashInsert("A1"));
		System.out.println(h.hashInsert("A2"));
		System.out.println(h.hashInsert("A3"));
		h.showTable();

		System.out.println(h.hashInsert("A4"));
		System.out.println(h.hashInsert("A5"));

		System.out.println(h.hashInsert("A6"));
		h.showTable();

		System.out.println(h.hashInsert("A7"));
		h.showTable();

		System.out.println("Deleting test");
		h.hashDelete("A3");
		h.showTable();
		h.hashDelete("A4");
		h.showTable();
		h.hashDelete("A5");
		h.showTable();
		h.hashDelete("AA");
		h.showTable();
	}
}
