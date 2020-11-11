package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student{
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Integer getNumberOfExams(){
        return examScores.size();
    }

    public String getExamScores() {
        String examScoresOutput = "Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++) {
            examScoresOutput += String.format("\tExam %d -> %3.0f\n", i+1, examScores.get(i));
        }
        return examScoresOutput;
    }

    public void addExamScore(double newExam){
        examScores.add(newExam);
    }

    public void setExamScore(int examIndex, double newScore){
        examScores.set(examIndex, newScore);
    }

    public Double getAverageExamScore(){
        Double totalScore = 0.0;
        for(Double x: examScores){
            totalScore += x;
        }
        return totalScore/examScores.size();
    }

    @Override
    public String toString(){
        String output = String.format("Student Name: %s %s\n> Average Score: %3.1f\n",getFirstName(),getLastName(),getAverageExamScore())+"> "+getExamScores();
        return output;
    }

}
