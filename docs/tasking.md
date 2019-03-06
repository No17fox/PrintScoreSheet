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
      List<Student> students;
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
      String verifyInput() {}
      void writeToFile() {}
      void readFromFile() {}
      Student[] parseFile() {}
  }
  ```

- class Tools

  ```java
  class Tools {
      void printMainMenu() {}
      void promptInputStudentInfor() {}
      void promptInputStudentSequence() {}
      void printScoreSheet(ScoreSheet scoreSheet) {}
  }
  ```

  