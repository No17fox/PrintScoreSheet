package main.java.company;

import main.java.company.service.Service;

public class Main {
    private static final String PATH = "./docs/students_infor.txt";

    public static void main(String[] args) {
        Service service = new Service();
        service.startMainService(PATH);
    }
}
