package hw3.main;

import hw3.util.Grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GenerateTranscript {

    public GenerateTranscript() {
    }

    //with user entry define courseGrade info
    public void takeInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter studentID:");
        int studentID = scanner.nextInt();
        Transcript transcript = new Transcript(studentID);

        //number of courses that user want to enter for a student
        int courseNumber;
        System.out.println("How many courses do you want to add?");
        courseNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < courseNumber; i++) {
            System.out.println("Enter Department: ");
            String courseDepartment = scanner.nextLine();
            System.out.println("Enter course code: ");
            int courseCode = scanner.nextInt();
            System.out.println("Enter course credit: ");
            int courseCredit = scanner.nextInt();
            System.out.println("Enter grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine();
            //add course object to Transcriot
            transcript.addCourseTaken(new CourseGrade(courseDepartment, courseCode, courseCredit, grade));
        }
        // Print the transcript information
        System.out.println(transcript.toString());
    }

    public void takeInputFromFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the input file:");
        //"D:\\Allianz\\2-Java Homeworks\\hw3\\hw3\\src\\hw3\\main\\transcriptInfo.txt"; ENTER in this FORMAT
        String fileName = scanner.nextLine();


        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the student ID from the first line of the file
            int studentID = Integer.parseInt(bufferedReader.readLine());
            Transcript transcript = new Transcript(studentID);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split each line into department, course code, credit, and grade
                String[] courseInfo = line.split(" ");
                if (courseInfo.length == 4) {
                    String courseDepartment = courseInfo[0];
                    int courseCode = Integer.parseInt(courseInfo[1]);
                    int courseCredit = Integer.parseInt(courseInfo[2]);
                    double grade = Double.parseDouble(courseInfo[3]);

                    transcript.addCourseTaken(new CourseGrade(courseDepartment, courseCode, courseCredit,Grade.setGradeTaken(grade)));
                }
            }

            bufferedReader.close();

            // Print the transcript information
            System.out.println(transcript.toString());
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid data format in the file: " + e.getMessage());
        }
    }

}
