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
      size += 1;
      return true;
    }
    else if(this.size() == 1){
      x.setPrev(end);
      this.end = x;
      start.setNext(x);
      size += 1;
      return true;
    }
    else{
      x.setPrev(end);
      end.setNext(x);
      this.end = x;
      x.setNext(null);
      size += 1;
      return true;
    }
  }

  private Node whatsNode(int index){
    Node x = start;
    Node y;
    for(int i = 0; i < index; i++){
      y = x.getNext();
      x = y;
    }
    return x;
  }

  public void add(int index, String value){
    Node x = new Node(value);
    Node holder0 = x;
    Node holder1 = x;
    if(index < 0){
      throw new IndexOutOfBoundsException("Index can not be negative");
    }
    else if(index > this.size()){
      throw new IndexOutOfBoundsException("Index: " + index + " can not be larger than the size of the LinkedList");
    }
    else if(this.size() == 0){
      start = x;
      end = x;
      size += 1;
    }
    else if(this.size() == 1){
      if(index == 0){
        start = x;
        end.setPrev(start);
        x.setNext(end);
        size += 1;
      }
      else{
        end = x;
        start.setNext(x);
        x.setPrev(start);
        size += 1;
      }
    }
    else{
      if(index == 0){
        start.setPrev(x);
        x.setNext(start);
        start = x;
        size += 1;
      }
      else if(index == this.size()){
        this.add(value);
      }
      else{
        holder0 = this.whatsNode(index);
        holder1 = this.whatsNode(index).getPrev();
        holder0.setPrev(x);
        holder1.setNext(x);
        x.setNext(holder0);
        x.setPrev(holder1);
        size += 1;
      }
    }
  }

  public String get(int index){
    Node x = this.start;
    Node y;
    if(index < 0){
      throw new IndexOutOfBoundsException("Index can not be negative");
    }
    else if(index > this.size()){
      throw new IndexOutOfBoundsException("Index: " + index + " can not be larger than the size of the LinkedList");
    }
    else{
      for(int i = 0; i < index; i++){
        y = x.getNext();
        x = y;
      }
    }
    return x.getData();
  }

  public String set(int index, String value){
    Node x = this.start;
    Node y = this.start;
    if(index < 0){
      throw new IndexOutOfBoundsException("Index can not be negative");
    }
    else if(index > this.size()){
      throw new IndexOutOfBoundsException("Index: " + index + " can not be larger than the size of the LinkedList");
    }
    else{
      for(int i = 0; i < index; i++){
        y = x.getNext();
        x = y;
      }
    }
    x.setData(value);
    return y.getData();
  }

  public String toString(){
    String result = "[";
    Node travel = start;
    for(int i = 0; i < size; i++){
      if(i == size - 1){
        result += travel.getData();
      }
      else{
        result += travel.getData() + ", ";
        travel = travel.getNext();
      }
    }
    return result + "]";
  }

  public String toStringReversed(){
      String result = "[";
      Node travel = end;
      for(int i = size - 1; i >= 0; i--){
        if(i == 0){
          result += travel.getData();
        }
        else{
          result += travel.getData() + ", ";
          travel = travel.getPrev();
        }
      }
      return result + "]";
    }

  public String remove(int index){
    Node x = start;
    Node y;
    if(index < 0){
      throw new IndexOutOfBoundsException("Index can not be negative");
    }
    else if(index > this.size()){
      throw new IndexOutOfBoundsException("Index: " + index + " can not be larger than the size of the LinkedList");
    }
    else if(size == 0){
      throw new IndexOutOfBoundsException("Can not remove a value from a LinkedList with a size of 0");
    }
    else if(size == 1){
      x = start;
      size = 0;
      return x.getData();
    }
    else if(size == 2){
      size = 1;
      if(index == 0){
        x = start;
        start = end;
        end.setPrev(null);
        return x.getData();
      }
      else{
        x = end;
        end = start;
        start.setNext(null);
        return x.getData();
      }
    }
    else{
      if(index == 0){
        x = start;
        start = start.getNext();
        start.setPrev(null);
        size--;
        return x.getData();
      }
      else if(index == this.size - 1){
        x = end;
        end = end.getPrev();
        end.setNext(null);
        size--;
        return x.getData();
      }
      else{
        for(int i = 0; i < index; i++){
          y = x.getNext();
          x = y;
        }
        x.getNext().setPrev(x.getPrev());
        x.getPrev().setNext(x.getNext());
        size--;
        return x.getData();
      }
    }
  }

  public void extend(MyLinkedList other){
    if(size == 0){
      start = other.start;
      end = other.end;
      size = other.size;
      other.size = 0;
    }
    else if(other.size == 0){
    }
    else{
      other.start.setPrev(end);
      end.setNext(other.start);
      end = other.end;
      size += other.size;
      other.size = 0;
    }
  }

  public static void main(String[]args){
    MyLinkedList link = new MyLinkedList();
    link.add("1");
    link.add("2");
    link.add("3");
    link.add(2,"4");
    link.add(0, "5");
    link.add(5, "8");
    System.out.println(link);
    MyLinkedList test = new MyLinkedList();
    test.add(0, "1");
    test.add(0, "2");
    test.add(0, "3");
    test.set(1, "10");
    test.add("2");
    test.add("3");
    System.out.println(test.remove(0));
    System.out.println(test);
    MyLinkedList extend = new MyLinkedList();
    extend.add("Hi");
    link.extend(extend);
    System.out.println(extend);
    System.out.println(link);
    System.out.println(extend.toStringReversed());
    System.out.println(link.end.getData());
    System.out.println(link.toStringReversed());
    }
  }
