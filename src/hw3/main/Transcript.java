package hw3.main;

import hw3.util.Grade;

import java.util.ArrayList;

public class Transcript {
    private int studentID;
    private ArrayList<CourseGrade> courseGradeList;
    private double GPA;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.GPA = 0;
        this.courseGradeList = new ArrayList<>();
    }

    //calculation of GPA
    private double calculateGPA(int credit, Grade grade) {
        int averageGrade = 0;
        int totalCredit = 0;

        //check courseGrade in courseGradeList
        for (CourseGrade courseGrade : courseGradeList) {
            //add grade of one courseGrade fo averageGrade
            averageGrade += courseGrade.getCourseCredit() * courseGrade.getGradeTaken().getNumericValue();
            //add credit of one course to total
            totalCredit += courseGrade.getCourseCredit();
        }
        if (totalCredit == 0) {
            return 0.0;
        }
        //calculate average
        this.GPA = averageGrade / totalCredit;

        //round GPA calculation since it ends up in double
        return Math.round(GPA * 100.0) / 100.0;
    }

    //in order to add course to corseList
    public ArrayList addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade != null) {
            courseGradeList.add(courseGrade);
            //after adding GPA is updated with current list.
            calculateGPA(courseGrade.getCourseCredit(), courseGrade.getGradeTaken());
        }
        return courseGradeList;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public ArrayList<CourseGrade> getCourseGradeList() {
        return courseGradeList;
    }

    public void setCourseGradeList(ArrayList<CourseGrade> courseGradeList) {
        this.courseGradeList = courseGradeList;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    //used for to print courseGradeList step by step.
    private String printCourseGradeList() {
        StringBuilder result = new StringBuilder();
        for (CourseGrade courseGrade : courseGradeList) {
            result.append("Department: ").append(courseGrade.getCourseDepartment()).append(" Code: ").append(courseGrade.getCourseCode()).append(" Credit: ").append(courseGrade.getCourseCredit())
                    //takes from Grade enum.
                    .append(" Grade: ").append(courseGrade.getGradeTaken().printGrade()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\n" + printCourseGradeList() + "GPA=" + GPA;
    }
}
