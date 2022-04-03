public class Course{
    private String id;
    private String name;
    private String numberOfCredit;

    public Course(String id, String name, String numberOfCredit) {
        this.id = id;
        this.name = name;
        this.numberOfCredit = numberOfCredit;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfCredit() {
        return this.numberOfCredit;
    }

    public void setNumberOfCredit(String numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }
    
    @Override
    public String toString(){
        return "Course [id=" + id + ", name=" + name + ", numberOfCredit=" + numberOfCredit + "]";
    }

}