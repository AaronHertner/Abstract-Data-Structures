/* This class is an implementation of the LinkedList
    abstract data structure. It uses nodes, and has no
    concept of indexing. LinkedLists provide quick
    add() and remove() operations.
 */
public class LinkedList<T>{

    //Node sub-class we will use for
    //keeping track of our data and
    //building the list structure
    class Node{
        T x;
        Node next;
        public Node(T x){
            this.x = x;
            next = null;
        }
    }

    //this node keeps track of the head of
    //the list
    Node head;

    //integer for keeping track of the number
    //of elements in the list
    int n = 0;

    //function takes the position of the node
    //and returns the value
    public T get(int i){
        if(i < 0 || i > n-1) throw new IndexOutOfBoundsException();

        if(i == 0){
            return head.x;
        }
        else{
            Node current = head;
            for(int l = 0; l < i; l++){
                current = current.next;
            }
            return current.x;
        }
    }

    //function takes the element we wish to add
    //creates a new node, and adds it to the back
    //of the list
    public void add(T x){
        Node tmp = new Node(x);

        if(head == null){   //empty list
            head = tmp;
            n++;
        }
        else{               //non-empty list
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = tmp;
            n++;
        }
    }

    //function takes the element we wish to add
    //and adds it to the specified location in
    //the list structure
    public void add(T x, int i){
        if(i < 0 || i > n) throw new IndexOutOfBoundsException();

        Node tmp = new Node(x);

        if(i == 0){     //adding to the head
            tmp.next = head;
            head = tmp;
            n++;
        }
        else{
            Node current = head;
            for(int l = 0; l < i-1; l++){
                current = current.next;
            }
            tmp.next = current.next;
            current.next = tmp;
            n++;
        }
    }

    //function takes the position of the element
    //we wish to remove, and returns what was there
    public T remove(int i){
        if(i < 0 || i > n-1) throw new IndexOutOfBoundsException();

        if(i == 0){     //removing the head of the list
            T x = head.x;
            head = head.next;
            n--;
            return x;
        }

        else{
            Node current = head;
            for(int l = 0; l < i-1; l++){
                current = current.next;
            }
            T x = current.next.x;
            current.next = current.next.next;
            n--;
            return x;
        }
    }

    //function takes the position and the element we
    //wish to set, and returns the element that was
    //previously there
    public T set(T x, int i){
        if(i < 0 || i > n-1) throw new IndexOutOfBoundsException();

        if(i == 0){         //setting the head
            T y = head.x;
            head.x = x;
            return y;
        }

        else{
            Node current = head;
            for(int l = 0; l < i; l++){
                current = current.next;
            }
            T y = current.x;
            current.x = x;
            return y;
        }
    }

    //prints all contents of the list
    public void print(){
        Node current = head;
        for(int i = 0; i < n; i++){
            System.out.println(current.x);
            current = current.next;
        }
    }
}

