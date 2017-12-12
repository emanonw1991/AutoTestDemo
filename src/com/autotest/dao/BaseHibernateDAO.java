package com.autotest.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.autotest.dao.HibernateSessionFactory;

/**
 * ����DAO��ӿ�
 * @author emanon
 *
 */
public class BaseHibernateDAO {
	//���
	protected void add(Object object) {
		Transaction tran = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			session.save(object);
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	//��ȡ
	protected Object get(Class c, Serializable id) {
		Object object = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			object = session.get(c, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return object;
	}
	
	//ɾ��
	protected void detele(Object object) {
		Transaction tran = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			session.delete(object);
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	//����
	protected void update(Object object) {
		Transaction tran = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			tran = session.beginTransaction();
			session.update(object);
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	//����
	protected List search(Class c, Object condition) {
		Session session = null;
		List list = null;
		try {
			session = HibernateSessionFactory.getSession();
			list = session.createCriteria(c).add(Example.create(condition)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return list;
	}
}
