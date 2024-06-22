package service;

import model.DB.DataBase;
import model.impl.Teacher;

import java.util.List;

public class TeacherService {


    public Teacher createTeacher(String name, String lastName){
        int id;
        int size = DataBase.teachersDB.size();
         id = size + 1;
//        if(size == 0){
//            id = 1;
//        } else {
//            id = size + 1;
//        }
        Teacher teacher = new Teacher(id,name,lastName);
        DataBase.teachersDB.add(teacher);
        return teacher;

    }

    public Teacher getById(int id) throws Exception {
        Teacher teacher = DataBase.teachersDB//список студентов
                .stream()//запускаем поток для вычислений
                // пример лямда-выражения (s -> s.getId() == id)
                .filter(s -> s.getId() == id)//вызываем метод filter фильтруя по условию (s = student(переменная))
                .findFirst()//вернуть первого найденого студента
                .orElse(null);// если не нашли вернуть null (orElse закрывет поток stream)
        if (teacher == null) {
            throw new Exception("Учитель не найден");//выбрасываем проверяемое исключение, которое компилятор требует отработать
        }
        return teacher;
    }

    public List<Teacher> getAllTeachers(){
        return  DataBase.teachersDB;
    }

    public Teacher getTeacher(int id){
       return DataBase.teachersDB.get(id);
    }

}
