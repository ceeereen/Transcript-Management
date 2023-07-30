package hw3.util;

public enum Grade {
    A("A", 4),
    B("B", 3),
    C("C", 2),
    D("D", 1),
    F("F", 0);

    private final String stringValue;
    private final int numericValue;

    private Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public int getNumericValue() {
        return numericValue;
    }

    @Override
    public String toString() {
        return "Grade." + name() + " - Letter Grade: " + stringValue + ", Numeric Grade: " + numericValue;
    }

    //in order to print Grade: name in CourseGrade class.
    public String printGrade() {
        return "Grade: " + name();
    }
    //gradeTaken is in type of double
    public static Grade setGradeTaken(double val) {
        //val must be in this range.
        if (val > 0 && val <= 4) {
            if (val == 4 && val > 3) {
                return Grade.A;
            }
            if (val <= 3 && val > 2) {
                return Grade.B;
            }
            if (val <= 2 && val > 1) {
                return Grade.C;
            }
            if (val <= 1 && val > 0) {
               return Grade.D;
            }
            //default
        } else {
            return Grade.F;
        }
        return null;
    }


}
