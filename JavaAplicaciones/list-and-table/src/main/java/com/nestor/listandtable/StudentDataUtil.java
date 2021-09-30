package com.nestor.listandtable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class StudentDataUtil {
    private List<Student> students;

    public StudentDataUtil() {
        loadSampleData();
    }

    public void loadSampleData() {
        students = new ArrayList<>();
        students.add(new Student("Student1", "Public", "abc@abc.com"));
        students.add(new Student("Student2", "Public", "abc@abc.com"));
        students.add(new Student("Student3", "Public", "abc@abc.com"));
    }

    public List<Student> getStudents() {
        return students;
    }
}
