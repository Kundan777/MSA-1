package singlyLinkedList;

import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

public class LinkedList1 {
	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.println(n.data + " ");
			n = n.next;
		}
	}

	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public void pushAfterGivenNode(Node pre_node, int data) {
		if (pre_node == null) {
			System.out.println("Given node is null");
			return;
		}
		Node new_node = new Node(data);
		new_node.next = pre_node.next;
		pre_node.next = new_node;

	}

	public void pushInLast(int data) {
		Node new_node = new Node(data);
		if (head == null) {
			head = new_node;
			return;
		}
		new_node.next = null;
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		return;
	}

	public void deleteKey(int data) {
		Node temp = head, pre_node = null;

		if (temp != null && temp.data == data) {
			head = temp.next;
			return;
		}
		while (temp != null & temp.data != data) {
			pre_node = temp;
			temp = temp.next;

		}
		if (temp == null)
			return;
		pre_node.next = temp.next;

	}

	public void deleteKeyAtGivenPosition(int position) {

		if (head == null) {
			return;
		}

		Node temp = head;
		if (position == 0) {
			head = temp.next;
			return;
		}
		for (int i = 0; temp != null && i < position - 1; i++) {
			temp = temp.next;
		}
		if (temp == null || temp.next == null)
			return;

		Node next = temp.next.next;
		temp.next = next;
	}

	public void deleteLinkedList1() {
		head = null;
	}

	public int printLengthOfLL() {
		int count = 0;
		Node n = head;
		while (n != null) {
			count++;
			System.out.println(n.data + " ");
			n = n.next;
		}
		return count;
	}

	public int getLlLength() {
		return getLength(head);
	}

	private int getLength(Node head2) {
		if (head2 == null)
			return 0;
		return 1 + getLength(head2.next);

	}

	public void searchElement(int element) {
		Node n = head;
		while (n != null) {
			if(n.data==element)
			{
				System.out.println("Element Fount in Linklist");
				return;
			}
			//System.out.println(n.data + " ");
			n = n.next;
		}
		System.out.println("Element Not Fount in Linklist");
	}
	
	public boolean searchElementrec(Node head,int ele) {
	if(head==null){
		return false;
	}
	if(head.data==ele)
		return true;
	return searchElementrec(head.next,ele);
	}
	
	
	public int getNthNode(int index) {
		int count = 0;
		Node n = head;
		while (n != null) {
			if(index==count){
				return n.data;
			}
			count++;
			n = n.next;
		}
		return 0;
	}
	
	public void printNthNodeFromLast(int n){
		int len=0;
		Node temp=head;
		while(temp!=null){
			temp=temp.next;
			len++;
		}
		if(len<n)
			return;
	
		temp=head;
		for(int i=1;i<len-n+1;i++){
			temp=temp.next;
		}
		System.out.println(temp.data);
		
	}
	public void nthfromLast(int n){
		Node main_ptr=head;
		Node ref_ptr=head;
		int count=0;
		if(head!=null){
			while(count<n){
				if(ref_ptr==null){
					return;
				}
				ref_ptr=ref_ptr.next;
				count++;
			}
			while(ref_ptr!=null){
				ref_ptr=ref_ptr.next;
				main_ptr=main_ptr.next;
			}
			System.out.println("Node no"+ n + "From last is" + main_ptr.data);
			
			
		}
	}
	
	public void middleOfLL(){
		Node first_ptr=head;
		Node second_ptr=head;
		if(head!=null){
		while(second_ptr!=null && second_ptr.next!=null){
			second_ptr=second_ptr.next.next;
			first_ptr=first_ptr.next;
			
		}
		System.out.println("Middle node is"+ first_ptr.data);
	}
	}
	
	public int count(Node head,int key){
		if(head==null)
			return 0;
		if(head.data==key)
			return 1+ count(head.next,key);
		return count(head.next, key);	
		
	}
	
	public boolean detectloop(Node n){
		HashSet<Node> set= new HashSet<>();
		while(n!=null){
			
			if(set.contains(n))
				return true;
			set.add(n);
			n=n.next;
		}
		return false;
		
	}
	public boolean isPalindrome(){
		Node slow=head;
		boolean isPalin=true;
		Stack<Integer> stack= new Stack<Integer>();
		while(slow!=null){
		stack.push(slow.data);
		slow=slow.next;
		}
		while(head!=null){
			int i=stack.pop();
			if(head.data==i){
				isPalin=true;
			}
			else {
				isPalin=false;
				break;
			}
			head=head.next; 
		}
		return isPalin;
		}
	
	public void removeduplicate(){
		Node curr=head;
		while(curr!=null){
		Node tem=curr;
		while (tem!=null && tem.data==curr.data)
		{
			tem=tem.next;
		}
		curr.next=tem;
		curr=curr.next;
	}
	}
	public Node removeduplicateRec(Node head){
		Node to_free;
		if(head==null){
			return null;
		}
		if(head.next!=null){
			if(head.data==head.next.data){
				to_free=head.next;
				head.next=head.next.next;
				removeduplicateRec(head);
			}
			else 
				removeduplicateRec(head.next);
		}
		
		return head;
	}
	
	
	public void swapNodes(int x, int y) 
    {
		if(x==y)
			return;
		Node prevX=null,currX=head;
		while(currX!=null && currX.data!=x){
			prevX=currX;
			currX=currX.next;
		}
			
		Node prevY=null,currY=head;
		while(currY!=null && currY.data!=y)
			{		
			prevY=currY;
			currY=currY.next;
			}
		if(currX==null || currY==null)
			return;
		
		if(prevX!=null)
			prevX.next=currY;
		else
			head=currY;
		
		if(prevY!=null)
			prevY.next=currX;
		else
			head=currX;
		
		Node temp=currX.next;
		currX.next=currY.next;
		currY.next=temp;
				
    }
	
	public void pairwiseSwapNodes() 
    { 
		Node temp=head;
		while(temp!=null && temp.next!=null)
		{
			int k=temp.data;
			temp.data=temp.next.data;
			temp.next.data=k;
			temp=temp.next.next;
		}
    }
		public void moveToFront(){
			if(head==null || head.next==null)
				return;
			Node seclast=null;
			Node last=head;
			while (last.next!=null){
				seclast=last;
				last=last.next;
			}
			
			seclast.next=null;
			last.next=head;
			head=last;
			
    }
		public int getIntersactionNode(Node head1,Node head2){
			int a=getLength(head1);
			int b=getLength(head2);
			int d;
			if(a>b){
				d=a-b;
				return intersactionPoint(d,head1,head2);
			}
			else 
				d=b-a;
			 return intersactionPoint(d,head2,head1);
			
			
		}
	private int intersactionPoint(int d, Node head1, Node head2) {
			// TODO Auto-generated method stub
			int i;
			Node current1=head1;
			Node current2=head2;
			for(i=0;i<d;i++)
			{
				if(current1==null)
					return -1;
			}
			current1=current1.next;
			while(current1 != null && current2 != null) { 
	            if (current1.data == current2.data) { 
	                return current1.data; 
	            } 
	            current1 = current1.next; 
	            current2 = current2.next; 
	        } 
			return -1;
			
		}
	public void segregateEvenOdd() { 
        
        Node evenStart = null; 
        Node evenEnd = null; 
        Node oddStart = null; 
        Node oddEnd = null; 
        Node currentNode = head;
        
        while(currentNode!=null)
        {
        	int ele=currentNode.data;
        	if(ele%2==0){
        		if(evenStart==null){
        			evenStart=currentNode;
        			evenEnd=evenStart;
        		}
        		else 
        			evenEnd=currentNode;
        			evenEnd=evenEnd.next;
        	}
        	else 
        		if(oddStart==null){
        			oddStart=currentNode;
        			oddEnd=oddStart;
        		}
        		else 
        			oddEnd=currentNode;
        			oddEnd=oddEnd.next;
        			
        	currentNode=currentNode.next;
        }
        if(oddStart == null || evenStart == null) { 
            return; 
        } 
          
        evenEnd.next = oddStart; 
        oddEnd.next = null; 
        head=evenStart; 
	}
	Node reverse(Node node) 
    { 
        Node prev = null; 
        Node current = node; 
        Node next = null; 
        while (current != null) { 
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
       node=prev;
       return node;
    }
	public static void main(String[] args) {
		LinkedList1 list = new LinkedList1();
		list.head = new Node(1);
		Node second = new Node(5);
		Node third = new Node(7);
		list.head.next = second;
		second.next = third;
		list.push(10);
		//list.head.next.next.next.next = list.head;
		//list.pushAfterGivenNode(second, 11);
		//list.pushInLast(23);
		//list.deleteKey(11);
		//list.deleteKeyAtGivenPosition(3);
		// list.deleteLinkedList1();
		//list.searchElement(11);
		//System.out.println(list.searchElementrec(list.head, 24));
		list.pairwiseSwapNodes(); 
		list.printList();
		list.swapNodes(7, 1);
		list.printList();
		list.moveToFront();
		list.printList();
	//	System.out.println(list.getNthNode(2));
		//System.out.println(list.printLengthOfLL());
		//System.out.println(list.getLlLength());
		//list.printNthNodeFromLast(1);
		//list.nthfromLast(2);
		list.middleOfLL();
		//System.out.println(list.count(list.head, 6));
		//System.out.println(list.detectloop(head));
	}

}
