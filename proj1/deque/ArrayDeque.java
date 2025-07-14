package deque;

public class ArrayDeque {
    private int[] array;
    private int size;
    public ArrayDeque() {
        array = new int[100];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void addLast(int item){
        array[size] = item;
        size++;
    }

    public void addFirst(int item) {
        int[] arr = new int[++size];
        arr[0] = item;
        System.arraycopy(array, 0, arr, 1, size);
        array = arr;
    }

    public int removeFirst(){
        int item = array[0];
        int[] arr = new int[--size];
        System.arraycopy(array, 1, arr, 0, size);
        array = arr;
        return item;
    }

    public int removeLast(){
        int item = array[size - 1];
        size--;
        return item;
    }

    public int get(int i){
        return array[i];
    }


}