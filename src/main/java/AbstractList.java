
public abstract class AbstractList<E> implements Iterable<E> {

    public abstract void add(E item);
    public abstract void add(int index, E item);
    public abstract void set(int index, E item);

    public abstract void remove(E item);
    public abstract void remove(int index);

    public abstract int size();
    public abstract void clear();

    public abstract boolean contains(E item);
    public abstract E get(int index);
}
