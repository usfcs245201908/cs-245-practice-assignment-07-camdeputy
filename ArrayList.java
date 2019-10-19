import java.util.Arrays;

public class ArrayList<T> implements List {

    protected Object[] a;
    protected int size;

    public ArrayList() {
        this.a = new Object[10];
        this.size = 0; //size of the arrayList will grow as items are added.
    }


    @Override
    public void add(Object item) {
        if(this.size == a.length)
            grow_array();
        a[size++] = item;
    }

    @Override
    public void add(int pos, Object item) {
        if(pos < 0 || pos > size)
            throw new ArrayIndexOutOfBoundsException("Position does not exist in array");
        if(this.size == a.length)
            grow_array();
        Object[] temp = Arrays.copyOfRange(a, pos, a.length-1);
        int k = 0;
        a[pos] = item;
        for(int i = pos+1; i < a.length-1; i++)
            a[i] = temp[k++];
        ++size;
    }

    @Override
    public Object get(int pos) {
        if(pos < 0 || pos > size)
            throw new ArrayIndexOutOfBoundsException("Position does not exist in array");
        return a[pos];
    }

    @Override
    public Object remove(int pos) {
        if(pos < 0 || pos > size)
            throw new ArrayIndexOutOfBoundsException("Position does not exist in array");
        Object temp = a[pos];
        for(int i=pos;i<size-pos-1;i++) {
            a[i]=a[i+1];
        }
        --size;
        return temp;
    }

    @Override
    public int size() {
        return this.size;
    }

    void grow_array() {
        Object[] copy = Arrays.copyOfRange(a, 0, a.length*2);
        a = copy;
    }
}
