package hw4;

import java.util.Calendar;

public class customer {
	public int id;
	public Calendar arrival_time;
	public int queueLength;
	public int waitingTime;
	public customer next;


	public customer(int id, Calendar arrival_time){
		this.id=id;
		this.arrival_time = arrival_time;
	
}
	public int getwaitingtime(){
		return waitingTime;
	}
	public int getqueueLength(){
		return queueLength;
	}
	
	public void setwaitingtime(int x){
		waitingTime = x; 
	}
	public void setqueueLength(int x){
		queueLength = x; 
	}

	public customer() {
		// TODO Auto-generated constructor stub
	}

	public void displayLink(){
		System.out.print(id+"  "+arrival_time + " ");
	}

	
}