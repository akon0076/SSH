package service.impl;

import dao.ClassesDao;
import entity.Classes;
import service.ClassesService;

public class ClassesServiceImpl implements ClassesService {
    private ClassesDao classDao;

    public void setClassesDao(ClassesDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public void save(Classes classes) {
        classDao.save(classes);
    }

    @Override
    public void updateClass(Classes classes) {
        classDao.updateClass(classes);
    }

    @Override
    public void removeClass(Integer id) {
        classDao.removeClass(id);
    }

    @Override
    public Classes getSingleClass(Integer id) {
        return classDao.getSingleClass(id);
    }
}
