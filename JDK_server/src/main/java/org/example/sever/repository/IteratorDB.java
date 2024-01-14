package org.example.sever.repository;

import java.util.Iterator;
import java.util.List;

public class IteratorDB <T> implements Iterator<T> {

    List<T> dbListUsers;

    int index;

    public IteratorDB(List<T> dbListUsers) {
        this.dbListUsers = dbListUsers;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        return index<dbListUsers.size();
    }

    @Override
    public T next() {
        return dbListUsers.get(index++);
    }
}
