import java.util.Scanner;


public class startMenu {
    public static void menu(){
        // Scanner populateData = new Scanner(System.in);
        // populateData = null;
        // while(populateData != null){
            Scanner in = new Scanner(System.in);
            Scanner in1 = new Scanner(System.in);

            int choice = 0;
            String option;

            System.out.print("*********STUDENT RECORD SYSTEM*********\n\n");
            System.out.println("\t MENU ");
            System.out.println("[1] UPLOAD DATA");
            System.out.println("[2] GET ALL STUDENT DATA FROM UPLOADED FILE");
            System.out.println("[3] GET ALL COURSE DATA FROM UPLOADED FILE");
            System.out.println("[2] ADD ENROLLMENT INFORMATION");
            System.out.println("[3] DISPLAY ALL ENROLMENT INFORMATION");
            System.out.println("[4] DISPLAY ALL COURSES FOR ONE STUDENT");
            System.out.println("[5] DISPLAY ALL STUDENT IN ONE COURSE");
            System.out.println("[6] DISPLAY ALL COURSES IN ONE SEMESTER");
            System.out.println("[7] UPDATE ENROLLMENT INFORMATION");
            System.out.println("[8] DELETE ENROLLMENT INFORMATION");
            System.out.println("[9]EXIT");
            System.out.println("?");

            choice = in.nextInt();
            if (choice == 1) 
            {   
                System.out.println("Enter file name to upload:");
                option = in1.nextLine();
                studentList.readStudentFromCSV(option);
                courseList.readCourseFromCSV(option);
                System.out.println("Data Uploaded");
                menu();   
            } 

            else if (choice == 2){
                System.out.println("Enter file name to get information:");
                option = in1.nextLine();
                studentList.readAllStudent(option);
            }

            else if (choice == 3){
                System.out.println("Enter file name to get information:");
                option = in1.nextLine();
                courseList.readAllCourse(option);
            }

            else if (choice == 4){
                System.out.println("Enter file name to search:");
                option = in1.nextLine();
                studentList.getStudent(option);
            }

            else if (choice == 5){
                System.out.println("Enter file name to search:");
                option = in1.nextLine();
                courseList.getCourse(option);
            }

            else if (choice == 6) 
            {
                studentEnrollmentManager.add();
            }

            else if (choice == 7) 
            {
                studentEnrollmentManager.displayAll();
            }

            else if (choice == 8) 
            {
                studentEnrollmentManager.displayAllCourseOfOneStudent();
            }

            else if (choice == 9)
            {
                studentEnrollmentManager.displayAllStudentInOneCourse();
            }

            else if( choice == 10){
                studentEnrollmentManager.displayAllCourseInOneSemester();
            }

            else if( choice == 11)
            {
                studentEnrollmentManager.updateStudentEnrollment();
            }

            else if (choice == 12){
                studentEnrollmentManager.deleteEnrollment();
            }

            else if (choice == 13){
                System.exit(0);
            }

            else if (choice == 14){
                studentEnrollmentManager.printOutData();
            }

    }
   
}
