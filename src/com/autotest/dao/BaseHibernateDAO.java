package com.autotest.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.autotest.dao.HibernateSessionFactory;

/**
 * 基础DAO层接口
 * @author emanon
 *
 */
public class BaseHibernateDAO {
	//添加
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
	
	//获取
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
	
	//删除
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
	
	//更新
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
	
	//搜索
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
