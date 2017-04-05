package lab9;

public class ReverseLinkedList {

	public static ListNode reverseListIterative(ListNode head) {
		// TODO Auto-generated method stub
		ListNode currNode = head;
		ListNode nextNode= null;
		ListNode preNode = null; 
		
	 
		while(currNode!= null){
			nextNode =currNode.next;
			currNode.next  = preNode;
			preNode= currNode;
			currNode = nextNode; 
			 
			
		}
		head = preNode;
		return head; 
	}

	public static ListNode reverseListRecursive(ListNode head) {
		// TODO Auto-generated method stub
		ListNode p1=  head;
		ListNode p2 =  head.next;
		ListNode  preNode = null;
		return reverseRecur( p1,p2 ,preNode);
		
	}

	private static ListNode reverseRecur(ListNode ptrOne,ListNode ptrTwo, ListNode prevNode) {
		// TODO Auto-generated method stub

		if(ptrTwo!=null){
				if(ptrTwo.next!=null){
					ListNode t1 = ptrTwo;
					ListNode t2 = ptrTwo.next;
					ptrOne.next = prevNode;
					prevNode = ptrOne;
					return reverseRecur(t1,t2, prevNode);
				}
				else{
					ptrTwo.next = ptrOne;
					ptrOne.next = prevNode;
				//	System.out.println("\n Reverse Through Recursion");
					return ptrTwo;
				}
		}
		
		
		else if(ptrOne!=null){
			//System.out.println("\n Reverse Through Recursion");
			return ptrOne;
		}
		
		return null;
	
		
	}

	public static void display(ListNode head){
		//
		ListNode currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.value);
			currNode=currNode.next;
		}
	}
}


	


