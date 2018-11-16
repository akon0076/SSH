package dao.impl;

import dao.ClassesDao;
import entity.Classes;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class ClassesDaoImpl implements ClassesDao {
    private HibernateTemplate hibernateTemplate;
    public void save(Classes classess){
          this.hibernateTemplate.save(classess);
    }

    public Classes getSingleClass(Integer id) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Classes c = (Classes) session.get(Classes.class, id);
        t.commit();
        session.close();
        sessionFactory.close();
        return c;
    }

    public void updateClass(Classes classes) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        List oldClasses = session.createSQLQuery("select code from Classes  where id = " + classes.getId().toString()).list();
        session.createSQLQuery("update Classes set classes =  " + classes.getCode() + " where classes = "+ oldClasses.get(0));

        session.update(classes);
        t.commit();
        session.close();
        sessionFactory.close();
    }

    public void removeClass(Integer id) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Classes c = (Classes) session.get(Classes.class, id);
        session.delete(c);
        String hql = "delete Student where classes = :classes";
        session.createQuery(hql).setString("classes",c.getCode()).executeUpdate();
        t.commit();
        session.close();
        sessionFactory.close();
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
