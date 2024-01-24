package Ex002;

import java.util.Iterator;
import java.util.List;

public class TableIterator <T> implements Iterator<T> {
    List <T> table;
    int index;

    public TableIterator (List <T> table){
        this.table = table;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index<table.size();
    }

    @Override
    public T next() {
        return table.get(index++);
    }
}
