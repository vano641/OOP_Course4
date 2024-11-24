public class Student extends User{
    
    private int studentId;


    public Student(String firstName, String lastName, String middleName, int studentId) {
        super(firstName, lastName, middleName);
        this.studentId = studentId;
    }


    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


}
