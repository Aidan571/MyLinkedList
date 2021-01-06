public class Node{
  private String data;
  private Node next,prev;

  public Node(String value){
    data = value;
  }

  public String getData(){
    return data;
  }

  public void setData(String insert){
    data = insert;
  }

  public Node getNext(){
    return next;
  }

  public void setNext(Node newNext){
    next = newNext;
  }

  public Node getPrev(){
    return prev;
  }

  public void setPrev(Node newPrev){
    prev = newPrev;
  }
}
