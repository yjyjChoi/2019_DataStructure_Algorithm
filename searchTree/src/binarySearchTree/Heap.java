package binarySearchTree;

import java.util.ArrayList;

public class Heap { // Max Heap
	
	private ArrayList<Character> heap = new ArrayList<Character>();
	
	public Heap() {
		heap.add(null);
	}
	
	public boolean isEmpty() {
		if (heap.size()==1)
			return true;
		else
			return false;
	}
	
	public int sizeOf() {
		return heap.size()-1;
	}
	
	
	public ArrayList<Character> insertHeap(char x) {
		int k = heap.size();
		heap.add(k, x);
		int parentIndex = (int)k/2;
		while (parentIndex > 0) {
			if (x<heap.get(parentIndex))
				return heap;
			else {
				heap.set(k, heap.get(parentIndex));
				heap.set(parentIndex, x);
				k = parentIndex;
				parentIndex = (int)k/2;
			}
		}
		return heap;
	}
	
	public Character deleteHeap() { 
		if (heap.size()==1)
			return null;
		char returnVal = heap.get(1);
		if (heap.size()==2)
			heap.remove(1);
		else {
			heap.set(1, heap.remove(heap.size()-1));
			makeHeap(1); // from the root
		}
		return returnVal;
	}
	
	private void makeHeap(int index) {
		if (2*index>=heap.size() || (2*index+1)>=heap.size())
			return;
		int k = 2*index;
		if (k+1<heap.size() && heap.get(k+1)>heap.get(k))
			k++;
		if (heap.get(k)>heap.get(index)) {
			char temp = heap.get(k);
			heap.set(k, heap.get(index));
			heap.set(index, temp);
			makeHeap(k);
		}
		else
			return;
	}

	public static void main(String[] args) {
		Heap myHeap = new Heap();
		
		myHeap.insertHeap('V');
		myHeap.insertHeap('D');
		myHeap.insertHeap('F');
		myHeap.insertHeap('G');
		myHeap.insertHeap('A');
		myHeap.insertHeap('J');
		myHeap.insertHeap('K');
		myHeap.insertHeap('E');
		myHeap.insertHeap('A');
		
		// heap은 deleteHeap에서 프린트하기 때문에 toString이 필요 없다.
		while (myHeap.isEmpty()==false) {
			System.out.print(myHeap.deleteHeap()+" ");
		}
	}
}
