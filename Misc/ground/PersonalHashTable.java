package ground;

import java.util.ArrayList;
import java.util.LinkedList;

public class PersonalHashTable {

	private ArrayList<LinkedList<HashTableNode>> table;
	private int capacity;
	private int totalItems;
	public static final int INITIAL_CAPACITY = 10;
	public static final double DESIRED_THRESHOLD = 10;
	
	public PersonalHashTable() {
		capacity = INITIAL_CAPACITY;
		totalItems = 0;
		table = new ArrayList<LinkedList<HashTableNode>>(capacity);
	}
	
	public void put(Object key, Object value) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		int keyHash = key.hashCode();
		int bucketIndex = keyHash % capacity;
		if (get(key) == null) {
			table.get(bucketIndex).add(new HashTableNode(key, value));
		}
		totalItems++;
	}
	
	public Object get(Object key) {
		HashTableNode node = getNode(key);
		if (node != null) {
			return getNode(key).getValue();
		}
		return null;
	}
	
	private HashTableNode getNode(Object key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		int bucketIndex = key.hashCode() % capacity;
		for (HashTableNode node : table.get(bucketIndex)) {
			if (node.getKey().equals(key)) {
				return node;
			}
		}
		return null;
	}
	
	private double calculateLoadFactor() {
		return (totalItems / (table.size()));
	}
	
	private void resize(int newCapacity) {
		LinkedList<HashTableNode> tempList = new LinkedList<HashTableNode>();
		for (LinkedList<HashTableNode> bucket : table) {
			for (HashTableNode node : bucket) {
				tempList.add(node);
			}
		}
		table.ensureCapacity(newCapacity);
		capacity = newCapacity;
		for (HashTableNode node : tempList) {
			put(node.getKey(), node.getValue());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
