package controller;

import model.StudentGroup;
import model.impl.Student;
import model.impl.Teacher;
import service.StudentGroupService;

import java.util.List;

public class StudentGroupController {

    StudentGroupService service = new StudentGroupService();

    public StudentGroup createStudentGroup(Teacher teacher, List<Student> grope){
        return  service.createStudentGroup(teacher,grope);
    }


    public int getGroupsCount(){
        return service.getGroupsCount();
    }
    public int getIdStudentGroup(StudentGroup group){
        return service.getIdStudentGroup(group);
    }

    public void removeGropeId(int id){
       try {
           service.removeGropeId(id);
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }

    public StudentGroup getStudentGroupById(int id){
        StudentGroup studentGroup = null;
        try {
            studentGroup = service.getStudentGroupById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return studentGroup;
    }
    public List<StudentGroup> getAllStudentsGroup(){
        return  service.getAllStudentsGroup();
    }


}
