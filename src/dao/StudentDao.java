package dao;

import entity.Classes;
import entity.Student;

import java.util.List;

public interface StudentDao {
    public void addStudent(Student student);
    public void removeStudent(Integer id);
    public List<Classes> getClasses();
    public List<Student> getStudents();
    public Student getSingleClass(Integer id);
    public void updateStudent(Student student);
    public List<Student> searchStudents(String classes, String condition, String type, String string);
}
