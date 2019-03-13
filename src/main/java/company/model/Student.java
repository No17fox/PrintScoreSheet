package main.java.company.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    private final String name;
    private final long id;
    private Map<String, Double> scoreList;
    private double average;
    private double sum;

    public Student(String name, long id) {
        this.name = name;
        this.id = id;
        this.scoreList = new HashMap<>();
    }

    public long getId() {
        return this.id;
    }

    public void addScoreToScoreList(String subject, double score) {
        this.scoreList.put(subject, score);
    }

    public void setAverage() {
        this.average = this.scoreList.values()
                .stream()
                .collect(Collectors.averagingDouble(Double::valueOf));
    }

    public double getSum() {
        return this.sum;
    }

    public void setSum() {
        this.sum = this.scoreList.values()
                .stream()
                .mapToDouble(Double::valueOf)
                .sum();
    }

    @Override
    public String toString() {
        double math = Optional.ofNullable(this.scoreList.get("数学")).orElse(0.0);
        double chinese = Optional.ofNullable(this.scoreList.get("语文")).orElse(0.0);
        double english = Optional.ofNullable(this.scoreList.get("英语")).orElse(0.0);
        double programming = Optional.ofNullable(this.scoreList.get("编程")).orElse(0.0);
        List<String> scoresInfor = Stream.of(this.name, math, chinese, english, programming, this.average, this.sum)
                .map(Object::toString)
                .collect(Collectors.toList());
        return String.join("|", scoresInfor);
    }

    @Override
    public boolean equals(Object student) {
        return student instanceof Student && this.id == ((Student) student).getId();
    }

    @Override
    public int hashCode() {
        return (int) this.id;
    }
}
