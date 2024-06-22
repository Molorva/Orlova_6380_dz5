package service;

import controller.StudentController;
import model.DB.DataBase;
import model.StudentGroup;
import model.impl.Student;
import model.impl.Teacher;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGroupService {

    StudentController studentController = new StudentController();

    static int id = 0;

    public StudentGroup createStudentGroup(Teacher teacher, List<Student> grope){
        id++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько студентов хотите добавить в группу: ");
        int count = scanner.nextInt();
        while (count > 0){
            System.out.println("Введите id студента: ");
            int idSt = scanner.nextInt();
            Student student = studentController.getById(idSt);
            if(student == null){
                System.out.println("Нет студента с таким индексом! Укажите другой, пожалуйста.");
                continue;
            }
            if (grope.contains(student)){
                System.out.println("Этот студент уже добавлен в группу, укажите другого!");
                continue;
            }
            grope.add(student);
            count--;
        }
        StudentGroup res = new StudentGroup(id, teacher, grope);
        DataBase.studentGroupsDB.add(res);
        return res;
    }

    public int getIdStudentGroup(StudentGroup group) {
        return group.getId();
    }

    public void removeGropeId(int ind) throws Exception{
        id--;
        if(DataBase.studentGroupsDB.get(ind-1) == null){throw new Exception("Группа не найдена"); }
        DataBase.studentGroupsDB.remove(ind-1);
    }

    public int getGroupsCount(){
        return id;
    }

    public StudentGroup getStudentGroupById(int id) throws Exception {
        StudentGroup studentGroup = DataBase.studentGroupsDB//список студентов
                .stream()//запускаем поток для вычислений
                // пример лямда-выражения (s -> s.getId() == id)
                .filter(s -> s.getId() == id)//вызываем метод filter фильтруя по условию (s = student(переменная))
                .findFirst()//вернуть первого найденого студента
                .orElse(null);// если не нашли вернуть null (orElse закрывет поток stream)
        if (studentGroup == null) {
            throw new Exception("Группа не найден");//выбрасываем проверяемое исключение, которое компилятор требует отработать
        }
        return studentGroup;
    }
    public List<StudentGroup> getAllStudentsGroup(){
        List<StudentGroup> res = DataBase.studentGroupsDB;
        System.out.println(res);
        return res;
    }


}

