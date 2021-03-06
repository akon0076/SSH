package service;

import entity.Classes;

public interface ClassesService {
    public void save(Classes classes);

    public void updateClass(Classes classes);

    public void removeClass(Integer id);

    public Classes getSingleClass(Integer id);
}
