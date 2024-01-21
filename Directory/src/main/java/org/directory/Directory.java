package org.directory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри
коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
 */
public class Directory implements Iterable<Worker>{
    List<Worker> dir;

    public Directory () {
        this.dir = new ArrayList<>();
    }

    @Override
    public Iterator<Worker> iterator() {
        return new DirectoryIterator(dir);
    }

    public List<Worker> getDir() {
        return dir;
    }
    public void getWorker(){
        for (Worker worker : dir){
            System.out.println(worker);
        }
    }

    public String getWorkerForName(int phone){
        String result = "";
        for (Worker worker : dir){
            if(worker.getPhone() == phone)  result = worker.getName();
            else result = "Поиск не дал результатов";
        }
        return result;
    }

    public Worker getWorkerForExperience(int minExp, int maxExp){
        Worker result = null;
        for(Worker worker: dir){
            long exp = worker.getExperience();
            if (exp>minExp && exp<maxExp){
                result = worker;
            }
        }
        return result;
    }

    public Worker getWorkerForPersonNumber(int num){
        Worker result = null;
        for(Worker worker : dir){
           if (worker.getPersonNumber() == num){
               result =worker;
           }
        }
        return result;
    }

    public void add(Worker worker){
        int num =  dir.size();
        worker.setPersonNumber(num+1);
        dir.add(worker);
    }

}
