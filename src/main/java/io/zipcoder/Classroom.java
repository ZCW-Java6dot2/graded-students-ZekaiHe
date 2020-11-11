package io.zipcoder;
import java.util.*;

public class Classroom{
    Student [] students;

    public Classroom(int maxNumberOfStudents){
        students = new Student[maxNumberOfStudents];
    }

    public Classroom (Student[] student){
        students = student;
    }

    public Classroom(){
        students = new Student[30];
    }

    public Student[] getStudents(){
        return students;
    }

    public Double getAverageExamScore(){
        Double totalStudentScore = 0.0;
        for (int i = 0; i<students.length; i++){
            totalStudentScore += students[i].getAverageExamScore();
        }
        return totalStudentScore/students.length;
    }

    public void addStudent(Student student){
        for (int i = 0; i<students.length; i++){
            if(students[i]==null){
                students[i] = student;
                break;
            }
            else {
                System.out.println("Classroom is full");
            }
        }
    }

    public void removeStudent(String firstName, String lastName){
        for (int i = 0; i<students.length; i++){
            if(students[i].getFirstName() == firstName && students[i].getLastName() == lastName){
                    students[i].setFirstName(null);
                    students[i].setLastName(null);
                    for (int j = 0; j< students[i].getNumberOfExams();j++) {
                        students[i].setExamScore(j,0);
                    }
                    break;
                }
            }
        List<Student> studentList = Arrays.asList(students);
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getFirstName() == null && s2.getFirstName() == null){
                    return 0;
                }
                if(s1.getFirstName() == null){
                    return 1;
                }
                if(s2.getFirstName()==null){
                    return -1;
                }
                return s1.getFirstName().compareTo(s2.getFirstName());
            }
        });

    }

    public Student[] getStudentsByScore(){
        List<Student> studentList = new ArrayList<>(Arrays.asList(getStudents()));
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int result = s2.getAverageExamScore().compareTo(s1.getAverageExamScore());
                if(result == 0){
                    result = s1.getFirstName().compareTo(s2.getFirstName());
                }
                return result;
            }
        });

        return studentList.toArray(new Student[studentList.size()]);
    }

    public Map<Student, String> getGradeBook(){
        Student[] sortedArr = this.getStudentsByScore();
        Integer numOfStudents = sortedArr.length;
        HashMap<Student, String> gradedBook = new HashMap<Student, String>();
        for(int i = 0; i< numOfStudents;i++){
            if(i<=(int)(0.10*numOfStudents)){
                gradedBook.put(sortedArr[i],"A");
            }
            else if(i>=(int)(0.11*numOfStudents) && i<=(int)(0.29*numOfStudents)){
                gradedBook.put(sortedArr[i],"B");
            }
            else if(i>=(int)(0.30*numOfStudents) && i<=(int)(0.50*numOfStudents)){
                gradedBook.put(sortedArr[i],"C");
            }
            else if(i>=(int)(0.51*numOfStudents) && i<=(int)(0.89*numOfStudents)) {
                gradedBook.put(sortedArr[i],"D");
            }
            else{
                gradedBook.put(sortedArr[i],"F");
            }
        }
        return gradedBook;
    }

}
