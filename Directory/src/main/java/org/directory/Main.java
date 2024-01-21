package org.directory;

import java.time.LocalDate;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
       Random r = new Random();
       Directory dir = new Directory();

       for (int i=1; i<=5; i++){
           String name = "name" + i;
           int phone = r.nextInt(1000, 9999);
           LocalDate dateEmployment = LocalDate.of(r.nextInt(2000,2024), r.nextInt(1, 12), 10);
           dir.add(new Worker(name, phone, dateEmployment));
       }
       dir.add(new Worker("Bob", 6845, LocalDate.of(2022, 10, 11))); // Добавление нового сотрудника

       dir.getWorker(); //получить список сотрудников
       System.out.println("получить имя сотрудника по номеру телефона: \n"   + dir.getWorkerForName(6845));
       System.out.println("Получить сотрудника по персональному номеру: \n"  + dir.getWorkerForPersonNumber(2));;
       System.out.println("Получить сотрудника по опыту работы: \n" + dir.getWorkerForExperience(5, 10));


    }
}