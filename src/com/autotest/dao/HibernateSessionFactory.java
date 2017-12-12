package com.autotest.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate工厂
 * @author emanon
 *
 */
public class HibernateSessionFactory {
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	//线程池
	private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();
	private static Configuration configuration = new Configuration();
	private static SessionFactory sessionFactory;
	private static String configFile = CONFIG_FILE_LOCATION;
	static {
		try {
			sessionFactory = configuration.configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	private HibernateSessionFactory() {}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void rebuildSessionFactory() {
		synchronized (sessionFactory) {
			try {
				sessionFactory = configuration.configure(configFile).buildSessionFactory();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}
	//获取Session
	public static Session getSession() {
		Session session = (Session) sessionThreadLocal.get();
		try {
			if (session == null || !session.isOpen()) {
				if (sessionFactory == null) {
					rebuildSessionFactory();
				}
				session = (sessionFactory != null) ? sessionFactory.openSession() : null;
				sessionThreadLocal.set(session);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return session;
	}
	public static void closeSession() {
		Session session = (Session) sessionThreadLocal.get();
		sessionThreadLocal.set(null);
		try {
			if (session != null && session.isOpen()) {
				session.close();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	public static String getConfigFile() {
		return configFile;
	}
	public static void setConfigFile(String configFile) {
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}
}
