package simpleList;

public class SimpleListApp {
	public static void main(String[] args) {
		SimpleArrayList simpleArrayList = new SimpleArrayList();
		SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
		
		System.out.println("----------simpleArrayList----------");
		simpleArrayList.add(simpleArrayList.sizeOf(), "aaa");
		simpleArrayList.add(simpleArrayList.sizeOf(), "bbb");
		simpleArrayList.add(simpleArrayList.sizeOf(), "ccc");
		System.out.println(simpleArrayList.toSting());
		simpleArrayList.add(simpleArrayList.sizeOf(), "ddd");
		System.out.println("after add : " + simpleArrayList.toSting());
		simpleArrayList.remove(2);
		System.out.println("after remove : " + simpleArrayList.toSting());
		System.out.println("size : " + simpleArrayList.sizeOf());
		System.out.println("index of \"aaa\" : " + simpleArrayList.indexOf("aaa"));
		System.out.println("data of index'0' : " + simpleArrayList.get(0));
		System.out.println("");

		System.out.println("----------simpleLinkedList----------");
		simpleLinkedList.add(simpleLinkedList.sizeOf(), "aaa");
		simpleLinkedList.add(simpleLinkedList.sizeOf(), "bbb");
		simpleLinkedList.add(simpleLinkedList.sizeOf(), "ccc");
		System.out.println(simpleLinkedList.toSting());
		simpleLinkedList.add(simpleLinkedList.sizeOf(), "ddd");
		System.out.println("after add : " + simpleLinkedList.toSting());
		simpleLinkedList.remove(2);
		System.out.println("after remove : " + simpleLinkedList.toSting());
		System.out.println("size : " + simpleLinkedList.sizeOf());
		System.out.println("index of \"aaa\" : " + simpleLinkedList.indexOf("aaa"));
		System.out.println("data of index'0' : " + simpleLinkedList.get(0));
	}
}
