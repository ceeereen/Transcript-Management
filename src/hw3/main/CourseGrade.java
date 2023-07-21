package hw3.main;

import hw3.util.Grade;

import java.util.ArrayList;

public class CourseGrade {
    String courseDepartment;
    int courseCode;
    int courseCredit;
    Grade gradeTaken;

    public CourseGrade(String courseDepartment) {
        setCourseDepartment(courseDepartment);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);

    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
    }

    // gradeTaken is typed as double and setGradeTaken(double) called.
    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, double gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    // gradeTaken is typed as Grade and setGradeTaken(Grade) called.
    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }


    //this method checks if courseDepartment is in courseDepartmentList
    public boolean checkCourseDepartment(String courseDepartment) {
        //values that courseDepartment can take
        ArrayList<String> courseDepartmentList = new ArrayList<>() {{
            add("CENG");
            add("COMP");
            add("ECE");
            add("ME");
            add("MATH");
        }};

        if (courseDepartmentList.contains(courseDepartment)) {
            return true;
        } else {
            return false;
        }
    }

    //checks if courseCode is in correct range or not.
    public boolean checkCourseCode(int courseCode) {
        if (courseCode > 100 && courseCode < 600) {
            return true;
        } else {
            return false;
        }
    }

    //checks if courseCredit is taken correct value
    public boolean checkCourseCredit(int courseCredit) {
        if (courseCredit == 3 || courseCredit == 4) {
            return true;
        } else {
            return false;
        }
    }


    public void setCourseDepartment(String courseDepartment) {
        if (checkCourseDepartment(courseDepartment)) {
            this.courseDepartment = courseDepartment;
            //defaul value
        } else {
            this.courseDepartment = "CENG";
        }
    }

    public void setCourseCode(int courseCode) {
        if (checkCourseCode(courseCode)) {
            this.courseCode = courseCode;
            //default value
        } else {
            this.courseCode = 100;
        }
    }

    public void setCourseCredit(int courseCredit) {
        if (checkCourseCredit(courseCredit)) {
            this.courseCredit = courseCredit;
            //default value
        } else {
            this.courseCredit = 4;
        }
    }

    //gradeTaken is in type of Grade
    public void setGradeTaken(Grade gradeTaken) {
        //default.
        if (gradeTaken == null) {
            this.gradeTaken = Grade.F;

        } else {
            this.gradeTaken = gradeTaken;
        }
    }

    //gradeTaken is in type of double
    public void setGradeTaken(double val) {
        //val must be in this range.
        if (val > 0 && val <= 4) {
            if (val == 4 && val > 3) {
                this.gradeTaken = Grade.A;
            }
            if (val <= 3 && val > 2) {
                this.gradeTaken = Grade.B;
            }
            if (val <= 2 && val > 1) {
                this.gradeTaken = Grade.C;
            }
            if (val <= 1 && val > 0) {
                this.gradeTaken = Grade.D;
            }
            //default
        } else {
            this.gradeTaken = Grade.F;
        }
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment + " CourseCode: " + courseCode + " Credit: " + courseCredit + " " + gradeTaken.printGrade() + '}';
    }
}
