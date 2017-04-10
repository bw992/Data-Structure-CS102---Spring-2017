package hw4;

import java.util.Calendar;

public class customerlist {
	private customer front; 
	private customer rear;
	
	public customerlist(){
		front= null; 
		rear = null; 
	}
	
	public boolean isEmpty(){
		if(front ==null){
			return true;}
		else{
			return false;
		}
	}
	
	public boolean isFull(){
		return false; 
	}
	
	//Add cus into the rear of this queue
	public void enqueue(int i, Calendar j){
		customer new_cus = new customer(i,j);
		new_cus.arrival_time=j;
		new_cus.id=i;
		if(rear ==null){
			front = new_cus;
		}
		else{
			rear.next = new_cus;
			
		}
		rear = new_cus;
	}
	
	public void enqueue(customer i){
		customer new_cus = new customer();
		new_cus.arrival_time =i.arrival_time;
		new_cus.id =i.id;
		new_cus.waitingTime=i.waitingTime;
		if(rear ==null){
			front = new_cus;
		}
		else{
			rear.next = new_cus;
			
		};
		rear = new_cus;
	}
		
	//Removes front cus from this queue 
	public customer dequeue(customer i){
		
		customer temp ;
		temp = front;
		//i.next = null;
		temp.id=front.id;
		temp.arrival_time=front.arrival_time;
		front = front.next;
		if(front==null){
			rear =null;
		}
		
		return temp;
	}
	
	public int getwaittime(int id){
		//Calculate waiting time in line 
		customer temp;
		int x=0;
		temp = front;
		while(temp!=null){
			if(temp.id ==id){
				 x= temp.waitingTime;
			}
			temp=temp.next;
			
		}
		return x;
		
	}

	
		
	
}
