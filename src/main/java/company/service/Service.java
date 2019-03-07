package main.java.company.service;

import main.java.company.tools.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Service {
    private Tools tools = new Tools();

    public String readInput() {
        String input = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public boolean verifyInput(String input) {
        if (null == input) {
            return false;
        }
        String[] inforArray = input.split("[,，]");
        if (inforArray.length < 6) {
            return false;
        }
        if (!inforArray[1].matches("^\\d*$")) {
            return false;
        }
        return Arrays.stream(inforArray)
                .skip(2)
                .allMatch(this::verifyInputScores);
    }

    private boolean verifyInputScores(String score) {
        String[] subjectAndScore = score.split("[:：]");
        if (2 != subjectAndScore.length) {
            return false;
        }
        if (null == subjectAndScore[0]) {
            return false;
        }
        return subjectAndScore[1].matches("^\\d*$");
    }


}
