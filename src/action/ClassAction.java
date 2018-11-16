package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.impl.ClassesDaoImpl;
import entity.Classes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ClassesService;

import java.util.Map;

public class ClassAction extends ActionSupport implements ModelDriven<Classes> {
    private Classes classes = new Classes();
    private Map<String, Object> request;
    private ClassesService classesService;

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }

    public String addClass() {
        classesService.save(this.classes);
        System.out.println("添加成功");
        return "success";
    }

    public String removeClass() {
        classesService.removeClass(this.classes.getId());
        System.out.println("删除成功");
        return "success";
    }

    public String getSingleClass() {
        this.classes = classesService.getSingleClass(this.classes.getId());
        return "ToUpdate";
    }

    public String updateClass() {
        classesService.updateClass(this.classes);
        System.out.println("修改成功");
        return "success";
    }

    public Classes getClasses() {
        return this.classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }


    @Override
    public Classes getModel() {
        return this.classes;
    }
}
