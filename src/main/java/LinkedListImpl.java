import java.util.Iterator;

public class LinkedListImpl<T> extends AbstractList<T>{
    private Node<T> head;
    private int size;
    @Override
    public void add(T item) {
        Node<T> node = new Node<>();
        node.data = item;
        if (head==null) {
            head = node;
        } else {
            Node<T> n = head;
            while (n.next !=null)
            {
                n.previous = n;
                n = n.next;
            }
            n.next = node;
        }
        size++;
    }

    @Override
    public void add(int index, Object item) {

    }

    @Override
    public void set(int index, Object item) {

    }

    @Override
    public void remove(Object item) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size=0;
    }

    @Override
    public boolean contains(Object item) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> n = head;
            boolean isHeadListPrint = false;
            @Override
            public boolean hasNext() {
                return head!=null&&n.next!=null;
            }

            @Override
            public T next() {
                if(!isHeadListPrint) {
                    isHeadListPrint = true;
                    return n.data;
                }
                n = n.next;
                return n.data;
            }
        };
    }
    private static class Node<T>
    {
        T data;
        Node<T> next;
        Node<T> previous;
    }
}
