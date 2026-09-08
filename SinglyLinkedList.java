public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }
    /**
     * Write a method named toString to print out the elements starting from the head element  
    • Write a method named removeLast that removes the last element 
    • Write a method named reverse that reverses the sequence of all the elements  
     */
    // Write your codes below
    public String toString(){
     // 0 1 2 boundary
        if (size == 0) {
            return "";
        } else {
            String result = "";
            Node<E>walk = head;
            while(walk != null) {
                result += walk.getElement();
                walk = walk.getNext();
            }
            return result;
        }
    }

    public E removeLast(){
        // 0 1 2 boundary
        E result = null;
        if (tail == null) {
            return null;
        } else {
            if (head == tail) {
                result = head.getElement();
                head = null;
                tail = head;
                size--;
            } else {
                Node<E> walk = head;
                while (walk.getNext() != tail) {
                    walk = walk.getNext();
                }
                result = tail.getElement();
                tail = walk;
                walk.setNext(null);
                size--;
                return result;
            }
        }
        return result;
    }

    public void reverse(){    
        // 0 1 2 boundary
        if (tail == null || tail == head) {
            return;
        } else {
            SinglyLinkedList<E> result = new SinglyLinkedList<>();
            // removefirst then build reverse list
            Node<E> walk = head;
            // 123 -> 321
            while(walk != null) {
                result.addFirst(walk.getElement());
                walk = walk.getNext();
            }
            head = result.head;
            tail = result.tail;
        }   
    }
}