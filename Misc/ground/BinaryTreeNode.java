package ground;

public class BinaryTreeNode {

	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;
	private int value;
	
	public BinaryTreeNode(BinaryTreeNode leftNode, BinaryTreeNode rightNode, int value) {
		super();
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.value = value;
	}	
	public BinaryTreeNode(int value) {
		this(null, null, value);
	}
	
	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryTreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isLeaf() {
		if ( (this.leftNode == null) && (this.rightNode == null) ) {
			return true;
		}
		return false;
	}
}
