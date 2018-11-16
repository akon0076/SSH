package dao;

import entity.Classes;

public interface ClassesDao {
    public void save(Classes classes);

    public void updateClass(Classes classes);

    public void removeClass(Integer id);

    public Classes getSingleClass(Integer id);
}
