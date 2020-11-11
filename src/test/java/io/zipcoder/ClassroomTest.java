package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {
    @Test
    public void nullConstructorTest(){
        //Given
        Classroom newClassroom = new Classroom();
        Student[] expectedStudentsArr = new Student[30];

        //When
        Student[] actualStudentArr = newClassroom.getStudents();

        //Then
        Assert.assertEquals(expectedStudentsArr,actualStudentArr);
    }

    @Test
    public void studentConstructorTest(){
        //Given
        Student student1 = new Student("Zekai", "He", new Double[0]);
        Student student2 = new Student("Prince", "He", new Double[0]);
        Student[] expectedStudentsArr = {student1,student2};

        //When
        Classroom newClassroom = new Classroom(expectedStudentsArr);
        Student[] actualStudentArr = newClassroom.getStudents();

        //Then
        Assert.assertEquals(expectedStudentsArr,actualStudentArr);
    }

    @Test
    public void maxConstructorTest(){
        //Given
        Student[] expectedStudentsArr = new Student[10];

        //When
        Classroom newClassroom = new Classroom(10);
        Student[] actualStudentArr = newClassroom.getStudents();

        //Then
        Assert.assertEquals(expectedStudentsArr,actualStudentArr);
    }

    @Test
    public void getAvgExamTest(){
        //Given
        Double[] student1Exams = {100.0, 90.0, 80.0};
        Double[] student2Exams = {100.0, 100.0, 60.0};
        Student student1 = new Student("Zekai", "He", student1Exams);
        Student student2 = new Student("Prince", "He", student2Exams);
        Student[] expectedStudentsArr = {student1,student2};
        Double expectedAvg = (100.0+90.0+80.0+100.0+100.0+60.0)/6.0;

        //When
        Classroom newClassroom = new Classroom(expectedStudentsArr);
        Double actualAvg = newClassroom.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAvg ,actualAvg,0.0001);
    }

    @Test
    public void removeStudentTest(){
        //Given
        Double[] student1Exams = {100.0, 90.0, 80.0};
        Double[] student2Exams = {100.0, 100.0, 60.0};
        Student student0 = new Student(null, null, new Double[0]);
        Student student1 = new Student("Zekai", "He", student1Exams);
        Student student2 = new Student("Prince", "He", student2Exams);
        Student[] StudentsArr = {student0,student1,student2};
        Student[] expectedStudentsArr = {student2, student0, student1};
        //When
        Classroom newClassroom = new Classroom(StudentsArr);
        newClassroom.removeStudent("Zekai", "He");
        Student[] actualStudentArr = newClassroom.getStudents();

        //Then
        Assert.assertEquals(expectedStudentsArr ,actualStudentArr);
    }

    @Test
    public void sortStudentExamsTest(){
        //Given
        Double[] student1Exams = {100.0, 90.0, 80.0}; //average 90
        Double[] student2Exams = {100.0, 100.0, 60.0}; //average 86.7
        Double[] student3Exams = {95.0, 90.0, 81.0}; //average 88.7
        Double[] student4Exams = {70.0, 50.0, 100.0}; //73.3
        Double[] student5Exams = {100.0, 80.0, 90.0}; //90
        Student student1 = new Student("Zekai", "He", student1Exams);
        Student student2 = new Student("Jenny", "He", student2Exams);
        Student student3 = new Student("Brian", "Ly", student3Exams);
        Student student4 = new Student("Roger", "Chheng", student4Exams);
        Student student5 = new Student("Sandy", "He", student5Exams);
        Student[] StudentsArr = {student1,student2,student3,student4,student5};
        Student[] expectedSortedArr = {student5, student1, student3, student2, student4};

        //When
        Classroom newClassroom = new Classroom(StudentsArr);
        Student[] actualSortedArr = newClassroom.getStudentsByScore();

        //Then
        Assert.assertEquals(expectedSortedArr ,actualSortedArr);
    }

    @Test
    public void getGradeBookTest(){
        //Given
        Double[] student1Exams = {100.0, 90.0, 80.0}; //average 90
        Double[] student2Exams = {90.0, 85.0, 80.0}; //average 85
        Double[] student3Exams = {95.0, 90.0, 81.0}; //average 88.7
        Double[] student4Exams = {70.0, 50.0, 100.0}; //average 73.3
        Double[] student5Exams = {30.0, 20.0, 40.0}; //average 30.0
        Student student1 = new Student("Zekai", "He", student1Exams);
        Student student2 = new Student("Jenny", "He", student2Exams);
        Student student3 = new Student("Brian", "Ly", student3Exams);
        Student student4 = new Student("Roger", "Chheng", student4Exams);
        Student student5 = new Student("Sandy", "He", student5Exams);
        Student[] StudentsArr = {student1,student2,student3,student4,student5};
        String expectedGrade = "A";
        //When
        Classroom newClassroom = new Classroom(StudentsArr);
        String actualGrade = newClassroom.getGradeBook().get(student1);

        //Then
        Assert.assertEquals(expectedGrade ,actualGrade);
    }



}
