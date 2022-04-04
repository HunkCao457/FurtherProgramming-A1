import java.util.Scanner;


public class startMenu {
    public static void menu(){
       
            Scanner in = new Scanner(System.in);
            Scanner in1 = new Scanner(System.in);

            int choice = 0;
            String option;

            // Menu layout
            System.out.print("*********STUDENT RECORD SYSTEM*********\n\n");
            System.out.println("\t MENU ");
            System.out.println("[1]- UPLOAD DATA -[1]");
            System.out.println("[2]- GET ALL STUDENT DATA FROM UPLOADED FILE -[2]");
            System.out.println("[3]- GET ALL COURSE DATA FROM UPLOADED FILE -[3]");
            System.out.println("[4]- GET SPECIFIC STUDENT INFORMATION -[4]");
            System.out.println("[5]- GET SPECIFIC COURSE INFORMATION -[5]");
            System.out.println("[6]- ADD ENROLLMENT INFORMATION -[6]");
            System.out.println("[7]- DISPLAY ALL ENROLMENT INFORMATION -[7]");
            System.out.println("[8]- DISPLAY ALL COURSES OF ONE STUDENT -[8]");
            System.out.println("[9]- DISPLAY ALL STUDENT IN ONE COURSE -[9]");
            System.out.println("[10]- DISPLAY ALL COURSES IN ONE SEMESTER -[10]");
            System.out.println("[11]- UPDATE ENROLLMENT INFORMATION -[11]");
            System.out.println("[12]- DELETE ENROLLMENT INFORMATION -[12]");
            System.out.println("[13]- PRINT OUT ENROLLMENT LIST -[13]");
            System.out.println("[14]- EXIT -[14]");
            System.out.println("***************-----***************");

            // Take input from user
            System.out.println("Your option (1-14): ");
            choice = in.nextInt();
            
            // Choice option
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
                studentEnrollmentManager.printOutData();
            }

            else if (choice == 14){
                System.exit(0);
            }

            else{
                System.out.println("Option not defined");
                menu();
            }

    }
   
}
