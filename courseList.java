import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;
import java.util.Scanner;

public class courseList {

    public static void getCourse(String dataFile){
        List<Course> courses = readCourseFromCSV(dataFile);
        Scanner in = new Scanner(System.in);
        String courseID;

        if(courses.size() == 0){
            System.out.println("List is empty");
            in.nextLine();
        } else{
            System.out.println("Enter course ID");
            courseID = in.nextLine();

            for(int i =0; i<courses.size(); i++){
                if(courseID.equals(courses.get(i).getId())){
                    System.out.println("Course name is: " + courses.get(i).getName().toString());
                    System.out.println("Number of credit is: " + courses.get(i).getNumberOfCredit().toString());
                    break;
                } 
            } System.out.println("Press ENTER to return to main menu");
            in.nextLine(); 
            startMenu.menu();

        }
    }

    public static void readAllCourse(String dataFile){
        List<Course> courses = readCourseFromCSV(dataFile);
        for(Course crs : courses){
            System.out.println(crs);
        } startMenu.menu();

    }

    public static List<Course> readCourseFromCSV(String fileName) {
        List<Course> courses = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
    
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");
                Course course = createCourse(attributes);
    
                courses.add(course);
    
                line = br.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return courses;
    }

    private static Course createCourse(String[] metadata) { 
        String id = metadata[3]; 
        String name = metadata[4]; 
        String numberOfCredit = metadata[5]; 
        
        // create and return book of this metadata 
        return new Course (id, name, numberOfCredit); 
    }

}
