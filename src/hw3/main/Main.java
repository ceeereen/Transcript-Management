package hw3.main;

import hw3.util.Grade;

public class Main {

    public static void main(String[] args) {
        CourseGrade courseGrade1 = new CourseGrade("ECE", 23, 4, Grade.C);
        CourseGrade courseGrade = new CourseGrade("DD", 236, 3, 1.0);

        Transcript transcript = new Transcript(1);
        Transcript transcript1 = new Transcript(2);
        transcript.addCourseTaken(courseGrade);
        transcript.addCourseTaken(courseGrade1);
        transcript1.addCourseTaken(courseGrade1);
        System.out.println(transcript);
        System.out.println(transcript1);
    }
}
