package tech.interview.problems.misc;

import java.util.HashMap;
import java.util.Map;

import tech.interview.problems.models.DLLNode;

public class LRUCache {
	private int capacity;
	private Map<String, DLLNode> map;
	private DLLNode head;
	private DLLNode end;
	
	LRUCache(int size){
		this.capacity = size;
		this.map = new HashMap<String, DLLNode>(size);
	}
	
	public Integer get(String key) {
		if(map.containsKey(key)) {
			DLLNode valueNode = map.get(key);
			remove(valueNode);
			setHead(valueNode);
			return valueNode.val;
		} 
		
		return null;
		
	}

	private void setHead(DLLNode valueNode) {
		if(head == null) {
			head = valueNode;
		} else {
			valueNode.next = head;
			head.prev = valueNode;
			head = valueNode;
		}
	}

	private void remove(DLLNode valueNode) {
		if(valueNode.next == null) {
			head.prev = null;
		}
	}
	
	
	

}
