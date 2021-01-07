public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean add(String value){
    Node x = new Node(value);
    if(this.size() == 0){
      start = x;
      end = x;
      x.setPrev(null);
      x.setNext(null);
      size += 1;
      return true;
    }
    else if(this.size() == 1){
      x.setPrev(end);
      end = x;
      start.setNext(x);
      x.setNext(null);
      size += 1;
      return true;
    }
    else
    x.setPrev(end);
    end = x;
    x.setNext(null);
    size += 1;
    return true;
  }
}
