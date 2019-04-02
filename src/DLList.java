/*
    An implementation of a doubly linked list
    add() and remove() are fast operations on
    the back and front of the list
 */
public class DLList<T> {

    //the node class we'll be using
    //to store data and build our
    //structure
    class Node{
        T x;
        Node next;
        Node prev;
        public Node(T x){
            this.x = x;
            next = null;
            prev = null;
        }
    }

    //The node we'll use to keep track of the front
    //of the list
    Node head;

    //the node we'll use to keep track of the back
    //of the list
    Node tail;

    //this variable is used to keep track of the
    //number of elements in the list
    int n;

    //takes an index i as a parameter and returns
    //the element in that location
    public T get(int i){
        if(i < 0 || i > n-1) throw new IndexOutOfBoundsException();

        //user wants the first element in the list
        if(i == 0){return head.x;}

        else{
            Node current = head;
            for(int l = 0; l < i; l++){
                current = current.next;
            }
            return current.x;
        }
    }

    //takes an index i as a parameter and removes
    //the node in that position, returns that nodes
    //element
    public T remove(int i){
        if(i < 0 || i > n-1) throw new IndexOutOfBoundsException();

        //removing the last remaining element
        if(n == 1){
            T y = head.x;
            head = null;
            tail = null;
            n--;
            return y;
        }

        //removing the head
        else if(i == 0){
            T y = head.x;
            head = head.next;
            head.prev = null;
            n--;
            return y;
        }

        //removing the tail
        if(i == n-1){
            T y = tail.x;
            tail = tail.prev;
            tail.next = null;
            n--;
            return y;
        }

        else{
            if(i > n/2){    //position is closer to tail
                Node current = tail;
                for(int l = n-1; l > i+1; l--){
                    current = current.prev;
                }
                T y = current.prev.x;
                current.prev = current.prev.prev;
                current.prev.next = current;
                n--;
                return y;
            }
            else{           //position is closer to head
                Node current = head;
                for(int l = 0; l < i-1; l++){
                    current = current.next;
                }
                T y = current.next.x;
                current.next = current.next.next;
                current.next.prev = current;
                n--;
                return y;
            }
        }
    }

    //adds the given element to the back of
    //the list
    public void pushBack(T x){
        Node tmp = new Node(x); //node we want to add

        if(n == 0){     //first element added to list
            tail = tmp;
            head = tmp;
            n++;
        }
        else {
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
            n++;
        }
    }

    //adds the given element to the front of
    //the list
    public void pushFront(T x){
        Node tmp = new Node(x); //node we want to add

        if(n == 0) {    //first element added to list
            head = tmp;
            tail = tmp;
            n++;
        }
        else {
            head.prev = tmp;
            tmp.next = head;
            head = tmp;
            n++;
        }
    }

    //takes an index i parameter, and an element T
    //adds the element to the given position i
    public void add(int i, T x){
        if(i < 0 || i > n) throw new IndexOutOfBoundsException();

        Node tmp = new Node(x); //node we want to add

        //adding the first element in the list
        if(n == 0){
            head = tmp;
            tail = tmp;
            n++;
        }

        //position is at the head
        else if(i == 0){
            pushFront(x);
        }

        //position is at the tail
        else if(i == n){
            pushBack(x);
        }

        else{
            if(i > n/2){       //position i is closer to the tail
                Node current = tail;
                for(int l = n-1; l > i+1; l--){
                    current = current.prev;
                }
                current.prev.next = tmp;
                tmp.prev = current.prev;
                tmp.next = current;
                current.prev = tmp;
                n++;
            }
            else{               //position i is closer to the head
                Node current = head;
                for(int l = 0; l < i-1; l++){
                    current = current.next;
                }
                current.next.prev = tmp;
                tmp.next = current.next;
                current.next = tmp;
                tmp.prev = current;
                n++;
            }
        }
    }

    //takes an index i parameter, and an element T x
    //sets the element in position i to x and returns
    //what was previously there
    public T set(int i, T x){
        if(i < 0 || i > n-1) throw new IndexOutOfBoundsException();

        if(i == 0){     //position is at the head
            T y = head.x;
            head.x = x;
            return y;
        }
        else if(i == n-1){  //position is at the tail
            T y = tail.x;
            tail.x = x;
            return y;
        }
        else{
            if(i > n/2){    //position i is closer to the tail
                Node current = tail;
                for(int l = n-1; l > i; l--){
                    current = current.prev;
                }
                T y = current.x;
                current.x = x;
                return y;
            }
            else{           //position i is closer to the head
                Node current = head;
                for(int l = 0; l < i; l++){
                    current = current.next;
                }
                T y = current.x;
                current.x = x;
                return y;
            }
        }
    }
}
