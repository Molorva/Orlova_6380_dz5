package model;

import model.impl.Student;
import model.impl.Teacher;

import java.util.List;

public class StudentGroup {
    int id;
    protected Teacher teacher;
    protected List<Student> grope;

    public StudentGroup(int id, Teacher teacher, List<Student> grope) {
        this.id = id;
        this.teacher = teacher;
        this.grope = grope;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", grope=" + grope +
                '}';
    }
}

