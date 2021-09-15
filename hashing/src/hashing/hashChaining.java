package hashing;

public class hashChaining {
	
	private class HashNode {
		String key;
		HashNode next;
	}
	HashNode [] table;
	int tableSize;
	int numberOfItems;
	
	public hashChaining(int n) {
		tableSize = n;
		numberOfItems = 0;
		table = new HashNode[tableSize];
	}
	
	public int hashInsert(String item) {
		int position = hashFunction(item);
		if (duplicated(position, item))
			return position;
		else {
			HashNode temp = table[position];
			table[position] = new HashNode();
			table[position].key = item;
			table[position].next = temp;
			numberOfItems++;
		}
		return position;
	}
	
	private boolean duplicated(int position, String item) {
		HashNode temp = table[position];
		while (temp!=null) {
			if (temp.key==item)
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	private int hashFunction(String item) {
		double d = 0;
		for (int i=0; i<item.length(); i++)
			d = d+item.charAt(i)*Math.pow(31, i);
		return (int)d%tableSize;
	}
	
	private int hashSearch(String item) {
		int position = hashFunction(item);
		HashNode temp = table[position];
		while (temp!=null) {
			if (temp.key==item)
				return position;
			else
			temp = temp.next;
		}
		return -1;
	}
	
	public boolean hashDelete(String item) {
		int position = hashSearch(item);
		if (position==-1)
			return false;
		else {
			HashNode temp1 = table[position];
			HashNode temp2 = null;
			while (temp1!=null) {
				if (temp1.key==item) {
					if (temp2==null) {
						table[position] = temp1.next;
						numberOfItems--;
					} else {
						temp2.next = temp1.next;
						numberOfItems--;
					}
					return true;
				} else {
					temp2 = temp1;
					temp1 = temp1.next;
				}
			}
			return false;
		}
	}
	
	public void showTable() {
		System.out.println("Current Hash Table: ");
		for (int i=0; i<tableSize; i++) {
			System.out.println("table slot " + i + " ");
			HashNode temp = table[i];
			while (temp!=null) {
				System.out.println("->" + table[i].key + " ");
				temp = temp.next;
			}
		}
	}
}
