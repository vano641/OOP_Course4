package service;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

import java.util.List;

public class DataService {
    
    private List<User> userList; // список пользователей

// метод создания пользователя (на вход 4 параметра)
    public void create(String firstName, String lastName, String middleName, Type type ){
        int id = getFreeId(type);
    // если Type - Студент, то создадим нового студентва и добавим в коллекцию
        if (Type.STUDENT == type) {
            Student student = new Student(firstName, lastName, middleName, id);
            userList.add(student);
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(firstName, lastName, middleName, id);
            userList.add(teacher);
        }
    }

// метод чтения (возвращает пользователя)(поиск по id)
    public User getUserById(Type type, int id) {
        boolean itsStudent = Type.STUDENT == type; // проверка кто пришел
        User currentuser = null; // пользователь которого будем возвращать

        for (User i : userList) {
                if (i instanceof Teacher && !itsStudent && ((Teacher) i).getTeacherId() == id) {
                    currentuser = i;
                }
                if (i instanceof Student && itsStudent && ((Student) i).getStudentId() == id) {
                    currentuser = i;
                }
            }
            return currentuser; // возвращаем только что созданного пользователя
    }

// метод возвращения Списка пользователей
    public List<User> getAllUsers(){
        return userList;
    }


// метод по проверке свободного Id
    private int getFreeId(Type type) {
    // проверка это студент? (тип студент == наш тип)
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1; // наше число
        for (User i : userList) {
        // если наш юзер пренадлежит классу учитель, а также itsStudent - false
            if (i instanceof Teacher && !itsStudent) {
        // тогда присваиваем lastId значение teacherId + 1
                lastId = ((Teacher) i).getTeacherId() + 1;
            }
            if (i instanceof Student && itsStudent) {
                lastId = ((Student) i).getStudentId() + 1;
            }
        }
        return lastId;
    }
}
