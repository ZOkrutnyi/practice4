import java.util.Iterator;
import java.util.Objects;

public class LinkedListImpl<E> extends AbstractList<E> {
    protected Node<E> head;
    protected Node<E> last;
    private int size;

    @Override
    public void add(E item) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, item, null);
        last = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 && index > size)
            return;
        if (index == size)
            add(item);
        else {
            linkBefore(item, Objects.requireNonNull(getNode(index)));
        }

    }

    private Node<E> getNode(int index) {
        int itr = 0;
        for (Node<E> n = head; n != null; n = n.next, itr++) {
            if (itr == index)
                return n;
        }
        return null;
    }

    private void linkBefore(E e, Node<E> bef) {
        final Node<E> prev = bef.prev;
        final Node<E> newNode = new Node<>(prev, e, bef);
        bef.prev = newNode;
        if (prev == null)
            head = newNode;
        else
            prev.next = newNode;
        size++;
    }

    @Override
    public void set(int index, E item) {
        int itr = 0;
        for (Node<E> n = head; n != null; n = n.next, itr++) {
            if (itr == index) {
                n.data = item;
                return;
            }
        }
    }

    @Override
    public void remove(Object item) {
        if (item == null) {
            for (Node<E> n = head; n != null; n = n.next) {
                if (n.data == null) {
                    unlink(n);
                    return;
                }
            }
        } else {
            for (Node<E> n = head; n != null; n = n.next) {
                if (item.equals(n.data)) {
                    unlink(n);
                    return;
                }
            }
        }
    }

    @Override
    public void remove(int index) {
        int i = 0;
        for (Node<E> n = head; n != null; n = n.next) {
            if (i == index) {
                unlink(n);
                size--;
                return;
            }
            i++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(Object item) {
        if (item == null) {
            for (Node<E> n = head; n != null; n = n.next) {
                if (n.data == null)
                    return true;
            }
        } else
            for (Node<E> n = head; n != null; n = n.next) {
                if (n.data == item)
                    return true;
            }
        return false;
    }

    @Override
    public E get(int index) {
        int itr = 0;
        if (index < 0 && index > size)
            return null;
        for (Node<E> n = head; n != null; n = n.next, itr++) {
            if (itr == index)
                return n.data;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> n = head;
            boolean isHeadListPrint = false;

            @Override
            public boolean hasNext() {
                return head != null && n.next != null;
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

    void unlink(Node<E> x) {
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        size--;
    }

    protected static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.data = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
