package tech.interview.problems.models;

public abstract class AbstractListNode<T> implements IListNode<T> {
	
	public T next;
	public int val;
	
	AbstractListNode(){
	}
	
	AbstractListNode(int val){
		this.val = val;
	}

	
}
