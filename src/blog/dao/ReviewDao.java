package blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository("reviewDao")
public class ReviewDao implements BaseDao{

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void saveObject(Object obj) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			session.close();
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List query(String HQLString) throws HibernateException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(HQLString);
		List list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List query(String HQLString, int number) throws HibernateException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(HQLString);
		query.setFirstResult(0);
		query.setMaxResults(number);
		List list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List queryByItem(String column, String condition) throws HibernateException {
		String HQLString = "from Review r where r."+column+condition;
		return query(HQLString);
	}

	@SuppressWarnings("unused")
	@Override
	public void update(String HQLString) {
		Session session = sessionFactory.openSession();
		Transaction ts = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(HQLString);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			if(ts!=null)
				ts.rollback();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void update(String column, String mode, String condition, String set) throws HibernateException {
		String HQLString = "from Review r "+set+" where r."+column+condition;
		update(HQLString);
		
	}

	@Override
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	public int exceBySQL(String sql) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		SQLQuery query= session.createSQLQuery(sql);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
