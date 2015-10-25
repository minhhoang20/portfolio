package ground;

public class PersonalLinkedList {
	
	LinkedNode firstNode;
	
	public PersonalLinkedList() {
		this.firstNode = null;
	}
	
	public void appendNode(LinkedNode node) {
		if (this.firstNode == null) {
			this.firstNode = node;
		} else {
			LinkedNode currentNode = this.firstNode;
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(node);
		}
	}
	
	public void appendValue(int value) {
		this.appendNode(new LinkedNode(value));
	}
	
	public void printAll() {
		if (this.firstNode == null) {
			System.out.println("LinkedList is empty.");
		} else {
			LinkedNode currentNode = this.firstNode;
			System.out.print("" + currentNode.getValue());
			if (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
				while (currentNode.getNextNode() != null) {
					System.out.print(", " + currentNode.getValue());
					currentNode = currentNode.getNextNode();
				}
				System.out.print(", " + currentNode.getValue());
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		int[] squareList = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
		PersonalLinkedList linkedList = new PersonalLinkedList();
		for (int i = 0; i < squareList.length; i++) {
			linkedList.appendValue(squareList[i]);
		}
		linkedList.printAll();
	}

}
