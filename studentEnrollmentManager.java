import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileWriter;



public class studentEnrollmentManager {
    static ArrayList<studentEnrollment> studentEnrollmentList = new ArrayList<studentEnrollment>();

    // Add new enrollment function
    public static void add(){
        Scanner in = new Scanner(System.in);
        char ans;
        int total;

        do{
            System.out.println("Number of enrollment you want to add: ");   // The total number will be used to generate array
            total = in.nextInt();

            studentEnrollment[] stdEnroll = new studentEnrollment[total];

            for(int index = 0; index < stdEnroll.length; index++){
                stdEnroll[index] = new studentEnrollment();
                System.out.println("Enrollment info");
                System.out.println("Press ENTER to continue");
                in.nextLine();
                System.out.println("Semester");
                stdEnroll[index].setSemester(in.nextLine());

                System.out.println("Student ID");
                stdEnroll[index].setStudentID(in.nextLine());

                System.out.println("Course ID");
                stdEnroll[index].setCourseID(in.nextLine());

                studentEnrollmentList.add(stdEnroll[index]);
                
            }

            System.out.println("Would u like to add more student (y/n)?");  // Allow to add more enrollments
            String answer = in.next();
            ans = answer.charAt(0);

        } while (ans == 'y');
        startMenu.menu();
    }

    // Display all enrollments function
    public static void displayAll(){
        Scanner in = new Scanner(System.in);
        if(studentEnrollmentList.size() == 0){
            System.out.println("List is empty");
            in.nextLine();
        } else {
            for (studentEnrollment studentEnrollment : studentEnrollmentList) {
                System.out.println(studentEnrollment.toString());
            }
            System.out.println("Press ENTER to return to Main Menu");
            in.nextLine();
        } startMenu.menu();
    }

    // Display all courses in one semester function
    public static void displayAllCourseInOneSemester(){
        Scanner in = new Scanner(System.in);
        String semester;

        if(studentEnrollmentList.size() == 0){
            System.out.println("List is empty");
            in.nextLine();
        } else {
            System.out.println("Enter semester: ");
            semester = in.nextLine();

            for(int i=0; i<studentEnrollmentList.size(); i++){
                if(semester.equals(studentEnrollmentList.get(i).getSemester())){
                    System.out.println("Course ID in selected semester: " + studentEnrollmentList.get(i).getCourseID().toString());
    
                } 
            } System.out.println("Press ENTER to return to Main Menu"); 
            in.nextLine();
        } startMenu.menu();
        
    }

    // Display all students in one course
    public static void displayAllStudentInOneCourse(){
        Scanner in = new Scanner(System.in);
        String course;

        if(studentEnrollmentList.size() == 0){
            System.out.println("List is empty");
            in.nextLine();
        } else {
            System.out.println("Enter course: ");
            course = in.nextLine();

            for(int i=0; i<studentEnrollmentList.size(); i++){
                if(course.equals(studentEnrollmentList.get(i).getCourseID())){
                    System.out.println("Student ID in selected semester: " + studentEnrollmentList.get(i).getStudentID().toString());
                
                } 
            } System.out.println("Press ENTER to return to Main Menu"); 
            in.nextLine();
        }
        startMenu.menu();
    }

    // Display all courses of one student function
    public static void displayAllCourseOfOneStudent(){
        Scanner in = new Scanner(System.in);
        String student;

        if(studentEnrollmentList.size() == 0){
            System.out.println("List is empty");
            in.nextLine();
        } else {
            System.out.println("Enter student ID: ");
            student = in.nextLine();

            for(int i=0; i<studentEnrollmentList.size(); i++){
                if(student.equals(studentEnrollmentList.get(i).getStudentID())){
                    System.out.println("Course ID of selected student: " + studentEnrollmentList.get(i).getCourseID().toString());
                } 
            } System.out.println("Press ENTER to return to Main Menu");     
            in.nextLine();
        } startMenu.menu();
        
    }

    // Update enrollment method
    public static void updateStudentEnrollment(){
        Scanner in = new Scanner(System.in);
        String sem;
        String cou;
        String idNum = new String();

        if(studentEnrollmentList.size() == 0){
            System.out.println("List is empty");
            in.nextLine();
        } else {
            System.out.println("Enter student ID");
            idNum = in.nextLine();

            for(int x=0; x<studentEnrollmentList.size(); x++){
                if(idNum.equals(studentEnrollmentList.get(x).getStudentID())){
                    System.out.println("Enter semester: ");
                    sem = in.nextLine();
                    studentEnrollmentList.get(x).setSemester(sem);
                    
                    System.out.println("Enter course ID: ");
                    cou = in.nextLine();
                    studentEnrollmentList.get(x).setCourseID(cou);
                    
                }
            } 
        } System.out.println("Student not found, return to Main Menu"); // If the student ID is not found 
        startMenu.menu();

    }

    // Delete enrollment function
    public static void deleteEnrollment(){
        Scanner in = new Scanner(System.in);
        String idNum;
        
        if(studentEnrollmentList.size() == 0){
            System.out.println("List is empty");
            System.out.println("Press ENTER to return to Main Menu");
            in.nextLine();
            startMenu.menu();
        } else {
            System.out.println("enter student ID");
            idNum = in.nextLine();

            for(int x=0; x<=studentEnrollmentList.size(); x++){
                if(idNum.equals(studentEnrollmentList.get(x).getStudentID())){
                    studentEnrollmentList.remove(x);
                    System.out.println("Removed enrolment information of ID: " + idNum);
                    System.out.println("Return to Main Menu");
                    break;

                    // if(studentEnrollmentList.size() == 0){
                    //     System.out.println("List empty");
                    //     startMenu.menu();
                    // } else{
                    //     System.out.println("Continue deleting by enter Student ID, or press ENTER to return to Main Menu");
                    //     idNum = in.nextLine();
                    // }
                    
                }
                else{
                    System.out.println("Student not found, return to Main Menu"); 
                    startMenu.menu();
                }
            } 
            startMenu.menu();
        }

     
    }

    // Print out data
    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";

    private static final String HEADER = "Semester,StudentID,CourseID";

    // Print out data function
    public static void printOutData(){
        FileWriter file = null;
        try{
            file = new FileWriter("OutputData.csv");
            // Add header
            file.append(HEADER);
            // Add a new line after header
            file.append(SEPARATOR);
            // Iterate through studentList
            Iterator it = studentEnrollmentList.iterator();
            while(it.hasNext()){
                studentEnrollment stdEnrollment = (studentEnrollment)it.next();
                file.append(stdEnrollment.getSemester());
                file.append(DELIMITER);
                file.append(stdEnrollment.getStudentID());
                file.append(DELIMITER);
                file.append(stdEnrollment.getCourseID());
                file.append(SEPARATOR);
            }
            file.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // Notification
        System.out.println("Data printed to OutPut.csv file");
        // Return to main menu
        startMenu.menu();
    }

    
    

}