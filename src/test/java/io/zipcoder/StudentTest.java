package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test //Tests getFirstName, getLastName, getExamScores
    public void studentTest(){
        //Given
        String expectedFirstName = "Zekai";
        String expectedLastName = "He";
        Double[] expectedExamScores = {100.0, 85.0};
        String expectedExamScoresString = "Exam Scores:\n\tExam 1 -> 100\n\tExam 2 ->  85\n";

        //When
        Student newStudent = new Student (expectedFirstName, expectedLastName,expectedExamScores);
        String actualFirstName = newStudent.getFirstName();
        String actualLastName = newStudent.getLastName();
        String actualExamScores = newStudent.getExamScores();

        //Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedExamScoresString, actualExamScores);
    }

    @Test //Tests setFirstName
    public void setFirstNameTest() {
        //Given
        String expectedFirstName = "Zekai";

        //When
        Student newStudent = new Student("","",new Double[1]);
        newStudent.setFirstName(expectedFirstName);
        String actualFirstName = newStudent.getFirstName();

        //Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
    }

    @Test //Tests setLastName
    public void setLastNameTest() {
        //Given
        String expectedLastName = "He";

        //When
        Student newStudent = new Student("", "", new Double[1]);
        newStudent.setLastName(expectedLastName);
        String actualLastName = newStudent.getLastName();

        //Then
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test //Tests getNumberOfExams
    public void getNumOfExamsTest(){
        //Given
        Integer expectedNumExams = 5;
        Double[] expectedExams = {100.0, 95.0, 93.0, 85.0, 100.0};

        //When
        Student newStudent = new Student("", "", expectedExams);
        Integer actualNumExams = newStudent.getNumberOfExams();

        //Then
        Assert.assertEquals(expectedNumExams, actualNumExams);
    }

    @Test //Tests addExamScore
    public void addExamTest(){
        //Given
        Double expectedExam = 100.0;
        String expectedString = "Exam Scores:\n\tExam 1 -> 100\n";

        //When
        Student newStudent = new Student("", "", new Double[0]);
        newStudent.addExamScore(expectedExam);
        String actualExamScores = newStudent.getExamScores();

        //Then
        Assert.assertEquals(expectedString,actualExamScores);
    }

    @Test //Tests getAverageExamScore
    public void getAvgExamTest(){
        //Given
        Double [] exams = {100.0, 90.0, 75.0, 100.0};
        Double expectedAvg = (100.0+90.0+75.0+100.0)/4.0;
        //When
        Student newStudent = new Student("", "", exams);
        Double actualAvg = newStudent.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAvg, actualAvg);
    }

    @Test //test getString
    public void getStringTest(){
        //Given
        String expectedFirstName = "Zekai";
        String expectedLastName = "He";
        Double[] expectedExamScores = {100.0, 90.0};
        String expectedReport = "Student Name: Zekai He\n> Average Score: 95.0\n> Exam Scores:\n\tExam 1 -> 100\n\tExam 2 ->  90\n";

        //When
        Student newStudent = new Student (expectedFirstName, expectedLastName,expectedExamScores);
        String actualReport = newStudent.toString();

        //Then
        Assert.assertEquals(expectedReport, actualReport);
    }
}