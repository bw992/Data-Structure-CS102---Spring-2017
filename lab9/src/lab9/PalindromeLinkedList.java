package lab9;

public class PalindromeLinkedList {

	public static boolean isPalindrome(ListNode head) {
		// TODO Auto-generated method stub
		if(head== null){
			return true;
			
		}
		
		ListNode p = head;
		ListNode pre = new ListNode(head.value);
		
		while(p.next!=null){
			ListNode temp = new ListNode(p.next.value);
			temp.next = pre; 
			pre= temp; 
			p = p.next; 
		}
		
		ListNode p1 = head; 
		ListNode p2 = pre;
		
		while(p1!=null){
			if (p1.value != p2.value){
				return false; 
				
				
			}
			p1 = p1.next;
			p2= p2.next;
		}
		
		
		return true;
		
	}

		/*
		 if(head == null || head.next==null)
		        return true;
		 
		    //find list center
		    ListNode fast = head;
		    ListNode slow = head;
		 
		    while(fast.next!=null && fast.next.next!=null){
		        fast = fast.next.next;
		        slow = slow.next;
		    }
		 
		    ListNode secondHead = slow.next;
		    slow.next = null;
		 
		    //reverse second part of the list
		    ListNode p1 = secondHead;
		    ListNode p2 = p1.next;
		 
		    while(p1!=null && p2!=null){
		        ListNode temp = p2.next;
		        p2.next = p1;
		        p1 = p2;
		        p2 = temp;
		    }
		 
		    secondHead.next = null;
		 
		    //compare two sublists now
		    ListNode p = (p2==null?p1:p2);
		    ListNode q = head;
		    while(p!=null){
		        if(p.value != q.value)
		            return false;
		 
		        p = p.next;
		        q = q.next;
		 
		    }
		 
		    return true;
		}*/

}
