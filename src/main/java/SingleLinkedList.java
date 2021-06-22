import java.util.Iterator;

public class SingleLinkedList<E> extends LinkedListImpl<E> {
    Node<E> head;
    @Override
    public void add(E item) {
        Node<E> node = new Node<>(item,null);
        if(head==null)
        {
            head = node;
        } else {
            Node<E> n = head;
            while (n.next!=null)
            {
                n = n.next;
            }
            n.next = node;
        }
        size++;

    }

    @Override
    public void add(int index, E item) {
        if (index < 0 && index > size)
            return;
        if (index == size)
            add(item);
        else {
            Node<E> n = head;
            for(int i = 0;i<size;i++)
            {
                if(i==index) {
                    n.next = new Node<>(item, n.next.next);
                    return;
                }
                n = n.next;
            }

        }

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
        Node<E> node = head;
        if(head.data.equals(item)) {
            head = head.next;
            size--;
            return;
        }
        if(item==null) {
            while (node.next != null) {
                if(node.next.data==null) {
                    node.next = node.next.next;
                    size--;
                    return;
                }
                node=node.next;
            }
            return;
        }
        while (node.next!=null)
        {
            if(node.next.data==null)
            {
                node = node.next;
                continue;
            } else
            if(node.next.data.equals(item)) {
                node.next.data = null;
                node.next = node.next.next;
                size--;
                return;
            }
            node = node.next;
        }
    }

    @Override
    public void remove(int index) {
        int i = 0;
        for (Node<E> n = head; n != null; n = n.next,i++) {
            if (i == index) {
                remove(n);
                size--;
                return;
            }
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

    protected static class Node<E> {
        E data;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.data = element;
            this.next = next;
        }
    }
}
