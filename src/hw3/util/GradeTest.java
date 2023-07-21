package hw3.util;

import java.util.ArrayList;

public class GradeTest {

    public static void main(String[] args) {

        //holds values of Enum
        Grade[] gradeList = Grade.values();

        //with this loop grades will shown starting with F
        for (int i = gradeList.length - 1; i >= 0; i--) {
            System.out.println("Grade " + gradeList[i].getStringValue() + " corresponds to numeric grade " + gradeList[i].getNumericValue());

        }
    }
}
