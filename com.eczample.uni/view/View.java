package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import controller.StudentGroupController;
import controller.TeacherController;
import model.DB.DataBase;
import model.StudentGroup;
import model.impl.Student;
import model.impl.Teacher;

public class View {
    private StudentController studentController = new StudentController();
    private TeacherController teacherController = new TeacherController();
    private StudentGroupController studentGroupController = new StudentGroupController();

    public void start(){
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать студента");
            System.out.println("2 - найти студента по id");
            System.out.println("3 - распечатать информацию о всех студентах");
            System.out.println("4 - создать учителя");
            System.out.println("5 - найти учителя по id");
            System.out.println("6 - распечатать информацию о всех учителях");
            System.out.println("7 - добавить учебную группу");
            System.out.println("8 - распечатать количество студенческих групп");
            System.out.println("9 - удалить студенческую группу");
            System.out.println("10 - распечатать информацию о группе по ее id");
            System.out.println("11 - распечатать информацию о всех группах");
            System.out.println("12 - выход");
            
            switch (scanner.nextInt()) {
                case 1 -> createStudent();
                case 2 -> getByIdStudent();
                case 3 -> getAllStudents();
                case 4 -> createTeacher();
                case 5 -> getByIdTeacher();
                case 6 -> getAllTeachers();
                case 7 -> createStudentsGroup();
                case 8 -> getCountStudentGroups();
                case 9 -> removeStudentGroup();
                case 10 -> getStudentGroupById();
                case 11 -> getAllStudentsGroup();
                case 12 -> System.exit(0);// выход из приложения
                default -> System.out.println("Операция не поддерживается");
            }
        }

    }

    private Student createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите номер группы:");
        int groupId = scanner.nextInt();
        Student student = studentController.createStudent(name, lastName, groupId);
        System.out.println(student);
        return student;
        
    }

    private Student getByIdStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id студента: ");
        int id = scanner.nextInt();
        Student student = studentController.getById(id);
        System.out.println(student);
        return student;
    }

    private List<Student> getAllStudents(){
        List<Student> students = studentController.getAllStudents();
        System.out.println(students);
        return students;
    }

    private Teacher createTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();
        Teacher teacher = teacherController.creteTeacher(name, lastName);
//        System.out.println(teacher);
        return teacher;
    }

    private Teacher getByIdTeacher(){
        System.out.println("Введите id учителя: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Teacher teacher = teacherController.getById(id);
        System.out.println(teacher);
        return teacher;
    }

    private List<Teacher> getAllTeachers(){
        List<Teacher> teachers= teacherController.getAllTeachers();
        System.out.println(teachers);
        return teachers;
    }

    private int getCountStudentGroups(){
        int res = studentGroupController.getGroupsCount();
        System.out.println("Сейчас существует "+ res + " групп");
        return res;
    }

    private void createStudentsGroup(){
        Teacher teacher = getByIdTeacher();
        if (teacher == null){
            System.out.println("Введите индекс существующего учителя!");
            teacher = getByIdTeacher();
        }
        System.out.println(studentGroupController.createStudentGroup(teacher, new ArrayList<>()));

    }

    private void removeStudentGroup(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id группы: ");
        int id = scanner.nextInt();
        StudentGroup sg = studentGroupController.getStudentGroupById(id);
        System.out.println("Вы удалили группу: " + sg);
        studentGroupController.removeGropeId(id);
    }

    private StudentGroup getStudentGroupById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id группы: ");
        int id = scanner.nextInt();
        StudentGroup res = studentGroupController.getStudentGroupById(id);
        System.out.println(res);
        return res;
    }

    private List<StudentGroup> getAllStudentsGroup(){
        List<StudentGroup> res = studentGroupController.getAllStudentsGroup();
        return res;
    }
}
