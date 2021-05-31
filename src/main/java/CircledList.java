import java.util.Iterator;
import java.util.function.Consumer;

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
        if(getSize()>size())
            super.add(item);
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
        return super.iterator();
    }

    @Override
    void unlink(LinkedListImpl.Node<E> x) {
        super.unlink(x);
    }


}
