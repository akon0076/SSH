package service.impl;

import dao.StudentDao;
import entity.Classes;
import entity.Student;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao;
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void removeStudent(Integer id) {
        studentDao.removeStudent(id);
    }

    @Override
    public List<Classes> getClasses() {
        return studentDao.getClasses();
    }

    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    @Override
    public Student getSingleClass(Integer id) {
        return studentDao.getSingleClass(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public List<Student> searchStudents(String classes, String condition, String type, String string) {
        return studentDao.searchStudents(classes, condition, type, string);
    }
}
