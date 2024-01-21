package org.directory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Табельный номер
// Номер телефона
// Имя
// Стаж
public class Worker {
    private int personNumber;
    private String name;
    private int phone;
    private final LocalDate dateEmployment;
    private long experience;

    Worker(String name, int phone, LocalDate dateEmployment){
        this.name = name;
        this.phone = phone;
        this.dateEmployment = dateEmployment;
        this.experience = getExperience();
        this.personNumber = getPersonNumber();
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    protected void setPersonNumber(int num){
        this.personNumber =  num;
    }

    public int getPersonNumber() {
        return personNumber;
    }


    public LocalDate getDateEmployment() {
        return dateEmployment;
    }

    public long getExperience() {
        LocalDate now = LocalDate.now();
        experience = ChronoUnit.YEARS.between(dateEmployment, now);
        return experience;
    }


    @Override
    public String toString() {
        return String.format("#%s, name: %s, phone: %s, experience: %s YEARS \n", personNumber, name, phone, experience);
    }
}
