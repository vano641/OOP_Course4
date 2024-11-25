package model;

public class Teacher extends User{
    
    private int teacherId;


    public Teacher(String firstName, String lastName, String middleName, int teacherId) {
        super(firstName, lastName, middleName);
        this.teacherId = teacherId;
    }


    public int getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }


}
