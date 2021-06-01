import java.util.Iterator;

public class CircledList<E> extends LinkedListImpl<E> implements Iterable<E>{
    private final int size;
    public CircledList(int size)
   {
       this.size = size;
   }

    public int getSize() {
        return size;
    }

    @Override
    public void add(E item) {
        if(getSize()-1<size())
            return;
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, item, null);
        last = newNode;
        if (l == null)
            head = newNode;
        else {
            l.next = newNode;
            newNode.next = head;
        }
        super.size++;
    }

    @Override
    public void add(int index, E item) {
        if(getSize()>size())
            super.add(index, item);
    }

    @Override
    public void set(int index, E item) {
        super.set(index, item);
    }

    @Override
    public void remove(Object item) {
        super.remove(item);
    }

    @Override
    public void remove(int index) {
        super.remove(index);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public boolean contains(Object item) {
        return super.contains(item);
    }

    @Override
    public E get(int index) {
        return super.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> n = head;
            boolean isHeadListPrint = false;

            @Override
            public boolean hasNext() {
                return head != null && n.next != null && n.next!=head;
            }

            @Override
            public E next() {
                if (!isHeadListPrint) {
                    isHeadListPrint = true;
                    return n.data;
                }
                n = n.next;
                return n.data;
            }
        };
    }

    @Override
    void unlink(LinkedListImpl.Node<E> x) {
        super.unlink(x);
    }


}
