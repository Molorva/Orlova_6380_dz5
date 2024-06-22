package controller;

import model.impl.Teacher;
import service.TeacherService;

import java.util.List;

public class TeacherController {

    private TeacherService service = new TeacherService();

    public Teacher creteTeacher(String name, String lastName){
        return service.createTeacher(name, lastName);
    }

    public Teacher getById(int id){

        Teacher teacher = null;
        try {
            teacher = service.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }

    public List<Teacher> getAllTeachers(){
        return  service.getAllTeachers();
    }

    public Teacher getTeacher(int id){
        return  service.getTeacher(id);
    }

}
