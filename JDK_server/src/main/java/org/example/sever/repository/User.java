package org.example.sever.repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class User {
    private final String login;
    private String password;
    private final LocalDate DOB; // дата рождения
    private long age;
    private final String tfPort;
    private final String ipPort;

//TODO: доделать класс и интегрировать в приложение
    public User(String login, String password, String tfPort, String ipPort) {
        this.login = login;
        this.password = password;
        this.DOB = LocalDate.of(1990,1,1);
        this.age = getAge();
        this.tfPort = tfPort;
        this.ipPort = ipPort;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public long getAge(){
        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(DOB, now);
    }

    @Override
    public String toString() {
        return String.format(
                        "\nName: %s" +
                        "\nDay of birth:%s" +
                        "\nAge:%s", getLogin(), DOB, age);
    }
}
