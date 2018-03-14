package models;

public class DLLNode extends ListNode{

	public DLLNode prev;
	public DLLNode next;
	public int val;
	
	public DLLNode(){
	} 
	
	public DLLNode(int val){
		this.val = val;
	}
}
