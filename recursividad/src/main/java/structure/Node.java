package structure;

public class Node <T>{

    public T value;
    public Node<T> right;
    public Node<T> left;

    public Node (T data){
        this.value= data;
    }

    public T getValue (){
        return value;
    }
    public void setValue (T value){
        this.value= value;
    }
    public Node<T> getRight(){
        return right;
    }
    public void setRight (Node<T> right){
        this.right= right;
    }
    public Node<T> getLeft(){
        return left;
    }
    public void setLeft (Node<T> left){
        this.left= left;
    }

}
