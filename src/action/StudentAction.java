package action;

import com.opensymphony.xwork2.ModelDriven;
import dao.impl.StudentDaoImpl;
import entity.Classes;
import entity.Student;
import org.apache.struts2.interceptor.RequestAware;
import service.ClassesService;
import service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentAction implements RequestAware, ModelDriven<Student> {
    private Student student = new Student();
    private String stuClasses;
    private String condition;
    private String type;
    private String string;
    private HashMap<Integer, String> classes = new HashMap<>();
    private Map<String, Object> request;
    private StudentService studentService;
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    public void setRequest(Map<String, Object> arg0) { this.request = arg0; }

    public String List(){
    	System.out.println("ִ��List");
        request.put("students", studentService.getStudents());
        List<Classes> listClass = studentService.getClasses();
        request.put("clazz", listClass);
        for(Classes classes: listClass) {
            this.classes.put(classes.getId(), classes.getCode());
        }
        request.put("map", classes);
        return "list";
    }
    public String searchStudent(){
        List<Classes> listClass = studentService.getClasses();
        request.put("clazz", listClass);
        for(Classes classes: listClass) {
            this.classes.put(classes.getId(), classes.getCode());
        }
        request.put("map", classes);
        request.put("students", studentService.searchStudents(stuClasses, condition, type, string));
        return "search";
    }

    public String toAddStudent() {
        List<Classes> listClass = studentService.getClasses();
        for(Classes classes: listClass) {
            this.classes.put(classes.getId(), classes.getCode());
        }
        request.put("map", classes);
        return "toAddStudent";
    }

    public String addStudent() {
        studentService.addStudent(this.student);
        return "success";
    }

    public String removeStudent() {
        studentService.removeStudent(this.student.getId());
        System.out.println("ɾ���ɹ�");
        return "success";
    }

    public String getSingleStudent() {
        List<Classes> listClass = studentService.getClasses();
        for(Classes classes: listClass) {
            this.classes.put(classes.getId(), classes.getCode());
        }
        request.put("map", classes);
        this.student = studentService.getSingleClass(this.student.getId());
        return "ToUpdate";
    }

    public String updateStudent() {
        studentService.updateStudent(this.student);
        System.out.println("�޸ĳɹ�");
        return "success";
    }

    public HashMap getClasses() {
        return this.classes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    public String getStuClasses() {
        return stuClasses;
    }

    public void setStuClasses(String stuClasses) {
        this.stuClasses = stuClasses;
    }

    public void setClasses(HashMap<Integer, String> classes) {
        this.classes = classes;
    }


    @Override
    public Student getModel() {
        return this.student;
    }
}