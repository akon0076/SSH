package cn.itcast.dao.impl;
/**
 * 使用hibernate.cfg.xml
 */
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
public class UserDaoImpl implements UserDao {
	// 提供hibernate模板
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public User findById(Integer id) {
		return this.hibernateTemplate.get(User.class, id);
	}
	public List<User> findAll() {
		return null;
		//return this.hibernateTemplate.find("from User");
	}
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}
	public void update(User user) {
		this.hibernateTemplate.update(user);
	}
	public void delete(User user) {
		this.hibernateTemplate.delete(user);
	}
}
/**
 * 不使用hibernate.cfg.xml
 */
// import java.util.List;
// import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
// import cn.itcast.dao.UserDao;
// import cn.itcast.domain.User;
// //继承 HibernateDaoSupport自动生成模板, 必须提供SessionFactory
// public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
// 	public User findById(Integer id) {
// 		return this.getHibernateTemplate().get(User.class, id);
// 		}
// 		public List<User> findAll() {
// 			return this.getHibernateTemplate().find("from User");
// 		}
// 		public void save(User user) {
// 			this.getHibernateTemplate().save(user);
// 		}
// 		public void update(User user) {
// 			this.getHibernateTemplate().update(user);
// 		}
// 		public void delete(User user) {
// 			this.getHibernateTemplate().delete(user);
// 		}
// 	}

/**
 * 使用注解方式
 */
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate3.HibernateTemplate;
//import org.springframework.stereotype.Repository;
//import cn.itcast.dao.UserDao;
//import cn.itcast.domain.User;
//
//@Repository
//public class UserDaoImpl implements UserDao {
//	// 提供hibernate模板
//	@Autowired
//	private HibernateTemplate hibernateTemplate;
//
//	public User findById(Integer id) {
//		return this.hibernateTemplate.get(User.class, id);
//	}
//
//	public List<User> findAll() {
//		return this.hibernateTemplate.find("from User");
//	}
//
//	public void save(User user) {
//		this.hibernateTemplate.save(user);
//	}
//
//	public void update(User user) {
//		this.hibernateTemplate.update(user);
//	}
//
//	public void delete(User user) {
//		this.hibernateTemplate.delete(user);
//	}
//
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//	}
//}
