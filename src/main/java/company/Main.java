package main.java.company;

import main.java.company.service.Service;
import main.java.company.tools.Tools;

public class Main {

    public static void main(String[] args) {
        Tools tools = new Tools();
        Service service = new Service();

        tools.printMainMenu();
        boolean verifyResult = true;
        do {
            tools.promptInputStudentInfor(verifyResult);
            String input = service.readInput();
            verifyResult = service.verifyInput(input);
        } while (!verifyResult);


    }
}
