package doubleLinkedList;

public class DoubleLinkedList {
	private Node header;
	private int size;

	public DoubleLinkedList() {
		header = new Node(null);
		size = 0;
	}

	private class Node {
		private Object data;
		private Node pri;
		private Node next;

		Node(Object data) {
			this.data = data;
			this.pri = null;
			this.next = null;
		}
	}

	public Object get(int index) {
		return getNode(index).data;
	}

	private Node getNode(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
		}
		Node node = header;

		if (index < (size / 2)) {
			for (int i = 0; i <= index; i++) {
				node = node.next;
			}
		} else {
			for (int i = size; i > index; i--) {
				node = node.pri;
			}
		}
		return node;
	}

	private int getNodeIndex(Object obj) {
		if (size <= 0) {
			return -1;
		}
		int index = 0;
		Node node = header.next;
		Object nodeDate = node.data;
		while (!obj.equals(nodeDate)) {
			node = node.next;
			if (node == null) {
				return -1;
			}
			nodeDate = node.data;
			index++;
		}
		return index;
	}

	public void addFirst(Object data) {
		Node newNode = new Node(data);
		newNode.next = header.next;

		if (header.next != null) {
			header.next.pri = newNode;
		} else {
			header.pri = newNode;
		}
		header.next = newNode;
		size++;
	}

	public void add(int index, Object data) {
		if (index == 0) {
			addFirst(data);
			return;
		}
		Node prev = getNode(index - 1);
		Node next = prev.next;
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.pri = prev;
		newNode.next = next;

		if (newNode.next != null) {
			next.pri = newNode;
		} else { 
			header.pri = newNode;
		}
		size++;
	}

	public void addLast(Object data) {
		add(size, data);
	}

	public void add(Object data) {
		addLast(data);
	}

	public Object removeFirst() {
		Node firstNode = getNode(0);
		header.next = firstNode.next;

		if (header.next != null) {
			firstNode.next.pri = null;
		} else {
			header.pri = null;
		}
		size--;
		return firstNode.data;
	}

	public Object remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
		} else if (index == 0) {
			return removeFirst(); 
		}
		Node removeNode = getNode(index);
		Node previous = removeNode.pri;
		Node next = removeNode.next;
		previous.next = next;

		if (next != null) {
			next.pri = previous;
		} else { 
			header.pri = previous;
		}
		size--;
		return removeNode.data;
	}

	public boolean remove(Object data) {
		int nodeIndex = getNodeIndex(data);

		if (nodeIndex == -1) {
			return false;
		} else { 
			remove(nodeIndex);
			return true;
		}
	}

	public Object removeLast() {
		return remove(size - 1);
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer("[");
		Node temp = header.next;

		if (temp != null) {
			ret.append(temp.data);
			temp = temp.next;

			while (temp != null) {
				ret.append(", ");
				ret.append(temp.data);
				temp = temp.next;
			}
		}

		ret.append("]");
		return ret.toString();
	}

	public static void main(String[] args) {
		DoubleLinkedList test = new DoubleLinkedList();
		test.add("shopping");
		test.add("gym");
		test.add("sleeping");
		test.add(1, "eating");
		System.out.println(test.toString());
		test.remove("gym");
		System.out.println(test.toString());
		System.out.println(test.size());
	}
}