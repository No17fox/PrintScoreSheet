package main.java.company.service;

import main.java.company.model.ScoreSheet;
import main.java.company.model.Student;

import java.io.*;
import java.util.Arrays;

public class Service {

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
        if (!subjectAndScore[1].matches("^\\d*$")) {
            return false;
        }
        return Double.valueOf(subjectAndScore[1]) >= 0 && Double.valueOf(subjectAndScore[1]) <= 100;
    }

    public void writeToFile(String input, String path) {
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ScoreSheet readFromFile(String path) {
        File file = new File(path);
        ScoreSheet scoreSheet = new ScoreSheet();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (null != line) {
                Student student = this.parseLine(line);
                student.setAverage();
                student.setSum();
                scoreSheet.addAStudentToList(student);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scoreSheet;
    }

    private Student parseLine(String line) {
        String[] inforArray = line.split("[,，]");
        Student student = new Student(inforArray[0], Long.valueOf(inforArray[1]));
        Arrays.stream(inforArray).skip(2).forEach(item -> this.parseScores(student, item));
        return student;
    }

    private void parseScores(Student student, String item) {
        String subject = item.split("[:：]")[0];
        double score = Double.valueOf(item.split("[:：]")[1]);
        student.addScoreToScoreList(subject, score);
    }


}
