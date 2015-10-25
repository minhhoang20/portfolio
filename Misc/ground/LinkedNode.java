package ground;

public class LinkedNode {

	private LinkedNode nextNode;
	private int value;
	
	public LinkedNode(LinkedNode nextNode, int value) {
		this.nextNode = nextNode;
		this.value = value;
	}
	
	public LinkedNode(int value) {
		this(null, value);
	}
	
	public LinkedNode() {
		this(null, 0);
	}
	
	public LinkedNode getNextNode() {
		return this.nextNode;
	}
	
	public void setNextNode(LinkedNode node) {
		this.nextNode = node;
	}
	
	public int getValue() {
		return this.value;
	}
}
