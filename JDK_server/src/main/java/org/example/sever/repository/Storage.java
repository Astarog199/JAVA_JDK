package org.example.sever.repository;

import org.example.client.Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Storage implements Repository{
    public static final String LOG_PATH = "JDK_server/src/main/java/org/example/sever/repository/log.tht";

    public void logWrite(String str) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(str);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void readLog(Client user){
        try(FileReader reader = new FileReader(LOG_PATH)) {
            BufferedReader r = new BufferedReader(reader);
            String line;
            while ((line =r.readLine())!= null){
                user.serverAnswer(line + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
