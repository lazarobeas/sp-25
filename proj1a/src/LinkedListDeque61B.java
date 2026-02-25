import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    // initializing sentinel node
    private Node sentinel;
    private int size;

    // building Node constructor
    public class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node (T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        sentinel.prev = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node curr = sentinel.next;
        while (curr != sentinel) {
            returnList.add(curr.item);
            curr = curr.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T saveItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return saveItem;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T saveItem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -=1;
        return saveItem;
    }

    @Override
    public T get(int index) {
        if (size == 0) {
            return null;
        }

        Node temp = sentinel.next;
        int idx = 0;
        while (idx != index) {
            idx++;
            temp = temp.next;
        }
        return temp.item;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
