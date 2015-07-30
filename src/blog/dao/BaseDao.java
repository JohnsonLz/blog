package blog.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface BaseDao {
	
	public void saveObject(Object obj) throws HibernateException;
	
	public List query(String HQLString) throws HibernateException;
	
	public List query(String HQLString, int number) throws HibernateException;
	
	public List queryByItem(String column, String condition ) throws HibernateException;
	
	public void update(String HQLString);
	
	public void update(String column, String mode, String condition, String set) throws HibernateException;
	
	public Session getSession();
	
	public int exceBySQL(String sql);

}
