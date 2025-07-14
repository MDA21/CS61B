package deque;

public class LinkedListDeque<T>implements deque<T> {
    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;

        public StuffNode(StuffNode p, T item, StuffNode n){
            prev = p;
            item = item;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    //a new recursive linked list
    public LinkedListDeque(){
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        StuffNode first = new StuffNode(sentinel.next, item, sentinel.prev);
        sentinel.next.prev = first;
        sentinel.next = first;
        size++;
    }

    public void addLast(T item){
        StuffNode last = new StuffNode(sentinel.next, item, sentinel.prev);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        StuffNode current = sentinel.next;
        for(int i = 0; i < size; i++){
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        StuffNode current = sentinel.next;
        if(isEmpty()||current==sentinel){
            return null;
        }else{
            T removed = current.item;
            current.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return removed;
        }
    }

    public T removeLast(){
        StuffNode current = sentinel.prev;
        if(isEmpty()||current==sentinel){
            return null;
        }else{
            T removed = current.item;
            current.prev.next = sentinel;
            sentinel.prev = current.prev.prev;
            size--;
            return removed;
        }
    }

    public T get(int index){
        StuffNode current = sentinel.next;
        if(index >= size||index < 0){
            return null;
        }
        for(int i = 0; i < index;i++){
            current = current.next;
        }
        return current.item;
    }

    public T getRecursive(int index){
        if(index >= size||index < 0){
            return null;
        }else if(index == 0){
            return sentinel.item;
        }else{
            StuffNode current = sentinel.next;
            return getRecursive(index - 1);
        }
    }

}