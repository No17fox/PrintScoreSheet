package main.java.company.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Service {
    public String readInput() {
        String input = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
