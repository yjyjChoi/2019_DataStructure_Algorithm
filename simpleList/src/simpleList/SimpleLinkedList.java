package simpleList;

public class SimpleLinkedList {
	private Node head;
	private int size;
	
	public SimpleLinkedList() {
		head = new Node(null);
		size = 0;
	}
	
	String get(int index) {
		Node temp = head;
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	private Node getNode(int index){	   
        if(index < 0 || index >= size){
        	return null;
        }        
        Node temp = head;
        for(int i = 0; i < index; i++){
        	temp = temp.next;
        }        
        	return temp;
	}	
	
	public void add(int index, String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			size++;
		} else if (index == 0) {
			newNode.next = head;
			head = newNode;
			size++;
		} else if (index == size) {
			Node temp = head;
			for (int i = 0; i < size-1; i++) {
				temp = temp.next;
			}
			temp.next = newNode;
			size++;
		}
		else {
			Node temp = head;
			for (int i = 0; i < index-1; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			size++;
		}
	}
	
	private String removeFirst(){
        Node temp = head;
        head = temp.next;
        String val = temp.data;
        temp = null;
        size--;
        return val;
    }

	String remove(int index) {
		String val = null;
		if (index < 0 || index > size) {
			System.out.println("wrong index");
			return null;
		} else if(index == 0) {
			return removeFirst();
		}
		Node temp = getNode(index-1);
	    Node todoDeleted = temp.next;
	    temp.next = temp.next.next;
	    val = todoDeleted.data; 
	    todoDeleted = null; 
	    size--;

		return val;
	}
	
	boolean remove(String data) {
		int index = indexOf(data);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}
	
	int indexOf(String str) {
		Node temp = head;
		for (int i = 0; i < size; i++) {
			if (temp.data == str) {
				return i;
			}
		}
		return -1;
	}
	
	int sizeOf() {
		return size;
	}
	
	public String toSting() {
		Node temp = head;
		String result = "";
		for (int i = 0; i < size; i++) {
			result = (result + temp.data.toString() + " ");
			temp = temp.next;
		}
		return result;
	}
}
