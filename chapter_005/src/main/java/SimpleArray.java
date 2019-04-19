import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {

private Object[] mass;
private int pos = 0 ;
    public SimpleArray(int size){
        mass = new Object[size];
    }

    public void add(T value){
    mass[pos++] = value;
    }
    public void set(int index, T value){
        mass[index] = value;
    }
    public Object get(int index){
        return mass[index];
    }
    public void remove(int index){
        for(int i=index+1;i<mass.length;i++){
            mass[i] = mass[i-1];
        }
    }
    public Iterator<T> iterator(){
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return !(mass[index+1] == null);
            }

            @Override
            public T next() {
                return (T) mass[index++];
            }
        };
    }
}
