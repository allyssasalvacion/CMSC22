package studentdb2;

/*
  Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 13 Oct 2016.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public class StudentTesting {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        int choice;
        boolean hasSaved = false;
        try {
            FileInputStream file = new FileInputStream("db.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            // Storing all Students unto the list
            studentList = (List<Student>) in.readObject();
            in.close();
            file.close();
        } catch (IOException e) {
            //e.printStackTrace();
            //return;
        } catch(ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        do {
            boolean hasDeleted = false;
            boolean hasFound = false;

            System.out.println("Menu: \n" +
                    " 1. Register information \n" +
                    " 2. Retrieve information \n" +
                    " 3. Delete information \n" +
                    " 4. Save information profile \n" +
                    " 5. Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // Register information
                    System.out.print("Student Number: ");
                    String studentNumber = sc.nextLine();
                    checker(studentNumber, studentList);
                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Middle Initial: ");
                    String tempMiddleInitial = sc.nextLine();
                    char middleInitial = tempMiddleInitial.toCharArray()[0];
                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Crush Name: ");
                    String crushName = sc.nextLine();
                    System.out.print("Year Level: ");
                    String temp_yearLevel = sc.nextLine();
                    int yearLevel = Integer.parseInt(temp_yearLevel);
                    System.out.print("Favorite Course Name: ");
                    String courseName = sc.nextLine();
                    System.out.print("Favorite Course Description: ");
                    String courseDescription = sc.nextLine();
                    Course faveSubject = new Course(courseName, courseDescription);

                    studentList.add(new Student(studentNumber, firstName, middleInitial, lastName, course, yearLevel, crushName, faveSubject));
                    System.out.println("Student added!");
                    hasSaved = false;
                    break;
                case 2: // Retrieve information
                    System.out.print("Search Student Number: ");
                    String toFind = sc.next();

                    // Find on the list
                    for(Student stud : studentList) {
                        if (stud.getStudentNumber().equals(toFind)) {
                            System.out.println(stud);
                            hasFound = true;
                            break;
                        }
                    }
                    if (!(hasFound)) {
                        System.out.println("Student " + toFind + " is not in the roster.");
                    }
                    break;
                case 3: // Delete information
                    System.out.print("Delete Student Number: ");
                    String tempStudentNumber = sc.next();
                    for(Student stu : studentList){
                        if (stu.getStudentNumber().equals(tempStudentNumber)) {
                            studentList.remove(stu);
                            System.out.println("Student deleted!");
                            hasDeleted = true;
                            hasSaved = false;
                            break;
                        }
                    }
                    if (!(hasDeleted)) {
                        System.out.println("Error! " + tempStudentNumber + " is not in the database.");
                    }
                    break;
                case 4: // Save information profile
                    try {
                        FileOutputStream fo = new FileOutputStream("db.txt");
                        ObjectOutputStream out = new ObjectOutputStream(fo);
                        out.writeObject(studentList);
                        out.close();
                        fo.close();
                        hasSaved = true;
                        System.out.println("Done!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    int willSave = 1;
                    if (!(hasSaved || studentList.isEmpty())) {
                        System.out.println("Warning! You have not saved your profile/s. Do you still wish to exit? \n" +
                                " 1. Yes \n" +
                                " 2. No");
                        willSave = sc.nextInt();
                    }
                    if (willSave == 2){
                        break;
                    }
                    else {
                        System.out.println("Thank you for using our software!");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input!");
            }
        } while (choice != 5);
    }

    private static void checker(String studentNumber, List<Student> studentList) {
        for(Student s : studentList){
            if (s.getStudentNumber().equals(studentNumber)) {
                throw new IllegalArgumentException("Student Number already exists in list.");
            }
        }
    }
}