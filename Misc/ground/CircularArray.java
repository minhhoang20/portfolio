package ground;

import java.util.ArrayList;

public class CircularArray<E> extends ArrayList<E> {

	private int length;
	private int currentIndex;
	
	public CircularArray(int size) {
		super(size);
		this.length = size;
		this.currentIndex = 0;
	}
	

	public boolean add(E e) {
		if ((super.size() >= this.length)) {
			super.set(this.currentIndex, e);
		}
		else
			super.add(this.currentIndex, e);
		this.currentIndex = (this.currentIndex + 1) % this.length;
		return true;
	}



	public static void main(String[] args) {
		CircularArray<String> testArray = new CircularArray<>(4);
		testArray.add("Hey 1");
		testArray.add("Hey 2");
		testArray.add("Hey 3");
		testArray.add("Hey 4");
		System.out.println(testArray.toString());
		testArray.add("Hey 5");
		System.out.println(testArray.toString());
		testArray.add("Hey 6");
		for (String s : testArray)
			System.out.println(s);
	}

}
