package test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.autotest.dao.HibernateSessionFactory;
import com.autotest.entity.User;

public class TestAddUser {
	public static void main(String[] args) {
		new TestAddUser().addUser();
	}
	private void addUser() {
		User user = new User();
		user.setLoginName("emanon");
		user.setLoginPassword("emanon1991");
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}
