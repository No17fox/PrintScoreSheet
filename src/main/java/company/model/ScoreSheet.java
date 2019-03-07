package main.java.company.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreSheet {
    private List<Student> studentList;
    private double average;
    private double median;

    public ScoreSheet() {
        this.studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void addAStudentToList(Student student) {
        this.studentList.add(student);
    }

    public double getAverage() {
        return this.average;
    }

    public void setAverage() {
        this.average = this.studentList.stream().collect(Collectors.averagingDouble(Student::getSum));
    }

    public double getMedian() {
        return this.median;
    }

    public void setMedian() {
        List<Double> sortedList = this.studentList.stream().map(Student::getSum).sorted().collect(Collectors.toList());
        int medianIndex = sortedList.size() / 2;
        if (0 == sortedList.size() % 2) {
            this.median = (sortedList.get(medianIndex) + sortedList.get(medianIndex - 1)) / 2.0;
        } else {
            this.median = sortedList.get(medianIndex);
        }
    }
}
