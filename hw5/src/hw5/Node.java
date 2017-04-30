package hw5;

class Node<T extends Comparable<T>, S>{
    
    private T key;    //ssn
	private S value;    //    T Data Type Person 
    public Node<T,S> left;
    public Node<T,S> right;
    

    public Node(T key, S value,Node<T,S> left,Node<T,S> right) {
        this.value = value;
        this.key =key;
        this.left=left;
        this.right=right;
    }


	public S getValue() {
        return value;
    }
    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setValue(S value) {
        this.value = value;
    }

    public Node<T,S> getLeft() {
        return left;
    }

    public void setLeft(Node<T,S> left) {
        this.left = left;
    }

    public Node<T,S> getRight() {
        return right;
    }

    public void setRight(Node<T,S> right) {
        this.right = right;
    }
    
    public int compareTo(S e1, S e2) {
        return (int) (((Person) e1).getSSN() - ((Person) e2).getSSN());
    }
} 
