package hw5;

import java.util.ArrayList;


public class BST<T extends Comparable<T>, S>{
	private Node<T,S> root ;
	private int numberOfNodes;
	
	public BST(){
		this.root = null;
		this.numberOfNodes = 0 ; 
	}
	
	public  String preOrderTraversal(int i,int x ,int y){
		 ArrayList<String> x1 = new ArrayList<String>();
	     
	      x1 = preOrderHelper(root,i,x,y,x1);
	      if (x1.size()==0){
	    	  String un = "UNAVAILABLE ";
	    	  return un;
	      }
	      else{
	    	  String format = x1.toString().replace("[", "");
	    	  format = format.replace("]", "");
	    	  return format;
	      }
	      
	   }
	
	   private ArrayList<String> preOrderHelper(Node<T,S> r, int i,int x,int y,ArrayList<String> x1)
	   {
	      if (r != null)
	      {
	    	 Person p = (Person)r.getValue();
	         if( p.getSSN()!=y && (p.getFatherSSN() ==i || p.getMotherSSN() ==x ))
	        	 x1.add(p.getFullname());
	         preOrderHelper(r.left,i,x,y,x1);
	         preOrderHelper(r.right,i,x,y,x1);
	      }
	      return x1;
	   }
	   
		public  String preOrderTraversal_inverse(int i){
			 ArrayList<String> x1 = new ArrayList<String>();
		     
		      x1 = preOrderHelper_inverse(root,i,x1);
		      if (x1.size()==0){
		    	  String un = "UNAVAILABLE ";
		    	  return un;
		      }
		      else{
		    	  String format = x1.toString().replace("[", "");
		    	  format = format.replace("]", "");
		    	  return format;
		      }
		      
		   }
		
		   private ArrayList<String> preOrderHelper_inverse(Node<T,S> r, int i,ArrayList<String> x1)
		   {
		      if (r != null)
		      {
		    	 Person p = (Person)r.getValue();
		         if(p.isYourFriend(i)==true)
		        	 x1.add(p.getFullname());
		         preOrderHelper_inverse(r.left,i,x1);
		         preOrderHelper_inverse(r.right,i,x1);
		      }
		      return x1;
		   }
		   
		   public  String preOrderTraversal_mutual(int i,BST b){
			      String x1 = null ;
			     
			      x1 = preOrderHelper_mutual(root,b,i,x1);
			     
			      if (x1.length()==0){
			    	  String un = "UNAVAILABLE ";
			    	  return un;
			      }
			      else{
			    	  String format = x1.toString().replace("[", "");
			    	  format = format.replace("]", "");
			    	  return format;
			      }
			      
			   }
			
			   private String preOrderHelper_mutual(Node<T,S> r,BST bst, int i,String x1)
			   {
			      if (r != null)
			      {
			    	 int p = (int)r.getValue();
			    	 x1 =bst.preOrderTraversal_inverse(i);}
				
			      return x1;
			    	 
			   }
			   
			   public int preOrderTraversal_mutual_count(int i,BST b){
					  ArrayList<String> x1 = new ArrayList<String>();
				     
				      int x3 = preOrderHelper_mutual_count(root,b,i,x1);
				 
				       return x3;
				   }
				
				   private int preOrderHelper_mutual_count(Node<T,S> r,BST bst, int i,ArrayList<String> x1)
				   {
					  int x2 =0;
				      if (r != null)
				      {
				    	 int p = (int)r.getValue();
				    	 x2= bst.preOrderTraversal_inverse_count(i);}
					
				      return x2;
				    	 
				   }
				   
				   public int preOrderTraversal_inverse_count(int i){
						 ArrayList<String> x1 = new ArrayList<String>();
					     
					      x1 = preOrderHelper_inverse(root,i,x1);
					      return x1.size();
					      
					   }
					
					   private ArrayList<String> preOrderHelper_inverse_count(Node<T,S> r, int i,ArrayList<String> x1)
					   {
					      if (r != null)
					      {
					    	 Person p = (Person)r.getValue();
					         if(p.isYourFriend(i)==true)
					        	 x1.add(p.getFullname());
					         preOrderHelper_inverse_count(r.left,i,x1);
					         preOrderHelper_inverse_count(r.right,i,x1);
					      }
					      return x1;
					   }
	   
	   public  String preOrderTraversal_full(int i ,int x ,int y ){
		     
		      ArrayList<String> x1 = new ArrayList<String>();
			     
		      x1 =  preOrderHelper_full(root,i,x,y,x1);
		      if (x1.size()==0){
		    	  String un = "UNAVAILABLE ";
		    	  return un;
		      }
		      else{
		    	  String format = x1.toString().replace("[", "");
		    	  format = format.replace("]", "");
		    	  return format;
		      }
		      
		   }
		   private ArrayList<String> preOrderHelper_full(Node<T,S> r, int i,int x,int y,ArrayList<String> x1)
		   {
		      if (r != null)
		      {
		    	 Person p = (Person)r.getValue();
		         if(p.getFatherSSN() == i && p.getMotherSSN() ==x && p.getSSN()!=y){
		        	 //System.out.println(i);
		        	// System.out.println(x);
		        	 x1.add(p.getFullname());
		        	 }
		         
		         preOrderHelper_full(r.left,i,x,y,x1);
		         preOrderHelper_full(r.right,i,x,y,x1);
		      }
		      return x1;
		   }
		   
		   public  String preOrderTraversal_children(int i){
			   	  int count = 0;
			   	  ArrayList<String> x = new ArrayList<String>();
			      x=preOrderHelper_children(root,i,count,x);
			      
			      if (x.size()==0){
			    	  String un = "UNAVAILABLE ";
			    	  return un;
			      }
			      else{
			    	  String format = x.toString().replace("[", "");
			    	  format = format.replace("]", "");
			    	  return format;
			      }
			      
			   }
		   
			   private ArrayList<String> preOrderHelper_children(Node<T,S> r, int i,int count,ArrayList<String> x)
			   {
				  
			      if (r != null)
			      {
			    	 Person p = (Person)r.getValue();
			         if(p.getFatherSSN() == i || p.getMotherSSN() ==i ){
		
			        	 x.add( p.getFullname());
			
			        	 }
			         
			         preOrderHelper_children(r.left,i,count,x);
			         preOrderHelper_children(r.right,i,count,x);
			      }
				return x;
			      
			      
			     
			   }
			   
		   
	public void insert(T key, S value){
		//System.out.println("inserting" + (int)key);
		this.root= this.insertHelp(this.root, key, value);
	    this.numberOfNodes++;
	    }
	
	public S find(T key) {
    return this.findHelp(this.root, key);
    }
	
	private S findHelp(Node<T, S> root, T key) {
	    if (root == null) {
	        return null;
	    }
	    if (root.getKey().compareTo(key) > 0) {
	        return this.findHelp(root.getLeft(), key);
	    } else if (root.getKey().compareTo(key) == 0) {
	        return root.getValue();
	    } else {
	        return this.findHelp(root.getRight(), key);
	    }
	    }
	
	private Node<T, S> insertHelp(Node<T, S> rootNode, T key, S element) {
	    if (rootNode == null) {
	        return new Node<T, S> (key, element, null, null);
	    }
	    if (rootNode.getKey().compareTo(key) > 0) {
	        rootNode.setLeft(this.insertHelp(rootNode.getLeft(), key,
	            element));
	    } else {
	        rootNode.setRight(this.insertHelp(rootNode.getRight(),
	            key, element));
	    }
	    return rootNode;
	    }
	
	 public int size() {
		    return this.numberOfNodes;
		    }
	}

   

