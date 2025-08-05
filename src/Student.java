public class Student {

    private int id;
    private String name;
    private double marks;

    //Constructor
    public Student(int id, String name,double marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }

    //Setter & Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getMarks(){
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    //toString
    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }


}
