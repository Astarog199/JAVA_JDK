package Ex002;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table implements Iterable<Fork> {
    List<Fork> table;

    public Table() {
        this.table = new ArrayList<>();
    }

    public Fork get(int index) {
        return table.get(index);
    }

    public void add(Fork obj) {
        table.add(obj);
    }

    @Override
    public Iterator<Fork> iterator() {
        return new TableIterator<>(table);
    }
}
