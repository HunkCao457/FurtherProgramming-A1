import java.io.BufferedReader; 
import java.io.IOException;
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;
import java.util.Scanner;

public class studentList {
    // Get specific student information
    public static void getStudent(String dataFile){
        List<Student> students = readStudentFromCSV(dataFile);
        Scanner in = new Scanner(System.in);
        String stdID;

        if(students.size() == 0){
            System.out.println("List is empty");
            in.nextLine();
        } else{
            System.out.println("Enter student ID");
            stdID = in.nextLine();

            for(int i =0; i<students.size(); i++){
                if(stdID.equals(students.get(i).getId())){
                    System.out.println("Full name is: " + students.get(i).getName().toString());
                    System.out.println("BirthDay is: " + students.get(i).getBirthDate().toString());
                    break;
                } 
            }
            System.out.println("Press ENTER to return to main menu");
            in.nextLine(); 
            startMenu.menu();

        }
    }

    // Display all students
    public static void readAllStudent(String dataFile){
        List<Student> students = readStudentFromCSV(dataFile);
        for(Student std : students){
            System.out.println(std);
        } startMenu.menu();

    }

    // Read students data from .csv file
    public static List<Student> readStudentFromCSV(String fileName) {
        List<Student> students = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
            String[] attributes = line.split(",");
            Student student = createStudent(attributes);
        
                students.add(student);
        
                line = br.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
            return students;
    }
    // Create student information structure
    private static Student createStudent(String[] metadata) { 
        String id = metadata[0]; 
        String name = metadata[1]; 
        String birthDate = metadata[2]; 
                
        // create and return student of this metadata 
        return new Student(id, name, birthDate); 
    }

}
