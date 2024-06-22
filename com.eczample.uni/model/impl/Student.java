package model.impl;

import model.User;

public class Student extends User{

    int groupId;

    public Student(int id, String name, String lastName, int groupId) {
        super(id, name, lastName);
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName()
                + ": id = %s, name = %s, lastName = %s, groupId = %s", id, name, lastName, groupId);
    }
}
