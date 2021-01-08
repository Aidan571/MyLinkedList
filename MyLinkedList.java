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
      this.start = x;
      this.end = x;
      x.setPrev(null);
      x.setNext(null);
      size += 1;
      return true;
    }
    else if(this.size() == 1){
      x.setPrev(end);
      this.end = x;
      start.setNext(x);
      x.setNext(null);
      size += 1;
      return true;
    }
    else
    x.setPrev(end);
    this.end = x;
    x.setNext(null);
    size += 1;
    return true;
  }

  private Node whatsNext(int index){
    Node x = start;
    Node y;
    for(int i = 0; i < index; i++){
      y = x.getNext();
      x = y;
    }
    return x.getNext();
  }

  private Node whatsPrev(int index){
    Node x = start;
    Node y;
    for(int i = 0; i < index - 1; i++){
      y = x.getNext();
      x = y;
    }
    return x.getNext();
  }

  public boolean add(int index, String value){
    Node x = new Node(value);
    Node holder0;
    Node holder1;
    if(index < 0){
      throw new IndexOutOfBoundsException("Index can not be negative");
    }
    else if(index > this.size()){
      throw new IndexOutOfBoundsException("Index: " + index + " can not be larger than the size of the LinkedList");
    }
    else if(this.size() == 0){
      start = x;
      end = x;
      x.setPrev(null);
      x.setNext(null);
      size += 1;
      return true;
    }
    else if(this.size() == 1){
      if(index == 0){
        start = x;
        end.setPrev(x);
        x.setPrev(null);
        x.setNext(end);
        size += 1;
        return true;
      }
      else
      end = x;
      start.setNext(x);
      x.setPrev(start);
      x.setNext(null);
      size += 1;
      return true;
    }
    else
    if(index == 0){
      start.setPrev(x);
      x.setNext(start);
      start = x;
      x.setPrev(null);
      size += 1;
      return true;
    }
    else if(index == this.size()){
      end.setNext(x);
      x.setPrev(end);
      end = x;
      x.setNext(null);
      size += 1;
      return true;
    }
    else
    holder0 = this.whatsNext(index);
    holder1 = this.whatsPrev(index);
    this.whatsNext(index).setPrev(x);
    this.whatsPrev(index).setNext(x);
    x.setNext(holder0);
    x.setPrev(holder1);
    size += 1;
    return true;
  }

  public String get(int index){
    Node x = this.start;
    Node y;
    for(int i = 0; i < index; i++){
      y = x.getNext();
      x = y;
    }
    return x.getData();
  }

  public String set(int index, String value){
    Node x = this.start;
    Node y = this.start;
    for(int i = 0; i < index; i++){
      y = x.getNext();
      x = y;
    }
    x.setData(value);
    return y.getData();
  }
}
