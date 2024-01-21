package org.directory;

import java.util.Iterator;
import java.util.List;

public class DirectoryIterator  implements Iterator<Worker> {

    List<Worker> dir;
    int index;

    public DirectoryIterator (List<Worker> dir) {
        this.dir = dir;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index< dir.size();
    }

    @Override
    public Worker next() {
        return dir.get(index++);
    }
}
