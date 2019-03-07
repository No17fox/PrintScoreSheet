package main.java.company;

import main.java.company.service.Service;
import main.java.company.tools.Tools;

public class Main {

    public static void main(String[] args) {
        Tools tools = new Tools();
        Service service = new Service();

        tools.printMainMenu();
        boolean verifyResult = true;
        String input;
        do {
            tools.promptInputStudentInfor(verifyResult);
            input = service.readInput();
            verifyResult = service.verifyInput(input);
        } while (!verifyResult);

        final String PATH = "./docs/students_infor.txt";
        service.writeToFile(input + "\n", PATH);


    }
}
