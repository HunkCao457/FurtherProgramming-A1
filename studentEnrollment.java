public class studentEnrollment {
    private String semester;
    private String studentID;
    private String courseID;

    public studentEnrollment(){
        String semester;
        String studentID;
        String courseID;
    }

    public studentEnrollment(String semester, String studentID, String courseID) {
        this.semester = semester;
        this.studentID = studentID;
        this.courseID = courseID;
    }

    public String getSemester() {
        return this.semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return this.courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString(){
        return "semester=" + semester + "," + " courseID=" + courseID + "," + " stdID=" + studentID;
    }

}
