package org.example.sever.repository;

import org.example.client.Client;

public interface Repository {
    void logWrite(String str);
    void readLog(Client user);
}
