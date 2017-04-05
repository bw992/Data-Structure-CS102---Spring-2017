package lab9;

public class PlusOne {
	
	   public static  ListNode plusOne(ListNode head ){
	    	if (head.value != 9){
	    		head.value = head.value +1 ; 
	    		return head;	
	    	}
	    	
	    	else {
	    		ListNode temp = head ; 
	    		temp.value = 0 ; 
	    		temp = temp.next;
	    		
	    		while(temp.value==9 ){
	    			temp.value = 0  ;
	    			
	    			
	    			if(temp.next==null){
	    				temp.next=  new ListNode(1);
	    			}	
	    			
	    			else{
	    				temp = temp.next;}
	    		}
	    		
	    		temp.value+=1;
	    		head = temp;
	    		
	    		return head; 
	    	}
	  }
}
