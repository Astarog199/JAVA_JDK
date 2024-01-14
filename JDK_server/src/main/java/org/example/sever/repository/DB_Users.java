package org.example.sever.repository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DB_Users <T extends User> implements Iterable <T>{

    List<T> dbListUsers;

    public DB_Users(){
        this.dbListUsers = new ArrayList<>();
    }

    public List<T> getDbListUsers() {
        return dbListUsers;
    }

    //TODO: добавить кнопку на панель сервера с запросом статуса пользователей пользователей
    public void usersConnect(JTextArea log){
        for (User u: dbListUsers){
            log.append( String.format("Пользователь: %s подключился к серверу. \n", u.getLogin()));

        }
    }

    public void add(T User){
        dbListUsers.add(User);
    }
    public void remove(T User){
        dbListUsers.remove(User);
    }


    @Override
    public Iterator<T> iterator() {
        return new IteratorDB<T>(dbListUsers);
    }
}
