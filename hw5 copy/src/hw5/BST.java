package hw5;

import java.util.Comparator;

public class BST<T extends Comparable<T>, S>{
	private Node<T,S> root ;
	private int numberOfNodes;
	
	public BST(){
		this.root = null;
		this.numberOfNodes = 0 ; 
	}
	
	public  void preOrderTraversal(int i,int x ){
	      preOrderHelper(root,i,x);
	   }
	   private void preOrderHelper(Node<T,S> r, int i,int x)
	   {
	      if (r != null)
	      {
	    	 Person p = (Person)r.getValue();
	         if(p.getFatherSSN() ==i || p.getMotherSSN() ==x)
	        	 System.out.println(p.getFullname()+",");
	         preOrderHelper(r.left,i,x);
	         preOrderHelper(r.right,i,x);
	      }
	   }
	   
	   public  void preOrderTraversal_full(int i ,int x ){
		      preOrderHelper_full(root,i,x);
		   }
		   private void preOrderHelper_full(Node<T,S> r, int i,int x)
		   {
		      if (r != null)
		      {
		    	 Person p = (Person)r.getValue();
		         if(p.getFatherSSN() == i && p.getMotherSSN() ==x){
		        	 System.out.println(i);
		        	 System.out.println(x);
		        	 System.out.println(p.getFullname()+",");}
		         
		         preOrderHelper_full(r.left,i,x);
		         preOrderHelper_full(r.right,i,x);
		      }
		   }
		   
	public void insert(T key, S value){
		System.out.println("inserting" + (int)key);
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
//	    	System.out.println("inserting less than " + (int)key);
	        return this.findHelp(root.getLeft(), key);
	    } else if (root.getKey().compareTo(key) == 0) {
//	    	System.out.println("inserting equal" + (int)key);
	        return root.getValue();
	    } else {
//	    	System.out.println("inserting larger than" + (int)key);
	        return this.findHelp(root.getRight(), key);
	    }
	    }
	
	@SuppressWarnings("unchecked")
	private Node<T, S> insertHelp(Node<T, S> rootNode, T key, S element) {
	    if (rootNode == null) {
	        return new Node (key, element, null, null);
	    }
	    if (rootNode.getKey().compareTo(key) > 0) {
	        rootNode.setLeft(this.insertHelp(rootNode.getLeft(), key,
	            element));
	    } else {
//	    	System.out.println("inserting less than " + (int)key);
	        rootNode.setRight(this.insertHelp(rootNode.getRight(),
	            key, element));
	    }
	    return rootNode;
	    }
	
	 public int size() {
		    return this.numberOfNodes;
		    }
	}

   
    
    //https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
//https://codereview.stackexchange.com/questions/32270/generic-binary-search-tree-implementation
    


