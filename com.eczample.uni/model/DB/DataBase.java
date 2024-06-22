package model.DB;

import java.util.ArrayList;
import java.util.List;

import controller.StudentController;
import controller.TeacherController;
import model.StudentGroup;
import model.impl.Student;
import model.impl.Teacher;
import service.StudentService;
import service.TeacherService;

//симулирует базу данных
public class DataBase {
    public static final List<Student> studentsDB = new ArrayList<>();
    public static final List<StudentGroup> studentGroupsDB = new ArrayList<>();
    public static final List<Teacher> teachersDB = new ArrayList<>();
    private static TeacherController teacherController = new TeacherController();
    private static StudentController studentController = new StudentController();

    public static void fillDB(){
        teacherController.creteTeacher("Вася", "Иванов");
        teacherController.creteTeacher("Маша", "Смирнова");
        teacherController.creteTeacher("Наталья", "Зайцева");
        studentController.createStudent("Рикон", "Старк", 1);
        studentController.createStudent("Джофри", "Ланистер", 1);
        studentController.createStudent("Петя", "Мурзиков",2);
        studentController.createStudent("Мать", "Драконов",2);
    }
}
