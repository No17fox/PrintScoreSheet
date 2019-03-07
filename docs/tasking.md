# Tasking

- class Student

  ```java
  class Student {
      String name;
      long id;
      Map<String, Double> scoreList;
      double average;
      double sum;
  }
  ```

- class ScoreSheet

  ```java
  class ScoreSheet {
      List<Student> studentList;
      double average;
      double median;
      
      double calculateAverage() {}
      double calculateMedian() {}
  }
  ```

- class Service

  ```java
  class Service {
      String readInput() {}
      boolean verifyInputStudentInfor(String input) {}
      boolean verifyInputStudentSequence(String input) {}
      void writeToFile(String input, String path) {}
      void readFromFile() {}
      Student parseLine() {}
  }
  ```

- class Tools

  ```java
  class Tools {
      void printMainMenu(boolean inputErrorFlag) {}
      void promptInputStudentInfor(boolean inputErrorFlag) {}
      void promptInputStudentSequence(boolean inpustErrorFlag) {}
      void printScoreSheet(ScoreSheet scoreSheet) {}
  }
  ```

  