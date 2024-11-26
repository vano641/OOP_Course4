package controller;

import java.util.List;

import model.Student;
import model.Type;
import model.User;
import service.DataService;
import view.StudentView;

public class Controller {
    
    private final DataService service = new DataService(); // поле сервис

    private final StudentView view = new StudentView(); // экземпляр для вывода данных в консодь
// метод создания студента
    public void createStudent(String firstName, String lastName, String middleName){
        service.create(firstName, lastName, middleName, Type.STUDENT);
    }
// метод возвращение всех студентов в сервисе
    public void getAllStudents(){
        List<User> userList = service.getAllStudents(); // получаем список студентов
        for (User i : userList) { // i - класса User
            Student student = (Student) i; // меняем класс у i на Student
            // чтобы можно было передать во view
            view.printOnConsole(student);
        }
    }
}
