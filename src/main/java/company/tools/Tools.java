package main.java.company.tools;

import main.java.company.model.ScoreSheet;

public class Tools {
    public void printMainMenu() {
        System.out.println("\n1. 添加学生成绩\n" + "2. 生成成绩单\n" + "3. 退出\n" + "请输入你的选择（1~3）：");
    }

    public void promptInputStudentInfor(boolean inputErrorFlag) {
        if (inputErrorFlag) {
            System.out.println("\n请输入学生信息（格式：姓名，学号，学科：成绩，...），按回车提交：");
        } else {
            System.out.println("\n请按正确的格式输入（格式：姓名，学号，学科：成绩，...）：");
        }
    }

    public void promptInputStudentSequence(boolean inputErrorFlag) {
        if (inputErrorFlag) {
            System.out.println("\n请输入要打印的学生的学号（格式：学号，学号，...），按回车提交：");
        } else {
            System.out.println("\n请按正确的格式输入要打印的学生的学号（格式：学号，学号，...），按回车提交：");
        }
    }

    public void printScoreSheet(ScoreSheet scoreSheet) {
        System.out.println("\n成绩单");
        System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
        System.out.println("==================================");
        scoreSheet.getStudentList().forEach(System.out::println);
        System.out.println("==================================");
        System.out.println("全班总分平均数：" + scoreSheet.getAverage());
        System.out.println("全班总分中位数：" + scoreSheet.getMedian());
    }
}