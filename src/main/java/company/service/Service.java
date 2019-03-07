package main.java.company.service;

import main.java.company.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean verifyInputStudentInfor(String studentInfor) {
        if (null == studentInfor) {
            return false;
        }
        String[] inforArray = studentInfor.split("[,，]");
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

    public void writeToFile(String input, String filePath) {
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Student> readFromFile(String filePath) {
        File file = new File(filePath);
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (null != line) {
                Student student = this.parseLine(line);
                student.setAverage();
                student.setSum();
                studentList.add(student);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    private Student parseLine(String studentInfor) {
        String[] inforArray = studentInfor.split("[,，]");
        Student student = new Student(inforArray[0], Long.valueOf(inforArray[1]));
        Arrays.stream(inforArray).skip(2).forEach(item -> this.parseScores(student, item));
        return student;
    }

    private void parseScores(Student student, String inputScore) {
        String subject = inputScore.split("[:：]")[0];
        double score = Double.valueOf(inputScore.split("[:：]")[1]);
        student.addScoreToScoreList(subject, score);
    }

    public boolean verifyInputStudentSequence(String studentSequence) {
        if (null == studentSequence) {
            return false;
        }
        String[] studentArray = studentSequence.split("[,，]");
        return Arrays.stream(studentArray).allMatch(id -> id.matches("^\\d*$"));
    }

    private List<Long> parseStudentSequence(String studentSequence) {
        return Arrays.stream(studentSequence.split("[,，]"))
                .distinct()
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    public List<Student> getSelectedStudentInfor(String path, String studentSequence) {
        return this.readFromFile(path)
                .stream()
                .filter(student -> this.parseStudentSequence(studentSequence).contains(student.getId()))
                .collect(Collectors.toList());
    }

    public boolean verifyInputSelection(String selection) {
        return selection.matches("[123]");
    }
}
