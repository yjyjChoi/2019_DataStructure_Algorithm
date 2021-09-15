package hashing;

public class hashOpenAddrLinear {
	String [] table;
	int tableSize;
	
	public hashOpenAddrLinear(int n) {
		tableSize = n;
		table = new String[tableSize];
	}
	
	public int hashInsert(String item) {
		int position = hashFunction(item);
		
		if (table[position]==null) {
			table[position]=item;
			return position;
		} else {
			while (avoidCollision(item)==-1) { // buffer full -> expand buffer
				String [] tempTable = new String [tableSize];
				for (int i=0; i<tableSize; i++)  // table copy
					tempTable[i] = table[i];
	
				int oldSize = tableSize;
				tableSize = 2*tableSize; // table size ´Ã¸²
				table = new String[tableSize]; // new table
				for (int i=0; i<oldSize; i++)
					hashInsert(tempTable[i]);
			}
			position = avoidCollision(item);
			table[position] = item;
			return position;
		}
	}
	
	private int avoidCollision(String item) {
		int position = hashFunction(item);
		int tempPosition = position;
		
		while (table[tempPosition]!=null) {
			if ((position!=0) && tempPosition==(position-1)%tableSize || 
					(position==0) && tempPosition==tableSize-1)
				return -1;
			else {
				tempPosition = (tempPosition+1)%tableSize; // linear
			}
		}
		return tempPosition;
	}
	
	private int hashFunction(String item) {
		double d = 0;
		for (int i=0; i<item.length(); i++) {
			d = d+item.charAt(i)*Math.pow(31, i);
		}
		return (int)d%tableSize;
	}
	
	public int hashSearch(String item) {
		int position = hashFunction(item);
		while (table[position]!=null) {
			if (table[position]==item)
				return position;
			else
				position = (position+1)%tableSize;
		}
		return -1;
	}
	
	public boolean hashDelete(String item) {
		int position = hashSearch(item);
		if (position==-1)
			return false;
		else {
			table[position] = null;
			reHashing(position);
			return true;
		}
	}
	
	private void reHashing(int position) {
		int pos = (position+1)%tableSize;
		for (int i=0; i<tableSize; i++) {
			if (table[pos]!=null) {
				String temp = table[pos];
				table[pos] = null;
				hashInsert(temp);
				pos = (pos+1)%tableSize;
			}
		}
	}
	
	public void showTable() {
		System.out.println("Current Hash Table: ");
		for (int i=0; i<tableSize; i++)
			System.out.print(table[i]+" ");
		System.out.println();
	}
}
