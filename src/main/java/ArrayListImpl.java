import java.util.Iterator;

public class ArrayListImpl<T> extends AbstractList<T>  {
    private final int defaultSize = 4;
    private Object[] array;
    private int size = 0;
    private int currentSize = 0;

    public ArrayListImpl()
    {
        array = new Object[defaultSize];
    }
    public ArrayListImpl(int size)
    {
        if (size>0)
            array = new Object[size];
        else
            array = new Object[defaultSize];
    }

    @Override
    public void add(T item) {
        if (size == array.length-1)
            resize(array.length*2);
        array[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        while (index>array.length-1) {
            resize(array.length * 2);
        }
        array[index] = item;
        size++;
    }

    @Override
    public void set(int index, T item) {
        if(index<array.length)
            array[index] = item;
    }

    @Override
    public void remove(Object item) {
        if (item == null) {
            for (int index = 0; index < size; index++)
                if (array[index] == null) {
                    fastRemove(index);
                }
        } else {
            for (int index = 0; index < size; index++)
                if (item.equals(array[index])) {
                    fastRemove(index);
                }
        }

    }

    @Override
    public void remove(int index) {
        if (size - index >= 0) {
            fastRemove(index);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i <size ; i++) {
            array[i] = null;
        }
        size=0;
    }

    @Override
    public boolean contains(Object item) {
        for (Object t: array) {
            if(item.equals(t))
                return true;
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(array.length>index)
            return (T)array[index];
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return currentSize<size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) array[currentSize++];
            }
        };
    }
    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        array[--size] = null;
    }
    private void resize(int newSize)
    {
        Object[] newArray = new Object[newSize];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;
    }
}
