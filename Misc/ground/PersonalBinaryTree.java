package ground;

public class PersonalBinaryTree {
	
	private BinaryTreeNode root;

	
	public boolean isEmpty() {
		if (this.root == null) {
			return true;
		}
		return false;
	}
	
	public BinaryTreeNode findNodeWithValue(int value) {
		if (!this.isEmpty()) {
			BinaryTreeNode currentNode = this.root;
			while (!currentNode.isLeaf()) {
				if (value == currentNode.getValue()) {
					return currentNode;
				} else if (value < currentNode.getValue()) {
					currentNode = currentNode.getLeftNode();
				} else {
					currentNode = currentNode.getRightNode();
				}
			}
			if (currentNode.getValue() == value) {
				return currentNode;
			}
		}
		return null;
	}
	
	public void insertValue(int value) {
		if (this.isEmpty()) {
			this.root = new BinaryTreeNode(value);
		} else {
			BinaryTreeNode currentNode = this.root;
			while (!currentNode.isLeaf()) {
				if (value <= currentNode.getValue()) {
					if (value >= currentNode.getLeftNode().getValue()) {
						currentNode.setLeftNode(new BinaryTreeNode(currentNode.getLeftNode(), null, value));
					} else {
						currentNode = currentNode.getLeftNode();
					}
				} else {
					if (value < currentNode.getRightNode().getValue()) {
						currentNode.setRightNode(new BinaryTreeNode(null, currentNode.getRightNode(), value));
					} else {
						currentNode = currentNode.getRightNode();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
